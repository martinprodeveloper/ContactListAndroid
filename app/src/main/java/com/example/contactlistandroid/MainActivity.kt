package com.example.contactlistandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewContact: RecyclerView
    lateinit var dataModelArrayList: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = listOf<Contact>(
            Contact("Martin", "999888777"),
            Contact("Pedro", "666555444"),
            Contact("Lucas", "333222111")
        )

        dataModelArrayList = ArrayList()

        recyclerViewContact = findViewById(R.id.rv_contact)
        // recyclerViewContact.layoutManager = LinearLayoutManager(this)
        // recyclerViewContact.adapter = ContactAdapter(contacts)

        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/users"

        val jsonArrayRequest = JsonArrayRequest(url,
            Response.Listener { response ->
                Log.i("Volley", "response: $response")
                for (i in 0 until response.length()) {
                    val item = response.getJSONObject(i)
                    Log.i("Volley", "item: $item")
                    dataModelArrayList.add(
                        Contact(
                            item.get("name").toString(),
                            item.get("phone").toString()
                        )
                    )
                }
                recyclerViewContact.layoutManager = LinearLayoutManager(this)
                recyclerViewContact.adapter = ContactAdapter(dataModelArrayList)
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
            }
        )

        queue.add(jsonArrayRequest)

    }
}