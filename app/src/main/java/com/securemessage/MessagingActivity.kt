package com.securemessage

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MessagingActivity : AppCompatActivity() {

    private lateinit var messageList: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button
    private val messages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messaging)

        messageList = findViewById(R.id.messageList)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)

        messageList.layoutManager = LinearLayoutManager(this)
        messageList.adapter = MessageAdapter(messages)

        sendButton.setOnClickListener {
            triggerFaceVerification()
        }

        loadSampleMessages()
    }

    private fun loadSampleMessages() {
        messages.add("Hello! How are you?")
        messages.add("This is a mock messaging interface.")
        messages.add("Face verification is important for security.")
        messages.add("Have a great day!")
        messageList.adapter?.notifyDataSetChanged()
    }

    private fun triggerFaceVerification() {
        // Placeholder for face verification logic
        // Implement face verification here
        val newMessage = messageInput.text.toString()
        if (newMessage.isNotBlank()) {
            messages.add(newMessage)
            messageInput.text.clear()
            messageList.adapter?.notifyDataSetChanged()
        }
    }
}