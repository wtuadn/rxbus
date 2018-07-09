package com.wtuadn.rxbus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RxBus.observe(1, String::class.java).bindLife(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        //no kotlin extension version
//        RxBus.observe(1, String::class.java)
//                .`as`(RxUtils.bindLifecycle(this))
//                .subscribe {
//                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
//                }
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.btn_1 -> RxBus.post(1, "received a message")
            R.id.btn_2 -> window.decorView.postDelayed({ RxBus.post(1, "received a message") }, 5000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "activity has destroyed, you won't receive any message " +
                "if you called bindLife with this LifecycleOwner", Toast.LENGTH_LONG).show()
    }
}
