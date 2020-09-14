package com.zz.easyrichtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv3.setOnClickListener {
            Toast.makeText(this,"3333被点击",Toast.LENGTH_SHORT).show()
            tv3.text = "asdasasdasd"
        }

        flClick.setOnClickListener {
            Toast.makeText(this,"自定义视图被点击",Toast.LENGTH_SHORT).show()
            flClick.visibility = View.GONE
            richTextLayout.update()
        }

        ivClick.setOnClickListener {
            Toast.makeText(this,"图片被点击",Toast.LENGTH_SHORT).show()
        }

    }
}
