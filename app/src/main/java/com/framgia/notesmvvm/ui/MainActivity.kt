package com.framgia.notesmvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import com.framgia.notesmvvm.R
import com.framgia.notesmvvm.adapter.NoteAdapter
import com.framgia.notesmvvm.model.Note
import com.framgia.notesmvvm.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NoteViewModel
    private var adapter: NoteAdapter = NoteAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        viewModel.getAllNotes().observe(this, Observer<List<Note>> {
           adapter.setNotes(it)
        })
    }
}
