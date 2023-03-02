package com.markusw.chatgptapp.data.network.interceptors

import com.markusw.chatgptapp.core.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor():  Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            addHeader("Content-Type", "application/json")
            addHeader("Authorization", "Bearer ${Constants.API_KEY}")
        }.build()

        return chain.proceed(request)
    }
}
