package com.daowei.www.daoweitwo.utils;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * 用来检验Gson生成的实体类，格式是否正确
 * retrofit无法检验Gson的实体类的格式错误
 * added by yulu 2017年2月21日 19:57:16
 */
public class JsonLoader {
	public interface JsonListener{
        void JsonComplete(String json);
	}
	private JsonListener jsonListener;
	//一般用做简单查询
	public void parseJson2String(String url,JsonListener listener){
		this.jsonListener = listener;
		new JsonAsyncTask().execute(url);
	}
	//用做查找结果并显示
	public void parseJson2StringPost(String url,List<String> mParams,JsonListener listener){
		this.jsonListener = listener;
		new JsonAsyncTaskPost(mParams).execute(url);
	}
	class JsonAsyncTask extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			try {
				URL url = new URL(params[0]);
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(5000);
                InputStream in = conn.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				StringBuilder sb = new StringBuilder();
				int length = 0;
				byte[] buf = new byte[1024];
				while((length=bis.read(buf))!=-1){
					String str = new String(buf,0,length);
					sb.append(str);
				}
				bis.close();
				in.close();
				return sb.toString();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			if(null!=result){
				jsonListener.JsonComplete(result);
			}
		}
	}
	class JsonAsyncTaskPost extends AsyncTask<String, Void, String>{
		//参数集合
		private List<String> mParams;
		public JsonAsyncTaskPost(List<String> mParams){
			this.mParams = mParams;
		}
		@Override
		protected String doInBackground(String... params) {
			try {
				URL url = new URL(params[0]);
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				if(mParams!=null){
					OutputStream outputStream = conn.getOutputStream();
					for(String param:mParams){
						outputStream.write(param.getBytes());
					}
					outputStream.flush();
					outputStream.close();
				}
				InputStream in = conn.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				int length = 0;
				byte [] buf = new byte[1024];
				//����StringBuider�����ַ���
				StringBuilder sb = new StringBuilder();
				while((length=bis.read(buf))!=-1){
					String str = new String(buf, 0, length);
					sb.append(str);
				}
				in.close();
				return sb.toString();
			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			if(null!=result){
				jsonListener.JsonComplete(result);
			}
		}
	}

}
