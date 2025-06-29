package com.example.ucankafa

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Tam ekran
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        // WebView oluştur
        val webView = WebView(this)
        setContentView(webView)

        // FPS Boost
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null) // 🔥 Burası önemli

        // Web ayarları
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.allowFileAccess = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        // HTML dosyanı assets klasöründen yükle
        webView.loadUrl("file:///android_asset/index.html")
    }
}
