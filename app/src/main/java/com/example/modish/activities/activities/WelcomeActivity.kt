package com.example.modish.activities.activities

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.VideoView
import com.example.modish.R
import com.jaeger.library.StatusBarUtil

class WelcomeActivity : AppCompatActivity() {

    lateinit var video : VideoView
    lateinit var btn_video : ImageView
    lateinit var btn_skip : Button
    var isPlaying : Boolean = false

    lateinit var videoPath : String
    var videoProgress : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        StatusBarUtil.setTranslucent(this, getResources().getColor(R.color.alpha_grey))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        findViews()
        video.setOnClickListener {
            if(!isPlaying){
                isPlaying = true
                btn_video.visibility = LinearLayout.INVISIBLE
                if(videoProgress == 0)
                    video.start()
                else
                    video.seekTo(videoProgress)
            }else{
                isPlaying = false
                btn_video.visibility = LinearLayout.VISIBLE
                videoProgress = video.currentPosition
                video.stopPlayback()
            }
        }

        btn_skip.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
        }
    }

    fun findViews(){
        video = findViewById(R.id.video_welcom)
        btn_skip = findViewById(R.id.btn_skip)
        btn_video = findViewById(R.id.btn_video_start)
        videoPath = "android.resource://com.example.modish" + "/" + R.raw.edited;
        video.setVideoURI(Uri.parse(videoPath))

    }
}
