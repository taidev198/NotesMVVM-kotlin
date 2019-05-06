package com.framgia.notesmvvm.ui.addnote

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.framgia.notesmvvm.R
import com.framgia.notesmvvm.databinding.ActivityAddNoteBinding
import com.framgia.notesmvvm.ui.base.BaseActivity

/**
 * Created by superme198 on 06,May,2019
 * in NotesMVVM.
 *
 */
class AddNoteActivity: BaseActivity() {

    companion object {
        const val EXTRA_ID = "com.framgia.notesmvvm.EXTRA_ID"
        const val EXTRA_TITLE = "com.framgia.notesmvvm.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION = "com.framgia.notesmvvm.EXTRA_DESCRIPTION"
        const val EXTRA_PRIORITY = "com.framgia.notesmvvm.EXTRA_PRIORITY"
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_add_note
    }

    override fun initComponents() {

    }

    override fun initData() {

    }
}