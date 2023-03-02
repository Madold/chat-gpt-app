package com.markusw.chatgptapp.di

import com.markusw.chatgptapp.core.utils.Constants
import com.markusw.chatgptapp.data.network.client.ChatGptClient
import com.markusw.chatgptapp.data.network.interceptors.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideChatGptClient(retrofit: Retrofit): ChatGptClient {
        return retrofit.create(ChatGptClient::class.java)
    }

}