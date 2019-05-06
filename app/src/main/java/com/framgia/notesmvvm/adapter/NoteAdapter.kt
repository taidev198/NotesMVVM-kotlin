package com.framgia.notesmvvm.adapter

import android.content.Context
import android.databinding.DataBindingUtil

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.notesmvvm.R
import com.framgia.notesmvvm.model.Note
import com.framgia.notesmvvm.databinding.NoteItemBinding

/**
 * Created by superme198 on 03,May,2019
 * in NotesMVVM.
 *binding adapter:https://www.androidhive.info/android-databinding-in-recyclerview-profile-screen/
 */
class NoteAdapter(var context: Context) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var notes: List<Note>? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteViewHolder {
        val binding: NoteItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),R.layout.note_item, p0, false)
            return NoteViewHolder(binding.root, binding)
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

    class NoteViewHolder(
        item: View,
        var binding: NoteItemBinding
    ) : RecyclerView.ViewHolder(item) {

        fun bindData(note: Note) {
            binding.item = note
        }
    }
}