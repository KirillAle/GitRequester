package com.example.gitrequester.data

import android.media.MediaRouter.UserRouteInfo
import android.media.session.MediaSession.Token
import okhttp3.Response
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApiService {
    @POST("user")
    suspend fun checkAuthToken(
        @Header("Authorization") authToken: String
    ): Response<UserInfo>



}