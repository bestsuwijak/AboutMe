package buu.informatics.s59160141.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160141.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            //onclick
            doneButton.setOnClickListener {
                addNickname(it)
            }

            nicknameText.setOnClickListener {
                updateNickname(it)
            }
        }


    }
    private fun addNickname(view: View) {
        binding.apply {
            //set text hide text edit, button and show text view
            nicknameEdit.visibility = View.GONE
            nicknameText.text = nicknameEdit.text
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

            //hide keybord
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun updateNickname (view: View) {
        binding.apply {
            //show text edit, done button and hide text view
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            view.visibility = View.GONE

            //focus text
            nicknameEdit.requestFocus()

            //show keybord
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)
        }
    }
}
