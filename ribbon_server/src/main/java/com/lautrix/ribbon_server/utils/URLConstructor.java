package com.lautrix.ribbon_server.utils;

public class URLConstructor {

  public static String url(String domian, String api){

    String urlstr = "http://"+domian+"/"+api;
    return urlstr;

  }

}
