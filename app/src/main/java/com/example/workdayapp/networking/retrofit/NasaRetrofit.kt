package com.example.workdayapp.networking.retrofit

import com.example.workdayapp.networking.response.SearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object NasaRetrofit {

    private const val BASE_URL = "https://images-api.nasa.gov/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofitInstance(): Retrofit {
        return retrofit
    }
}

interface NasaApiService {

    @GET("search")
    fun searchImages(
        @Query("q") query: String,
        @Query("media_type") mediaType: String = "image"
    ): Call<SearchResponse>

}
