package ru.netology.kotlin.ncraftmedia

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.kotlin.ncraftmedia.dto.Post

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post(
            id=1,
            author = "Netology",
            content = "First post in our network!!!",
            created = 1583698784,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            likes = 11,
            comments = 3,
            shares = 0
            )

        textDate.text = post.timeAgo(post.created)
        textTitle.text = post.content
        textAuthor.text = post.author

        if (post.likes >0){
            likeNum.text = post.likes.toString()
        }

        if (post.shares >0){
            shareNum.text = post.shares.toString()
        }

        if (post.comments >0){
            commentNum.text = post.comments.toString()
        }

        if (post.likedByMe) {
            likeBtn.setImageResource(R.drawable.ic_post_favorite_24dp_red)
            likeNum.setTextColor(Color.parseColor("#FF0000"))

        }
        else {likeBtn.setImageResource(R.drawable.ic_post_favorite_24dp_gray)}


        if (post.commentedByMe) {
            commentBtn.setImageResource(R.drawable.ic_post_comment_24dp_red)
            commentNum.setTextColor(Color.parseColor("#FF0000"))
        }
        else {commentBtn.setImageResource(R.drawable.ic_post_comment_24dp_gray)}

        if (post.sharedByMe) {
            shareBtn.setImageResource(R.drawable.ic_post_share_24dp_red)
            shareNum.setTextColor(Color.parseColor("#FF0000"))
        }
        else {shareBtn.setImageResource(R.drawable.ic_post_share_24dp_gray)}
    }

 }



