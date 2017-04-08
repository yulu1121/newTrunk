package androidstudy.hezijie.com.okhttp_tool;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hezijie on 2017/2/7.
 */
public class OkHttpTools {
    private Context context;
    private static OkHttpClient mOkHttpClient;
    static{
        mOkHttpClient = new OkHttpClient.Builder().build();
    }
    public static OkHttpBuilder Builder(){
        return new OkHttpBuilder();
    }

    public static class OkHttpBuilder{
        private String url;
        private OkHttpCallBack callBack;
        private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                callBack.getData(msg.obj.toString());
            }
        };

        public OkHttpBuilder url(String url){
            this.url = url;
            return this;
        }

        public OkHttpBuilder get(){
            if(null == url){
                throw new NullPointerException("url is empty");
            }
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = mOkHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Message message = handler.obtainMessage();
                    message.obj = response.body().string();
                    message.sendToTarget();
                }
            });
            return this;
        }
        public void callBack(OkHttpCallBack callBack){
            this.callBack = callBack;
        }
    }

    public interface OkHttpCallBack{
        void getData(String data);
    }

}
