package com.example.ameriabanktask.network

import androidx.annotation.Keep
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(60L, TimeUnit.SECONDS)
    .readTimeout(60L, TimeUnit.SECONDS)
    .build()

@Suppress("unused")
inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonCreatorHelper.gsonForApiRequest)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}

object GsonCreatorHelper {
    val gsonForApiRequest: GsonConverterFactory = GsonConverterFactory.create(
        GsonBuilder()
            .setLenient()
            .enableComplexMapKeySerialization()
            .create()
    )
}

@Keep
interface ApiResultCallback<T> {
    fun onSuccess(response: T)

    fun onError(): Boolean = false

    fun onNotHandledError(error: Any? = null) {}
}
const val BASE_URL= " https://api.github.com/"