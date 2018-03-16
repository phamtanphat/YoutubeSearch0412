package com.ptp.phamtanphat.youtubesearch0412.Retrofit2;

import com.ptp.phamtanphat.youtubesearch0412.Retrofit2.API.YoutubeSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by KhoaPhamPC on 14/3/2018.
 */

public interface DataClient {
    @GET("search")
    Call<YoutubeSearch> searchVideoYoutube(@Query("part") String part, @Query("q") String q
                                        , @Query("maxResults") String maxResults ,@Query("type") String type
                                        ,@Query("key") String key);
}
