package com.lautrix.ribbon_service.utils;

public class URLConstructor {

  public static String url(String domian, String api){

    String urlstr = "http://"+domian+"/"+api;
    return urlstr;

  }

}
