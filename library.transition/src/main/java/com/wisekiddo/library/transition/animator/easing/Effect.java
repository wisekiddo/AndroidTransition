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

package com.wisekiddo.library.transition.animator.easing;

import com.wisekiddo.library.transition.animator.easing.back.BackEaseIn;
import com.wisekiddo.library.transition.animator.easing.back.BackEaseInOut;
import com.wisekiddo.library.transition.animator.easing.back.BackEaseOut;
import com.wisekiddo.library.transition.animator.easing.bounce.BounceEaseIn;
import com.wisekiddo.library.transition.animator.easing.bounce.BounceEaseInOut;
import com.wisekiddo.library.transition.animator.easing.bounce.BounceEaseOut;
import com.wisekiddo.library.transition.animator.easing.circ.CircEaseIn;
import com.wisekiddo.library.transition.animator.easing.circ.CircEaseInOut;
import com.wisekiddo.library.transition.animator.easing.circ.CircEaseOut;
import com.wisekiddo.library.transition.animator.easing.cubic.CubicEaseIn;
import com.wisekiddo.library.transition.animator.easing.cubic.CubicEaseInOut;
import com.wisekiddo.library.transition.animator.easing.cubic.CubicEaseOut;
import com.wisekiddo.library.transition.animator.easing.elastic.ElasticEaseIn;
import com.wisekiddo.library.transition.animator.easing.elastic.ElasticEaseOut;
import com.wisekiddo.library.transition.animator.easing.expo.ExpoEaseIn;
import com.wisekiddo.library.transition.animator.easing.expo.ExpoEaseInOut;
import com.wisekiddo.library.transition.animator.easing.expo.ExpoEaseOut;
import com.wisekiddo.library.transition.animator.easing.quad.QuadEaseIn;
import com.wisekiddo.library.transition.animator.easing.quad.QuadEaseInOut;
import com.wisekiddo.library.transition.animator.easing.quad.QuadEaseOut;
import com.wisekiddo.library.transition.animator.easing.quint.QuintEaseIn;
import com.wisekiddo.library.transition.animator.easing.quint.QuintEaseInOut;
import com.wisekiddo.library.transition.animator.easing.quint.QuintEaseOut;
import com.wisekiddo.library.transition.animator.easing.sine.SineEaseIn;
import com.wisekiddo.library.transition.animator.easing.sine.SineEaseInOut;
import com.wisekiddo.library.transition.animator.easing.sine.SineEaseOut;
import com.wisekiddo.library.transition.animator.easing.linear.Linear;


public enum Effect {

    BackEaseIn(BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),

    BounceEaseIn(BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(BounceEaseInOut.class),

    CircEaseIn(CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),

    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),

    ElasticEaseIn(ElasticEaseIn.class),
    ElasticEaseOut(ElasticEaseOut.class),

    ExpoEaseIn(ExpoEaseIn.class),
    ExpoEaseOut(ExpoEaseOut.class),
    ExpoEaseInOut(ExpoEaseInOut.class),

    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(QuadEaseOut.class),
    QuadEaseInOut(QuadEaseInOut.class),

    QuintEaseIn(QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(QuintEaseInOut.class),

    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(SineEaseInOut.class),

    Linear(Linear.class);


    private Class easingMethod;

    private Effect(Class clazz) {
        easingMethod = clazz;
    }

    public BaseEasingMethod getMethod(float duration) {
        try {
            return (BaseEasingMethod)easingMethod.getConstructor(float.class).newInstance(duration);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }
}
