package com.example.contactlistandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewContact: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = listOf<Contact>(
            Contact("Martin", "999888777"),
            Contact("Pedro", "666555444"),
            Contact("Lucas", "333222111")
        )

        recyclerViewContact = findViewById(R.id.rv_contact)
        recyclerViewContact.layoutManager = LinearLayoutManager(this)
        recyclerViewContact.adapter = ContactAdapter(contacts)

    }
}