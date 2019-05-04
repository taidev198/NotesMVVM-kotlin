package com.framgia.notesmvvm.data

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by superme198 on 04,May,2019
 * in NotesMVVM.
 *
 */
interface APIService {
    @get:GET("/news/api.php?latest_news=10")
    val posts: Call<List<Post>>
}