package com.framgia.notesmvvm.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by superme198 on 06,May,2019
 * in NotesMVVM.
 *
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())

        initComponents()
        initData()

    }

    abstract fun getLayoutResource(): Int
    abstract fun initComponents()
    abstract fun initData()
}
