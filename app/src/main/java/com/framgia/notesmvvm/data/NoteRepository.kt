package com.framgia.notesmvvm.data

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.framgia.notesmvvm.model.Note

/**
 * Created by superme198 on 03,May,2019
 * in NotesMVVM.
 *
 */
class NoteRepository(application: Application) {

    private var noteDao: NoteDAO

    private var allNotes: LiveData<List<Note>>

    init {
        val dataBase: NoteDataBase = NoteDataBase.getInstance(application.applicationContext)!!
        noteDao = dataBase.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note) {
        val insertNoteAsyncTask = InsertNoteAsyncTask(noteDao).execute(note)
    }

    fun update(note: Note) {
        val updateNoteAsyncTask = UpdateNoteAsyncTask(noteDao).execute(note)
    }

    fun delete(note: Note) {
        val deleteNoteAsyncTask = DeleteNoteAsyncTask(noteDao).execute(note)
    }

    fun deleteAll() {
        val deleteAllNotesAsyncTask = DeleteAllNotesAsyncTask(noteDao).execute()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }

    companion object {
        private class InsertNoteAsyncTask(noteDao: NoteDAO) : AsyncTask<Note, Unit, Unit>() {
            val noteDao = noteDao

            override fun doInBackground(vararg p0: Note?) {
                noteDao.insert(p0[0]!!)
            }
        }

        private class UpdateNoteAsyncTask(noteDao: NoteDAO) : AsyncTask<Note, Unit, Unit>() {
            val noteDao = noteDao

            override fun doInBackground(vararg p0: Note?) {
                noteDao.update(p0[0]!!)
            }
        }

        private class DeleteNoteAsyncTask(noteDao: NoteDAO) : AsyncTask<Note, Unit, Unit>() {
            val noteDao = noteDao

            override fun doInBackground(vararg p0: Note?) {
                noteDao.delete(p0[0]!!)
            }
        }

        private class DeleteAllNotesAsyncTask(noteDao: NoteDAO) : AsyncTask<Unit, Unit, Unit>() {
            val noteDao = noteDao

            override fun doInBackground(vararg p0: Unit?) {
                noteDao.deleteAllNotes()
            }
        }

    }

}