package com.example.userapp.di

import com.example.data.datasource.UsersApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkModuleTest {

    @Test
    fun `providesLoggingInterceptor returns HttpLoggingInterceptor`() {
        val interceptor = NetworkModule.provideLoggingInterceptor()
        assertTrue(interceptor is HttpLoggingInterceptor)
    }

    @Test
    fun `providesOkHttpClient returns OkHttpClient`() {
        val loggingInterceptor = Mockito.mock(HttpLoggingInterceptor::class.java)
        val client = NetworkModule.provideOkHttpClient(loggingInterceptor)
        assertTrue(client is OkHttpClient)
    }

    @Test
    fun `providesConverterFactory returns GsonConverterFactory`() {
        val converterFactory = NetworkModule.provideConverterFactory()
        assertTrue(converterFactory is GsonConverterFactory)
    }

    @Test
    fun `providesRetrofit returns Retrofit`() {
        val converterFactory = Mockito.mock(GsonConverterFactory::class.java)
        val okHttpClient = Mockito.mock(OkHttpClient::class.java)
        val retrofit = NetworkModule.provideRetrofit(converterFactory, okHttpClient)
        assertTrue(retrofit is Retrofit)
    }

    @Test
    fun `providesApiService returns UsersApi`() {
        val converterFactory = Mockito.mock(GsonConverterFactory::class.java)
        val okHttpClient = Mockito.mock(OkHttpClient::class.java)
        val retrofit = NetworkModule.provideRetrofit(converterFactory, okHttpClient)
        val apiService = NetworkModule.provideApiService(retrofit)
        assertTrue(apiService is UsersApi)
    }
}