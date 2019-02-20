package com.jonbott.learningrxjava.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jonbott.learningrxjava.ModelLayer.Entities.Posting
import com.jonbott.learningrxjava.R
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


class BasicExampleActivity : AppCompatActivity() {

    private var bag = CompositeDisposable()

    //region Simple Network Layer

    interface JsonPlaceHolderService {
        @GET("posts/{id}")
        fun getPosts(@Path("id") id: String): Call<Posting>
    }

    private var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

    private var service = retrofit.create(JsonPlaceHolderService::class.java)

    //endregion

    //region Life Cycle Events

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_example)
    }

    //endregion
}