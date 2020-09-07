package com.quyunshuo.aop

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBtn.setOnClickListener {
            test()
        }
    }

    @BehaviorTrace
    private fun test() {
        SystemClock.sleep(3000)
    }
}