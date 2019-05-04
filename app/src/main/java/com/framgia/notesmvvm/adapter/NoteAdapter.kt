package com.framgia.notesmvvm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.notesmvvm.R
import com.framgia.notesmvvm.data.Note

/**
 * Created by superme198 on 03,May,2019
 * in NotesMVVM.
 *
 */
class NoteAdapter(var context: Context) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var notes: List<Note>? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.note_items, p0, false)
        return NoteViewHolder(v)
    }

    override fun getItemCount(): Int {

        return if (notes == null) {
            0
        } else {
            notes!!.size
        }

    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, pos: Int) {
        viewHolder.bindData(notes!![pos])
    }

    internal fun setNotes(listNotes: List<Note>?) {
        notes = listNotes
    }

    class NoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        lateinit var title: String
        lateinit var subtitle: String
        var priority: Int = 0

        fun bindData(note: Note) {
            title = note.title
            subtitle = note.description
            priority = note.priority
        }
    }
}