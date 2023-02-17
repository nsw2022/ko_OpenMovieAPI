package com.example.ko_openmovieapi

import retrofit2.Call
import retrofit2.http.GET

interface MovieRetrofitService {
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=8d2005a80ec441c2f87371c2ff655db0&targetDt=20230215")
    fun movieData(): Call<MovieRank>

}