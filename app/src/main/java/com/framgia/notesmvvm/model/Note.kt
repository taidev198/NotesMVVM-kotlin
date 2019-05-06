package com.framgia.notesmvvm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by superme198 on 03,May,2019
 * in NotesMVVM.
 *
 */

@Entity(tableName = "note_table")
data class Note(
    var title: String,

    var description: String,

    var priority: Int
) {
    //does it matter if these are private or not?
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}