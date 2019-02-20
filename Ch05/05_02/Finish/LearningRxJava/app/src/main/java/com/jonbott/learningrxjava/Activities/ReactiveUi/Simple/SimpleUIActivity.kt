package com.jonbott.learningrxjava.Activities.ReactiveUi.Simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.jonbott.learningrxjava.Common.disposedBy
import com.jonbott.learningrxjava.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_simple_ui.*

class SimpleUIActivity : AppCompatActivity() {

    private val presenter = SimpleUIPresenter()
    private var bag = CompositeDisposable()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_ui)

        rxExamples()
    }

    private fun rxExamples() {

        simpleRx()

        rxSimpleListBind()
    }

    private fun simpleRx() {
//        presenter.title.observeOn(AndroidSchedulers.mainThread())
//                .subscribe { simpleUITitleTextView.text = it }
//                .disposedBy(bag)

        presenter.title.observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn { "Default Value" }
                .share()
                .subscribe { simpleUITitleTextView.text = it }
                .disposedBy(bag)

    }


    private fun rxSimpleListBind() {
        val listItems = presenter.friends.value.map { it.toString() }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)

        simpleUIListView.adapter = adapter
    }
}
