package com.sgn.apps.starzplaytrail

import android.content.Context
import android.util.AttributeSet
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.longtailvideo.jwplayer.JWPlayerView

class LifeCycleAwareJWPlayer(context: Context, attrs: AttributeSet) : JWPlayerView(context, attrs),
    LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onOwnerDestroy() {
        onDestroy()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onOwnerPause() {
        onPause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onOwnerResume() {
        onResume()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onOwnerStart() {
        onStart()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onOwnerStop() {
        onStop()
    }
}