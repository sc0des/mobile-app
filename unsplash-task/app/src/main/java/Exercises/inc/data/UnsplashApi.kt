package Exercises.inc.data

import Exercises.inc.model.UnsplashItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

// API Authorization

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "AAj3U68_yf3VgozXPCL7MUra99HSxViGI3sgp6-iUno"

interface UnsplashAPIClient {

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos")
    fun fetchPhotos() : Call<List<UnsplashItem>>
}