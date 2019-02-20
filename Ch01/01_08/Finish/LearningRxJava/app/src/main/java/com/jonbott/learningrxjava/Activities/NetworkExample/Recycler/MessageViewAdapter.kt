package com.jonbott.learningrxjava.Activities.NetworkExample.Recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jonbott.learningrxjava.Activities.DatabaseExample.Recycler.ItemClickedlambda
import com.jonbott.learningrxjava.ModelLayer.Entities.Message
import com.jonbott.learningrxjava.R

class MessageViewAdapter(var onItemClicked: ItemClickedlambda): RecyclerView.Adapter<MessageViewHolder>() {
    internal var messages = listOf<Message>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        val viewHolder = MessageViewHolder(view)

        view.setOnClickListener { v -> onItemClicked(v, viewHolder.adapterPosition) }

        return viewHolder
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.configureWith(message)
    }

    override fun getItemCount(): Int = messages.size

}