package com.framgia.notesmvvm.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.framgia.notesmvvm.viewmodel.NoteViewModel
import java.util.logging.Logger

/**
 * Created by superme198 on 03,May,2019
 * in NotesMVVM.
 *
 */
@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDAO

    companion object {
        private var instance: NoteDataBase? = null

        fun getInstance(context: Context): NoteDataBase? {
            Logger.getLogger(NoteViewModel::class.java.name).warning("Hello..")

            if (instance == null) {
                synchronized(NoteDataBase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDataBase::class.java, "note_table"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }

        class PopulateDbAsyncTask(db: NoteDataBase?) : AsyncTask<Unit, Unit, Unit>() {
            private val noteDao = db?.noteDao()

            override fun doInBackground(vararg p0: Unit?) {
                noteDao?.insert(Note("title 1", "description 1", 1))
                noteDao?.insert(Note("title 2", "description 2", 2))
                noteDao?.insert(Note("title 3", "description 3", 3))
            }
        }
    }
}