package com.framgia.notesmvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.framgia.notesmvvm.data.Note
import com.framgia.notesmvvm.data.NoteRepository
import java.util.logging.Logger

/**
 * Created by superme198 on 03,May,2019
 * in NotesMVVM.
 *
 */
class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: NoteRepository =
        NoteRepository(application)
    private lateinit var allNotes: LiveData<List<Note>>

    init {
        allNotes.value = arrayListOf()
    }

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun delete(note: Note) {
        repository.delete(note)
    }

    fun update(note: Note) {
        repository.update(note)
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }

    fun deleteAllNotes() {
        repository.deleteAll()
    }

}