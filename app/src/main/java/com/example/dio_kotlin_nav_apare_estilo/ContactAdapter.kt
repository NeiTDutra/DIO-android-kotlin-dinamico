package com.example.dio_kotlin_nav_apare_estilo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        private val textViewPhone: TextView = itemView.findViewById(R.id.textViewPhone)
        private val imgViewPhoto: ImageView = itemView.findViewById(R.id.imageViewPhotograph)
        fun bind(contact: Contact) {

            textViewName.text = contact.name
            textViewPhone.text = contact.phone
        }
    }
}