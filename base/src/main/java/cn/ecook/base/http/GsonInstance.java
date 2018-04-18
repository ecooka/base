package cn.ecook.base.http;

import com.google.gson.Gson;

/**
 *
 * @author 63062
 * @date 2017/11/29
 */

public class GsonInstance {
    private GsonInstance(){}

    public static Gson instance(){
        return InstanceHolder.instance;
    }

    static class InstanceHolder{
        static final Gson instance = new Gson();
    }
}
