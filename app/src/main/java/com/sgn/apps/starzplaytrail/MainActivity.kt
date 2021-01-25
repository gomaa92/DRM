package com.sgn.apps.starzplaytrail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.longtailvideo.jwplayer.configuration.PlayerConfig
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPlayer()
        jwplayer.play()

    }

    private fun playVideo() {
        jwplayer.setOnClickListener {
            //  initPlayer("https://cdn.jwplayer.com/manifests/kfGLQr16.m3u8")
            jwplayer.play()


        }

    }

    private val token =
        "starzplayarabia|2021-01-24T13:33:32Z|p8lvlUa61MAdgtI0fsUvGF+a5tbMVwPxDv1uMsgT745LJ/sdmeCKLXztQ9y0/Sf0JXPU1oGwxdhZUbVpDdKZxwWbuMWrQH/OGrPO1a5E8pualBet70g0/EtiVnLGH7Q4abD9ShVsfmj1LbLoXPh6jV0WniwcXWeYtpU5bHem0QI=|eaf6b30c8b1ea69a1ae1bcc44baaef1e0f361e8b"

    private fun initPlayer() {
        lifecycle.addObserver(jwplayer)

        /* val playListItem = PlaylistItem().apply {
             file = url
         }*/

        val playlist: MutableList<PlaylistItem> = ArrayList()

        val content = PlaylistItem.Builder()
            .file("http://mena-jit-cdn-lb.aws.playco.com/JIT/SPA/evision/HOMEAGAINY2017M/a57c85a1a47bcea9c13db9a8962093cd/HOMEAGAINY2017M.ism/HOMEAGAINY2017M.mpd")//protected url
            .mediaDrmCallback(
                WidevineMediaDrmCallback(
                    token,"https://widevine-proxy.drm.technology/proxy"
                )
            )
            .build()

        playlist.add(content)
        //  val playListItemList = listOf(playListItem)

        jwplayer.setup(
            PlayerConfig
                .Builder()
                .playlist(playlist)
                .controls(true)
                .build()
        )


    }
}