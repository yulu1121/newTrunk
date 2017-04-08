package com.daowei.www.daoweitwo.utils;

import android.content.Context;

/**
 * created by yulu 2017年2月20日 21:51:24
 */
public class SharedPreferenceUtils {
	public static final String FILE_NAME = "shared";
	//����ַ���
	public static String getString(Context context,String key){
		String text=context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE)
		.getString(key,"");
		return text;
	}
	//�������
	public static int getInt(Context context,String key){
		int n=context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
				.getInt(key,0);
				return n;
	}
	//���С��
	public static float getFloat(Context context,String key){
		float n=context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
				.getFloat(key,0);
				return n;
	}
	//��ò���
	public static long getLong(Context context,String key){
		long n=context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
				.getLong(key,0);
		return n;
	}
	// ֵ
	public static boolean getBoolean(Context context,String key){
		boolean result=context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE)
				.getBoolean(key, false);
				return result;
	}
	//�����ַ���
	public static void saveString(Context context,String key,String value){
		context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE)
		.edit()
		.putString(key, value)
		.apply();
	}
	//��������
	public static void saveInt(Context context,String key,int value){
		context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE)
		.edit()
		.putInt(key, value)
		.apply();
	}
	//���渡��
	public static void saveLong(Context context,String key,long value){
		context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE)
				.edit()
				.putLong(key, value)
				.apply();
	}
	public static void saveFloat(Context context,String key,float value){
		context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE)
		.edit()
		.putFloat(key, value)
		.apply();
	}
	//���沼��
	public static void saveBoolean(Context context,String key,boolean value){
		context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE)
		.edit()
		.putBoolean(key, value)
		.apply();
	}
	public static void deleteString(Context context,String key){
		context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)
				.edit()
				.remove(key)
				.apply();
	}
}
