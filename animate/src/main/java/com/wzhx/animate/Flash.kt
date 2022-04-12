package com.wzhx.animate

import android.animation.*
import android.view.View

object Flash {

    @JvmStatic
    fun flash(targetView: View, duration: Long): Animator {
        val key1 = Keyframe.ofFloat(0f, 1f)
        val key2 = Keyframe.ofFloat(0.25f, 0f)
        val key3 = Keyframe.ofFloat(0.5f, 1f)
        val key4 = Keyframe.ofFloat(0.75f, 0f)
        val key5 = Keyframe.ofFloat(1f, 1f)

        val holder = PropertyValuesHolder.ofKeyframe(
            "alpha",
            key1, key2, key3, key4, key5
        )

        val animator = ObjectAnimator.ofPropertyValuesHolder(targetView, holder)
        animator.duration = duration

        return animator
    }
}