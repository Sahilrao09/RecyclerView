package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todolist = mutableListOf(
            Todo("1st Task",false),
            Todo("2nd Task",false),
            Todo("3rd Task",false),
            Todo("4th Task",false),
            Todo("5th Task",false),
            Todo("6th Task",false),
            Todo("7th Task",false),
            )

        val adapter = TodoAdapter(todolist)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter=adapter
        rvTodos.layoutManager=LinearLayoutManager(this)

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener {
            val editText:EditText = findViewById(R.id.editText)
            val title = editText.text.toString()
            val todo = Todo(title,false)
            todolist.add(todo)
            adapter.notifyItemInserted(todolist.size-1)
        }
    }
}