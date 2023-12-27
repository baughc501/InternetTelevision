package com.example.internettelevision

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation

class ConfigHandler : View.OnClickListener, TextView.OnEditorActionListener, DialogInterface.OnClickListener
{

  //internet check dialog box
  override fun onClick(dialog: DialogInterface?, which: Int)
  {

    if (which == DialogInterface.BUTTON_NEGATIVE)
    {
      println("negative")
    }
    else if (which == DialogInterface.BUTTON_POSITIVE)
    {
      println("positive")
    }
  }

  override fun onClick(p0: View?)
  {
    var newStation = MainActivity.getInstance().findViewById<TextView>(R.id.stationDataEntry)
    var stationText = newStation.getText()
    var newUrl = MainActivity.getInstance().findViewById<TextView>(R.id.urlDataEntry)
    var urlText = newUrl.getText()
    //stationNames.add(stationText.toString())
    //stationUrls.add(urlText.toString())
    if (stationText.toString() != "" && urlText.toString() != "")
    {
      stationNames.add(stationText.toString())
      stationUrls.add(urlText.toString())
      successDialog()
    }
    newUrl.setText("")
    newStation.setText("")
    //successDialog()

  }

  override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean
  {
    println(v?.getText())
    var im = MainActivity.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    im.hideSoftInputFromWindow(v?.getWindowToken(),0)
    return true
  }

  fun successDialog()
  {
    var dialogBuilder = AlertDialog.Builder(MainActivity.getInstance())
    var handler = ConfigHandler()
    dialogBuilder.setPositiveButton("OK", handler)
    val alert1 = dialogBuilder.create()
    alert1.setTitle("Channel Created!")
    alert1.show()
  }
}


class BottomSecondFragment : Fragment()
{

  companion object
  {
    private var instance : BottomSecondFragment? = null
    public fun getInstance() : BottomSecondFragment
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
    return inflater.inflate(R.layout.fragment_bottom_second, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)

    var handler = ConfigHandler()

    var stationDataEntry = MainActivity.getInstance().findViewById<EditText>(R.id.stationDataEntry)
    stationDataEntry.setOnEditorActionListener(handler)
    var urlDataEntry = MainActivity.getInstance().findViewById<EditText>(R.id.urlDataEntry)
    urlDataEntry.setOnEditorActionListener(handler)
    var submit = MainActivity.getInstance().findViewById<Button>(R.id.submitButton)
    submit.setOnClickListener(handler)


  }
}