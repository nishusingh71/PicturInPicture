package com.example.pip

import android.app.PictureInPictureParams
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var videoView:VideoView
    private val videoUrl="https://r1---sn-qxa7snee.googlevideo.com/videoplayback?expire=1604425877&ei=" +
            "NUShX8OiFIbXgQfaorjgCg&ip=181.113.67.54&id=o-AONymeRFieE0-MKysQErwde2fspIdMTsybSktbX4F8Bk&itag=" +
            "18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=C_K5ZIBZ1pXa8JEIlhjd5f4F&gir=yes&clen=" +
            "5354135&ratebypass=yes&dur=130.867&lmt=1604400335009362&fvip=8&c=WEB&txp=6310222&n=mApS4Nq5ZYFabQ5K&" +
            "sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=" +
            "AOq0QJ8wRgIhAMo2k34EuG3ORXf6nTkTXViFGaQyVmObntiRtlRsirv8AiEA6gXa7cVtGNllmQCoDDP-5ktmS_dec2Un_FAW4mE1AcY%3D&rm=sn-jou-0pvs7r,sn-jou-btxl7r," +
            "sn-hp5sr7e&req_id=f3267f3453a4a3ee&redirect_counter=3&cms_redirect=yes&ipbypass=yes&mh=o6&mip=2402:3a80:15de:79f4:8449:c8fb:c939:468f&mm=30&mn=sn-" +
            "qxa7snee&ms=nxu&mt=1604408662&mv=m&mvi=1&pl=44&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhAPyW7YAIrhC28D1e_1rvoTPzrUmEr--mXjfZzgjJKcoEAiAwA4epeg" +
            "AZmaWn6F9NlWY15ZsYlacHsbmAZCViu-k4wg%3D%3D"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoView=findViewById(R.id.videoView)
        val uri = Uri.parse(videoUrl)

        videoView.setVideoURI(uri)
        val mediaController = MediaController(this, true)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setOnPreparedListener { videoView.start() }

    }

    override fun onUserLeaveHint() {
       val pip=PictureInPictureParams.Builder().build()
       enterPictureInPictureMode(pip)
        super.onUserLeaveHint()
    }

}