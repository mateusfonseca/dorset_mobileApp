package com.saravanabalagi.helloworldapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.saravanabalagi.helloworldapplication.dataTypes.Location
import com.saravanabalagi.helloworldapplication.dataTypes.Post
import kotlinx.android.synthetic.main.activity_secondary.*

class ThirdActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        countries_list_view.visibility = View.GONE
        welcome_text.text = "Third"
        welcome_text.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val nameStrings = arrayOf("Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Elijah", "Charlotte")
        val locationStrings = arrayOf("Belfast", "Doolin", "Dublin", "Killarney", "Galway", "Kinsale", "Westport", "Adare")

        val posts = Array<Post>(nameStrings.size) {
            Post().apply {
                name = nameStrings[it]
                location = Location().apply {
                    city = locationStrings[it]
                    country = "Ireland"
                }
            }
        }

        posts_recycler_view.layoutManager = LinearLayoutManager(this)
        posts_recycler_view.adapter = PostsAdapter(posts, this)
    }
}