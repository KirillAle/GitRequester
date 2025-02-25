//package com.example.gitrequester
//
//interface GitHubApiService {
//    @GET("user")
//    suspend fun getUser(): Response<GitHubUser>
//
//    companion object {
//        fun create(token: String): GitHubApiService {
//            val client = OkHttpClient.Builder()
//                .addInterceptor { chain ->
//                    val request = chain.request().newBuilder()
//                        .addHeader("Authorization", "Bearer $token")
//                        .build()
//                    chain.proceed(request)
//                }
//                .build()
//
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://api.github.com/user")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//
//            return retrofit.create(GitHubApiService::class.java)
//        }
//    }
//}
