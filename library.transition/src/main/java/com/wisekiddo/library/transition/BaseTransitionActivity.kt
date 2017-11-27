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

package com.wisekiddo.library.transition

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.AutoTransition
import android.transition.Fade
import android.transition.Slide
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import com.wisekiddo.library.transition.animator.BouncyEffect
import com.wisekiddo.library.transition.animator.Presets
import java.util.*


/**
 * Created by ronald on 17/11/17.
 */



open class BaseTransitionActivity : AppCompatActivity() {

    val TAG = "LifeCycle"
    var listRemove = ArrayList<Int>()
    var listAdd = ArrayList<Int>()

    var screenContentView:View?=null

    private var bouncyEffects: BouncyEffect.BouncyEffectString? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(TAG, "${javaClass.simpleName} OnCreate")
        super.onCreate(savedInstanceState)

    }


    override fun onStart() {
        Log.d(TAG, "${javaClass.simpleName} OnStart")
        super.onStart()



    }

    override fun onRestart() {
        Log.d(TAG, "${javaClass.simpleName} OnStart")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(TAG, "${javaClass.simpleName} OnPause")
        super.onPause()
        //setupExitTransition(1)

    }

    override fun onStop() {
        Log.d(TAG, "${javaClass.simpleName} OnStop")
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()


    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        //super.onWindowFocusChanged(hasFocus)

        if ( hasFocus && screenContentView!=null) {
            //screenContentView!!.alpha=1.0f
            screenContentView!!.visibility = View.VISIBLE
            bouncyEffects = BouncyEffect.with(Presets.BounceInUp).duration(1200).playOn(screenContentView)
        }

    }
    fun setContentToAnimate(view:View){
        screenContentView = view

    }

}
