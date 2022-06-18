package com.mlinde.marvelcomicsapp.api

import android.util.Log
import com.mlinde.marvelcomicsapp.util.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit


object ComicsService {

    val apiService: ApiService = getMarvelApi().create(ApiService::class.java)

    fun getMarvelApi() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(getClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun getClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(getAuthorizationInterceptor())
        return interceptor.build()
    }

    private fun getAuthorizationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val url = chain.request()
                .url
                .newBuilder()
                .addQueryParameter("ts", Constants.timeStamp)
                .addQueryParameter("apikey", Constants.API_KEY)
                .addQueryParameter("hash", Constants.hash())
                .build()
            Log.i("URL INTERCEPTOR", "getAuthorizationInterceptor: $url")
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            return@Interceptor chain.proceed(request)
        }
    }
}