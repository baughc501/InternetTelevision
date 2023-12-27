package com.example.internettelevision

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.SslErrorHandler
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView

//Delegate class for handling
class Delegate : WebViewClient()
{
  override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?)
  {
    super.onPageStarted(view, url, favicon)
    println("started")
  }
  override fun onPageFinished(view: WebView, url: String)
  {
    super.onPageFinished(view,url)
    println("finish")
  }
  override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError)
  {
    println(error.description )
  }
  override fun onReceivedHttpError(
    view: WebView, request: WebResourceRequest, errorResponse: WebResourceResponse
  )
  {
    println(errorResponse.data)
  }
  override fun onReceivedSslError(
    view: WebView, handler: SslErrorHandler,
    error: SslError
  )
  {
    println(error.primaryError)
  }

}


class FifthFragment : Fragment()
{

  //private var webView : WebView? = null

  companion object
  {
    private var instance : FifthFragment? = null
    public fun getInstance() : FifthFragment
    {
      return instance!!
    }
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)

    instance = this
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_fifth, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)

    //webView = MainActivity.getInstance().findViewById<WebView>(R.id.webView)
    var wv = MainActivity.getInstance().findViewById<WebView>(R.id.webView)

    var urlIndex = stationNames.indexOf(stationButtonText)
    var targetUrl = stationUrls[urlIndex]
    var delegate = Delegate()
    wv?.webViewClient = delegate

    //This will allow the tracing of links
    wv?.getSettings()?.setJavaScriptEnabled(true);
    wv?.getSettings()?.setJavaScriptCanOpenWindowsAutomatically(true);

    //load the url and display
    wv?.loadUrl(targetUrl)

  }

}