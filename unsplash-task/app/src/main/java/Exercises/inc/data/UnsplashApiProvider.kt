package Exercises.inc.data

import Exercises.inc.MainActivity
import Exercises.inc.data.cb.UnsplashResult
import Exercises.inc.model.UnsplashItem
import Exercises.inc.model.UnsplashSearch
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val TAG = "UnsplashApiProvider"
private const val BASE_URL = "https://api.unsplash.com/"

// API connection

class UnsplashApiProvider {

    private val retrofit by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create<UnsplashAPIClient>()
    }

    fun fetchImages(cb: MainActivity) {
        retrofit.fetchPhotos().enqueue(object : Callback<List<UnsplashItem>> {
            override fun onResponse(call: Call<List<UnsplashItem>>, response: Response<List<UnsplashItem>>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d(TAG, "Response: ${response.body()}")
                    cb.onDataFetchedSuccess(response.body()!!)
                } else {
                    cb.onDataFetchedFailed()
                }
            }

            override fun onFailure(call: Call<List<UnsplashItem>>, t: Throwable) {
                Log.e(TAG, "Error loading images details", t)
                cb.onDataFetchedFailed()
            }
        })
    }

    // Photo Details

    fun fetchPhotoDetails(id: String, cb: MainActivity) {
        retrofit.fetchPhotoDetails(id=id).enqueue(object : Callback<UnsplashSearch> {
            override fun onResponse(call: Call<UnsplashSearch>, response: Response<UnsplashSearch>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d(TAG, "searchImages | response: ${response.body()}")
                    cb.onDataFetchedSuccess(response.body()!!.results)
                } else {
                    cb.onDataFetchedFailed()
                }
            }

            override fun onFailure(call: Call<UnsplashSearch>, t: Throwable) {
                Log.e(TAG, "searchImages | error loading images", t)
                cb.onDataFetchedFailed()
            }
        })
    }
}



