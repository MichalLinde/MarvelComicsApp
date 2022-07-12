package com.mlinde.marvelcomicsapp.di

import android.util.Log
import com.mlinde.marvelcomicsapp.api.ApiService
import com.mlinde.marvelcomicsapp.data.ComicsRepository
import com.mlinde.marvelcomicsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesAuthorizationInterceptor() : Interceptor{
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

    @Singleton
    @Provides
    fun providesOkHttpClient(authorizationInterceptor: Interceptor): OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authorizationInterceptor)
        return interceptor.build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService) = ComicsRepository(apiService)
}