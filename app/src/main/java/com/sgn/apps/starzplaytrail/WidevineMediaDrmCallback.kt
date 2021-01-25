package com.sgn.apps.starzplaytrail

import android.annotation.TargetApi
import android.text.TextUtils
import com.google.android.exoplayer2.drm.ExoMediaDrm
import com.longtailvideo.jwplayer.media.drm.MediaDrmCallback
import com.sgn.apps.starzplaytrail.Util.executePost
import java.io.IOException
import java.util.*


@TargetApi(18)
class WidevineMediaDrmCallback(token: String,licenseUrl: String) :
    MediaDrmCallback {
    private val defaultUri: String

    @Throws(IOException::class)
    override fun executeProvisionRequest(
        uuid: UUID?,
        request: ExoMediaDrm.ProvisionRequest
    ): ByteArray {
        val url = request.defaultUrl + "&signedRequest=" + String(request.data)
        return executePost(url, null, null)
    }

    @Throws(IOException::class)
    override fun executeKeyRequest(uuid: UUID?, request: ExoMediaDrm.KeyRequest): ByteArray {
        var url = request.licenseServerUrl
        if (TextUtils.isEmpty(url)) {
            url = defaultUri
        }
        return executePost(url, request.data, null)
    }

    companion object {
        private const val WIDEVINE_GTS_DEFAULT_BASE_URI = "https://proxy.uat.widevine.com/proxy"
    }

    init {
        val params = "?token=$token?license_url=$licenseUrl"
        defaultUri = WIDEVINE_GTS_DEFAULT_BASE_URI + params
    }
}