package com.framgia.notesmvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import com.framgia.notesmvvm.R
import com.framgia.notesmvvm.adapter.NoteAdapter
import com.framgia.notesmvvm.ui.base.BaseActivity
import com.framgia.notesmvvm.databinding.ActivityMainBinding
import com.framgia.notesmvvm.model.Note
import com.framgia.notesmvvm.ui.addnote.AddNoteActivity
import com.framgia.notesmvvm.viewmodel.NoteViewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: NoteViewModel
    private val adapter: NoteAdapter = NoteAdapter(this)


    override fun initComponents() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.main = this


    }

    override fun initData() {
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        viewModel.getAllNotes().observe(this, Observer<List<Note>> {
            it?.let { notes ->
                adapter.setNotes(notes)
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
                binding.recyclerView.adapter = adapter
            }
        })
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    fun goToAddNote() {
        var intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }
}
