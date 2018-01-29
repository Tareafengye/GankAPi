package com.tiantianapp.rxjava;


import com.tiantianapp.model.GankUrlBean;
import com.tiantianapp.model.HomeBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dell on 2017/4/1.
 */
public interface IdeaApiService {
    /**
     * 网络请求超时时间毫秒
     */
    int DEFAULT_TIMEOUT = 20000;

    //登录
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("data/{type}/{page}/{index}")
    Observable<GankUrlBean> getLogin(@Path("type") String type, @Path("page") int page, @Path("index")int index);

    /**
     * 上传头像
     *
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("search")
    Observable<GankUrlBean> getSeaerch(@Query("q")String q);


}
