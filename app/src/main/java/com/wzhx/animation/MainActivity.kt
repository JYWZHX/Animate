package com.wzhx.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.wzhx.animate.Bounce
import com.wzhx.animate.Flash
import com.wzhx.animate.Pulse
import com.wzhx.animate.interpolators.EaseCubicInterpolator

class MainActivity : AppCompatActivity() {
    private lateinit var targetTv: TextView
    private lateinit var startBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        targetTv = findViewById(R.id.target_tv)
        startBtn = findViewById(R.id.start_btn)

        startBtn.setOnClickListener {
            animate()
        }
    }

    private fun animate() {
//        val bounce = Bounce.bounce(targetTv, 1000)
//        bounce.start()
//        val flash = Flash.flash(targetTv, 1000)
//        flash.start()
        val interpolator = EaseCubicInterpolator(0.42f, 0f, 0.58f, 1f)
        val pulse = Pulse.pulse(targetTv, 1000, interpolator)
        pulse.start()
    }


}