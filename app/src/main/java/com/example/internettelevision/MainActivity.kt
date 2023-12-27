package com.example.internettelevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

var stationNames = mutableListOf("France24","MLB","The Blaze","Weather","ABC","CBS",  "Free Speech",
  "Travel", "SECDN", "Daytona", "HouseTV","ROKU","Orange County", "Seminole County",
  "University of Texas", "Temple University","University of California")

var stationUrls = mutableListOf("https://nmxlive.akamaized.net/hls/live/529965/Live_1/index.m3u8",
  "https://videos.rtva.ad/live/rtva/playlist.m3u8",
  "https://buzzrota-web.amagi.tv/playlist480.m3u8",
  "https://bloomberg.com/media-manifest/streams/us.m3u8",
  "https://content.uplynk.com/channel/3324f2467c414329b3b0cc5cd987b6be.m3u8",
  "https://reuters-reutersnow-1-eu.rakuten.wurl.tv/playlist.m3u8",
  "https://cbsnews.akamaized.net/hls/live/2020607/cbsnlineup_8/master.m3u8",
  "https://e46fa4a445464f8a9150fa7d510eb85c.mediatailor.us-west-2.amazonaws.com/v1/master" +
    "/2d2d0d97b0e548f025b2598a69b55bf30337aa0e/npp/N55LT0GGXOUT6SC3GJN7/hls3/now_-1m_15s/m.m3u8",
  "https://30a-tv.com/darcizzle.m3u8",
  "https://30a-tv.com/feeds/vidaa/golf.m3u8",
  "https://30a-tv.com/feeds/xodglobal/30atv.m3u8",
  "https://30a-tv.com/feeds/vidaa/luxelife.m3u8",
  "https://30a-tv.com/music.m3u8",
  "https://30a-tv.com/feeds/ceftech/30atvmusic.m3u8",
  "https://30a-tv.com/sidewalks.m3u8",
  "https://30a-tv.com/feeds/masters/30atv.m3u8",
  "https://30a-tv.com/beachy.m3u8")

var stationButtonText = ""


  class MainActivity : AppCompatActivity()
{

  companion object
  {
    private var instance : MainActivity? = null
    public fun getInstance() : MainActivity
    {
      return instance!!
    }
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    instance = this
    setContentView(R.layout.activity_main)



    val navController = Navigation.findNavController(this, R.id.fragment)

    var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

    bottomNavigationView.setupWithNavController(navController)


  }
}