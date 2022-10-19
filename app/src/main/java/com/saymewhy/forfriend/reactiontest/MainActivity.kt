package com.saymewhy.forfriend.reactiontest


import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : androidx.appcompat.app.AppCompatActivity(), View.OnClickListener {
    private val model: Model by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
        model.getNum().observe(this, Observer<Int>{ num ->
            txt.setText(Integer.toString(num))
        })
    }

    override fun onClick(p0: View?) {
        model.ap()
    }
}