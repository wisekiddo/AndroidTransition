
/*
 * MIT License (MIT)
 * Copyright © 2016 WISEKIDDO.com - https://github.com/wisekiddo/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.wisekiddo.library.transition.animator



/**
 * Created by ronald on 16/11/17.
 */

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.transition.Explode
import android.transition.TransitionValues
import android.view.View
import android.view.ViewGroup

class ExplodeFadeOut : Explode() {
    init {
        propagation = null
    }

    override fun onAppear(sceneRoot: ViewGroup?, view: View?, startValues: TransitionValues?,
                          endValues: TransitionValues?): Animator {
        val explodeAnimator = super.onAppear(sceneRoot, view, startValues, endValues)
        val fadeInAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 0f, 1f)

        return animatorSet(explodeAnimator, fadeInAnimator)
    }

    override fun onDisappear(sceneRoot: ViewGroup?, view: View?, startValues: TransitionValues?,
                             endValues: TransitionValues?): Animator {
        val explodeAnimator = super.onDisappear(sceneRoot, view, startValues, endValues)
        val fadeOutAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 1f, 0f)

        return animatorSet(explodeAnimator, fadeOutAnimator)
    }

    private fun animatorSet(explodeAnimator: Animator, fadeAnimator: Animator): AnimatorSet {
        val animatorSet = AnimatorSet()
        animatorSet.play(explodeAnimator).with(fadeAnimator)
        return animatorSet
    }
}