package com.framgia.notesmvvm.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.framgia.notesmvvm.model.Note

/**
 * Created by superme198 on 03,May,2019
 * in NotesMVVM.
 *
 */
@Dao
interface NoteDAO {
    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    fun getAllNotes(): LiveData<List<Note>>

}