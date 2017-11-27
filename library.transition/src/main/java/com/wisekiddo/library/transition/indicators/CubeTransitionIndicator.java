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
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;

import android.animation.ValueAnimator;

import com.wisekiddo.library.transition.Indicator;

import java.util.ArrayList;

/**
 */
public class CubeTransitionIndicator extends Indicator {

    float[] translateX=new float[2],translateY=new float[2];
    float degrees,scaleFloat=1.0f;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float rWidth=getWidth()/5;
        float rHeight=getHeight()/5;
        for (int i = 0; i < 2; i++) {
            canvas.save();
            canvas.translate(translateX[i], translateY[i]);
            canvas.rotate(degrees);
            canvas.scale(scaleFloat,scaleFloat);
            RectF rectF=new RectF(-rWidth/2,-rHeight/2,rWidth/2,rHeight/2);
            canvas.drawRect(rectF,paint);
            canvas.restore();
        }
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        float startX=getWidth()/5;
        float startY=getHeight()/5;
        for (int i = 0; i < 2; i++) {
            final int index=i;
            translateX[index]=startX;
            ValueAnimator translationXAnim=ValueAnimator.ofFloat(startX,getWidth()-startX,getWidth()-startX, startX,startX);
            if (i==1){
                translationXAnim=ValueAnimator.ofFloat(getWidth()-startX,startX,startX, getWidth()-startX,getWidth()-startX);
            }
            translationXAnim.setInterpolator(new LinearInterpolator());
            translationXAnim.setDuration(1600);
            translationXAnim.setRepeatCount(-1);
            translationXAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateX[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            translateY[index]=startY;
            ValueAnimator translationYAnim=ValueAnimator.ofFloat(startY,startY,getHeight()-startY,getHeight()- startY,startY);
            if (i==1){
                translationYAnim=ValueAnimator.ofFloat(getHeight()-startY,getHeight()-startY,startY,startY,getHeight()-startY);
            }
            translationYAnim.setDuration(1600);
            translationYAnim.setInterpolator(new LinearInterpolator());
            translationYAnim.setRepeatCount(-1);
            addUpdateListener(translationYAnim,new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    translateY[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });

            animators.add(translationXAnim);
            animators.add(translationYAnim);
        }

        ValueAnimator scaleAnim=ValueAnimator.ofFloat(1,0.5f,1,0.5f,1);
        scaleAnim.setDuration(1600);
        scaleAnim.setInterpolator(new LinearInterpolator());
        scaleAnim.setRepeatCount(-1);
        addUpdateListener(scaleAnim,new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                scaleFloat = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        ValueAnimator rotateAnim=ValueAnimator.ofFloat(0,180,360,1.5f*360,2*360);
        rotateAnim.setDuration(1600);
        rotateAnim.setInterpolator(new LinearInterpolator());
        rotateAnim.setRepeatCount(-1);
        addUpdateListener(rotateAnim,new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degrees = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        animators.add(scaleAnim);
        animators.add(rotateAnim);
        return animators;
    }
}
