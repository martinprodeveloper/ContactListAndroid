package com.example.contactlistandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val constactList: List<Contact>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = constactList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return constactList.size
    }

    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textViewName: TextView
        val textViewPhone: TextView

        init {
            textViewName = view.findViewById(R.id.tv_name)
            textViewPhone = view.findViewById(R.id.tv_phone)
        }

        fun render(contact: Contact){
            textViewName.text = contact.nombre
            textViewPhone.text = contact.phone

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, textViewName.text, Toast.LENGTH_SHORT).show()
            }
        }

    }

}