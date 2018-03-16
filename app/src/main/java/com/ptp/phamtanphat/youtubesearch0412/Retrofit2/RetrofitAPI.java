package com.ptp.phamtanphat.youtubesearch0412.Retrofit2;

/**
 * Created by KhoaPhamPC on 14/3/2018.
 */

public class RetrofitAPI {
    //Noi trung gian thuc hien gui phuong thuc va nhan du lieu
    private static String base_url = "https://www.googleapis.com/youtube/v3/";

    public static DataClient getdata(){
        return RetrofitClient.getClient(base_url).create(DataClient.class);
    }
}
