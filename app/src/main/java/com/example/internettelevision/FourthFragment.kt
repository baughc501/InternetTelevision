package com.example.internettelevision

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Space
import androidx.navigation.Navigation


class ButtonHandler : View.OnClickListener
{
  override fun onClick(p0: View?)
  {
    var buttonText = (p0 as Button).getText()
    stationButtonText = buttonText.toString()
    var navController = Navigation.findNavController(FourthFragment.getInstance().requireView())
    navController.navigate(R.id.fourthToFifth, null)


  }
}
class FourthFragment : Fragment()
{

  companion object
  {
    private var instance : FourthFragment? = null
    public fun getInstance() : FourthFragment
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
    return inflater.inflate(R.layout.fragment_fourth, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)

    var space: Space
    for (name in stationNames)
    {
      var button1 = View.inflate(MainActivity.getInstance(), R.layout.button, null) as Button

      var text = name
      button1.setText(text)

      var handler = ButtonHandler()
      button1.setOnClickListener(handler)

      var linearLayout =
        MainActivity.getInstance().findViewById<LinearLayout>(R.id.linearLayout)

      linearLayout.addView(button1)

      var space = Space(MainActivity.getInstance())
      space.minimumHeight = 15

      linearLayout.addView(space)
    }


  }

}