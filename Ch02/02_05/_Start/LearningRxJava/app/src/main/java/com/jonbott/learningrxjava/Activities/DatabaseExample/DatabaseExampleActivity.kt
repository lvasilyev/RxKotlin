package com.jonbott.learningrxjava.Activities.DatabaseExample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.jonbott.learningrxjava.Activities.DatabaseExample.Recycler.PhotoDescriptionViewAdapter
import com.jonbott.learningrxjava.R
import kotlinx.android.synthetic.main.activity_database_example.*


class DatabaseExampleActivity : AppCompatActivity() {

    private val presenter = DatabaseExamplePresenter()

    lateinit var adapter: PhotoDescriptionViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_example)

        attachUI()
    }

    private fun attachUI() {
        val linearLayoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        photoDescriptionRecyclerView.setHasFixedSize(true)
        photoDescriptionRecyclerView.layoutManager = linearLayoutManager
        photoDescriptionRecyclerView.addItemDecoration(dividerItemDecoration)

        initializeListView()
    }

    private fun initializeListView() {
        adapter = PhotoDescriptionViewAdapter { view, position -> rowTapped(position) }
        photoDescriptionRecyclerView.adapter = adapter
    }

    private fun rowTapped(position: Int) {
        println("🍄")
        println(adapter.photoDescriptions[position])
    }
}