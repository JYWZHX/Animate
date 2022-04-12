package com.wzhx.animate

import android.animation.AnimatorSet
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import com.wzhx.animate.interpolators.EaseCubicInterpolator

object Bounce {

    @JvmStatic
    fun bounce(targetView: View, duration: Long): AnimatorSet {
        val easeCubicInterpolator1 = EaseCubicInterpolator(0.215f, 0.61f, 0.355f, 1f)
        val key1 = Keyframe.ofFloat(0f, 0f)
        val key2 = Keyframe.ofFloat(0.2f, 0f)
        val key3 = Keyframe.ofFloat(0.53f, 0f)
        val key4 = Keyframe.ofFloat(1f, 0f)
        key1.interpolator = easeCubicInterpolator1
        key2.interpolator = easeCubicInterpolator1
        key3.interpolator = easeCubicInterpolator1
        key4.interpolator = easeCubicInterpolator1

        val easeCubicInterpolator2 = EaseCubicInterpolator(0.755f, 0.05f, 0.855f, 0.06f)
        val key5 = Keyframe.ofFloat(0.4f, -30f)
        key5.interpolator = easeCubicInterpolator2
        val key6 = Keyframe.ofFloat(0.43f, -30f)
        key6.interpolator = easeCubicInterpolator2

        val key7 = Keyframe.ofFloat(0.7f, -15f)
        key7.interpolator = easeCubicInterpolator2

        val key8 = Keyframe.ofFloat(0.8f, 0f)
        key8.interpolator = easeCubicInterpolator1

        val key9 = Keyframe.ofFloat(0.9f, -4f)


        val holder = PropertyValuesHolder.ofKeyframe(
            "translationY", key1, key2,
            key5, key6, key3, key7, key8, key9, key4
        )
        val animator = ObjectAnimator.ofPropertyValuesHolder(targetView, holder)

        val key10 = Keyframe.ofFloat(0.4f, 1.1f)
        key10.interpolator = easeCubicInterpolator2
        val key11 = Keyframe.ofFloat(0.43f, 1.1f)
        key11.interpolator = easeCubicInterpolator2

        val key12 = Keyframe.ofFloat(0.7f, 1.05f)
        key12.interpolator = easeCubicInterpolator2

        val key13 = Keyframe.ofFloat(0.8f, 0.95f)
        key13.interpolator = easeCubicInterpolator1

        val key14 = Keyframe.ofFloat(0.9f, 1.02f)

        val holder2 = PropertyValuesHolder.ofKeyframe(
            "scaleY",
            key10, key11, key12, key13, key14
        )
        val animator2 = ObjectAnimator.ofPropertyValuesHolder(targetView, holder2)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(animator, animator2)
        animatorSet.duration = duration

        return animatorSet
    }
}