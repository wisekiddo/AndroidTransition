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

package com.wisekiddo.library.transition.indicators;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import android.animation.ValueAnimator;

import com.wisekiddo.library.transition.Indicator;

import java.util.ArrayList;

/**
 */
public class BallZigZagIndicator extends Indicator {

    float[] translateX=new float[2],translateY=new float[2];


    @Override
    public void draw(Canvas canvas, Paint paint) {
        for (int i = 0; i < 2; i++) {
            canvas.save();
            canvas.translate(translateX[i], translateY[i]);
            canvas.drawCircle(0, 0, getWidth() / 10, paint);
            canvas.restore();
        }
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        float startX=getWidth()/6;
        float startY=getWidth()/6;
        for (int i = 0; i < 2; i++) {
            final int index=i;
            ValueAnimator translateXAnim=ValueAnimator.ofFloat(startX,getWidth()-startX,getWidth()/2,startX);
            if (i==1){
                translateXAnim=ValueAnimator.ofFloat(getWidth()-startX,startX,getWidth()/2,getWidth()-startX);
            }
            ValueAnimator translateYAnim=ValueAnimator.ofFloat(startY,startY,getHeight()/2,startY);
            if (i==1){
                translateYAnim=ValueAnimator.ofFloat(getHeight()-startY,getHeight()-startY,getHeight()/2,getHeight()-startY);
            }

            translateXAnim.setDuration(1000);
            translateXAnim.setInterpolator(new LinearInterpolator());
            translateXAnim.setRepeatCount(-1);
            addUpdateListener(translateXAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateX[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });

            translateYAnim.setDuration(1000);
            translateYAnim.setInterpolator(new LinearInterpolator());
            translateYAnim.setRepeatCount(-1);
            addUpdateListener(translateYAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateY[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            animators.add(translateXAnim);
            animators.add(translateYAnim);
        }
        return animators;
    }

}
