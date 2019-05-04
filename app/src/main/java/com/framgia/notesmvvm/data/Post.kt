package com.framgia.notesmvvm.data

import com.google.gson.annotations.SerializedName

/**
 * Created by superme198 on 04,May,2019
 * in NotesMVVM.
 *
 */
class Post {
    @SerializedName("id_post")
    var mId: Int = 0
    @SerializedName("id_ca")
    var mIdCa: Int = 0
    @SerializedName("name_ca")
    var mNameCa: String = ""
    @SerializedName("title")
    var mTitle: String = ""
    @SerializedName("description")
    var mDescription: String = ""
    @SerializedName("content")
    var mContent: String = ""
    @SerializedName("datetime")
    var mDatetime: String = ""
    @SerializedName("image")
    var mImage: String = ""

}