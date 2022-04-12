package com.wzhx.animate

import android.animation.AnimatorSet
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import android.view.animation.Interpolator

object Pulse {

    @JvmStatic
    fun pulse(targetView: View, duration: Long, interpolator: Interpolator): AnimatorSet {

        val key1 = Keyframe.ofFloat(0f, 1f)
        val key2 = Keyframe.ofFloat(0.5f, 1.05f)
        val key3 = Keyframe.ofFloat(1f, 1f)

        val holder = PropertyValuesHolder.ofKeyframe("scaleX", key1, key2, key3)
        val animator = ObjectAnimator.ofPropertyValuesHolder(targetView, holder)

        val holder1 = PropertyValuesHolder.ofKeyframe("scaleY", key1, key2, key3)
        val animator1 = ObjectAnimator.ofPropertyValuesHolder(targetView, holder1)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(animator, animator1)
        animatorSet.duration = duration
        animatorSet.interpolator = interpolator

        return animatorSet
    }
}