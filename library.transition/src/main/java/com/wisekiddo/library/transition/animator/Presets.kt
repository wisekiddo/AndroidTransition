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

import com.wisekiddo.library.transition.animator.attention.BounceAnimator
import com.wisekiddo.library.transition.animator.attention.FlashAnimator
import com.wisekiddo.library.transition.animator.attention.PulseAnimator
import com.wisekiddo.library.transition.animator.attention.RubberBandAnimator
import com.wisekiddo.library.transition.animator.attention.ShakeAnimator
import com.wisekiddo.library.transition.animator.attention.StandUpAnimator
import com.wisekiddo.library.transition.animator.attention.SwingAnimator
import com.wisekiddo.library.transition.animator.attention.TadaAnimator
import com.wisekiddo.library.transition.animator.attention.WaveAnimator
import com.wisekiddo.library.transition.animator.attention.WobbleAnimator
import com.wisekiddo.library.transition.animator.enterbounce.BounceInAnimator
import com.wisekiddo.library.transition.animator.enterbounce.BounceInDownAnimator
import com.wisekiddo.library.transition.animator.enterbounce.BounceInLeftAnimator
import com.wisekiddo.library.transition.animator.enterbounce.BounceInRightAnimator
import com.wisekiddo.library.transition.animator.enterbounce.BounceInUpAnimator
import com.wisekiddo.library.transition.animator.enterfade.FadeInAnimator
import com.wisekiddo.library.transition.animator.enterfade.FadeInDownAnimator
import com.wisekiddo.library.transition.animator.enterfade.FadeInLeftAnimator
import com.wisekiddo.library.transition.animator.enterfade.FadeInRightAnimator
import com.wisekiddo.library.transition.animator.enterfade.FadeInUpAnimator
import com.wisekiddo.library.transition.animator.exitfade.FadeOutAnimator
import com.wisekiddo.library.transition.animator.exitfade.FadeOutDownAnimator
import com.wisekiddo.library.transition.animator.exitfade.FadeOutLeftAnimator
import com.wisekiddo.library.transition.animator.exitfade.FadeOutRightAnimator
import com.wisekiddo.library.transition.animator.exitfade.FadeOutUpAnimator
import com.wisekiddo.library.transition.animator.flippers.FlipInXAnimator
import com.wisekiddo.library.transition.animator.flippers.FlipInYAnimator
import com.wisekiddo.library.transition.animator.flippers.FlipOutXAnimator
import com.wisekiddo.library.transition.animator.flippers.FlipOutYAnimator
import com.wisekiddo.library.transition.animator.enterrotate.RotateInAnimator
import com.wisekiddo.library.transition.animator.enterrotate.RotateInDownLeftAnimator
import com.wisekiddo.library.transition.animator.enterrotate.RotateInDownRightAnimator
import com.wisekiddo.library.transition.animator.enterrotate.RotateInUpLeftAnimator
import com.wisekiddo.library.transition.animator.enterrotate.RotateInUpRightAnimator
import com.wisekiddo.library.transition.animator.exitrotate.RotateOutAnimator
import com.wisekiddo.library.transition.animator.exitrotate.RotateOutDownLeftAnimator
import com.wisekiddo.library.transition.animator.exitrotate.RotateOutDownRightAnimator
import com.wisekiddo.library.transition.animator.exitrotate.RotateOutUpLeftAnimator
import com.wisekiddo.library.transition.animator.exitrotate.RotateOutUpRightAnimator
import com.wisekiddo.library.transition.animator.sliders.SlideInDownAnimator
import com.wisekiddo.library.transition.animator.sliders.SlideInLeftAnimator
import com.wisekiddo.library.transition.animator.sliders.SlideInRightAnimator
import com.wisekiddo.library.transition.animator.sliders.SlideInUpAnimator
import com.wisekiddo.library.transition.animator.sliders.SlideOutDownAnimator
import com.wisekiddo.library.transition.animator.sliders.SlideOutLeftAnimator
import com.wisekiddo.library.transition.animator.sliders.SlideOutRightAnimator
import com.wisekiddo.library.transition.animator.sliders.SlideOutUpAnimator
import com.wisekiddo.library.transition.animator.extra.HingeAnimator
import com.wisekiddo.library.transition.animator.extra.RollInAnimator
import com.wisekiddo.library.transition.animator.extra.RollOutAnimator
import com.wisekiddo.library.transition.animator.extra.DropOutAnimator
import com.wisekiddo.library.transition.animator.extra.LandingAnimator
import com.wisekiddo.library.transition.animator.extra.TakingOffAnimator
import com.wisekiddo.library.transition.animator.enterzoom.ZoomInAnimator
import com.wisekiddo.library.transition.animator.enterzoom.ZoomInDownAnimator
import com.wisekiddo.library.transition.animator.enterzoom.ZoomInLeftAnimator
import com.wisekiddo.library.transition.animator.enterzoom.ZoomInRightAnimator
import com.wisekiddo.library.transition.animator.enterzoom.ZoomInUpAnimator
import com.wisekiddo.library.transition.animator.exitzoom.ZoomOutAnimator
import com.wisekiddo.library.transition.animator.exitzoom.ZoomOutDownAnimator
import com.wisekiddo.library.transition.animator.exitzoom.ZoomOutLeftAnimator
import com.wisekiddo.library.transition.animator.exitzoom.ZoomOutRightAnimator
import com.wisekiddo.library.transition.animator.exitzoom.ZoomOutUpAnimator

enum class Presets private constructor(private val animatorClazz: Class<*>) {

    DropOut(DropOutAnimator::class.java),
    Landing(LandingAnimator::class.java),
    TakingOff(TakingOffAnimator::class.java),

    Flash(FlashAnimator::class.java),
    Pulse(PulseAnimator::class.java),
    RubberBand(RubberBandAnimator::class.java),
    Shake(ShakeAnimator::class.java),
    Swing(SwingAnimator::class.java),
    Wobble(WobbleAnimator::class.java),
    Bounce(BounceAnimator::class.java),
    Tada(TadaAnimator::class.java),
    StandUp(StandUpAnimator::class.java),
    Wave(WaveAnimator::class.java),

    Hinge(HingeAnimator::class.java),
    RollIn(RollInAnimator::class.java),
    RollOut(RollOutAnimator::class.java),

    BounceIn(BounceInAnimator::class.java),
    BounceInDown(BounceInDownAnimator::class.java),
    BounceInLeft(BounceInLeftAnimator::class.java),
    BounceInRight(BounceInRightAnimator::class.java),
    BounceInUp(BounceInUpAnimator::class.java),

    FadeIn(FadeInAnimator::class.java),
    FadeInUp(FadeInUpAnimator::class.java),
    FadeInDown(FadeInDownAnimator::class.java),
    FadeInLeft(FadeInLeftAnimator::class.java),
    FadeInRight(FadeInRightAnimator::class.java),

    FadeOut(FadeOutAnimator::class.java),
    FadeOutDown(FadeOutDownAnimator::class.java),
    FadeOutLeft(FadeOutLeftAnimator::class.java),
    FadeOutRight(FadeOutRightAnimator::class.java),
    FadeOutUp(FadeOutUpAnimator::class.java),

    FlipInX(FlipInXAnimator::class.java),
    FlipOutX(FlipOutXAnimator::class.java),
    FlipInY(FlipInYAnimator::class.java),
    FlipOutY(FlipOutYAnimator::class.java),
    RotateIn(RotateInAnimator::class.java),
    RotateInDownLeft(RotateInDownLeftAnimator::class.java),
    RotateInDownRight(RotateInDownRightAnimator::class.java),
    RotateInUpLeft(RotateInUpLeftAnimator::class.java),
    RotateInUpRight(RotateInUpRightAnimator::class.java),

    RotateOut(RotateOutAnimator::class.java),
    RotateOutDownLeft(RotateOutDownLeftAnimator::class.java),
    RotateOutDownRight(RotateOutDownRightAnimator::class.java),
    RotateOutUpLeft(RotateOutUpLeftAnimator::class.java),
    RotateOutUpRight(RotateOutUpRightAnimator::class.java),

    SlideInLeft(SlideInLeftAnimator::class.java),
    SlideInRight(SlideInRightAnimator::class.java),
    SlideInUp(SlideInUpAnimator::class.java),
    SlideInDown(SlideInDownAnimator::class.java),

    SlideOutLeft(SlideOutLeftAnimator::class.java),
    SlideOutRight(SlideOutRightAnimator::class.java),
    SlideOutUp(SlideOutUpAnimator::class.java),
    SlideOutDown(SlideOutDownAnimator::class.java),

    ZoomIn(ZoomInAnimator::class.java),
    ZoomInDown(ZoomInDownAnimator::class.java),
    ZoomInLeft(ZoomInLeftAnimator::class.java),
    ZoomInRight(ZoomInRightAnimator::class.java),
    ZoomInUp(ZoomInUpAnimator::class.java),

    ZoomOut(ZoomOutAnimator::class.java),
    ZoomOutDown(ZoomOutDownAnimator::class.java),
    ZoomOutLeft(ZoomOutLeftAnimator::class.java),
    ZoomOutRight(ZoomOutRightAnimator::class.java),
    ZoomOutUp(ZoomOutUpAnimator::class.java);

    val animator: ViewAnimator
        get() {
            try {
                return animatorClazz.newInstance() as ViewAnimator
            } catch (e: Exception) {
                throw Error("Can not init animatorClazz instance")
            }

        }
}
