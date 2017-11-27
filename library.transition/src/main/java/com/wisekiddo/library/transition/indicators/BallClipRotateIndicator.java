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

import android.animation.ValueAnimator;

import com.wisekiddo.library.transition.Indicator;

import java.util.ArrayList;

/**
 */
public class BallClipRotateIndicator extends Indicator {

    float scaleFloat=1,degrees;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

        float circleSpacing=12;
        float x = (getWidth()) / 2;
        float y=(getHeight()) / 2;
        canvas.translate(x, y);
        canvas.scale(scaleFloat, scaleFloat);
        canvas.rotate(degrees);
        RectF rectF=new RectF(-x+circleSpacing,-y+circleSpacing,0+x-circleSpacing,0+y-circleSpacing);
        canvas.drawArc(rectF, -45, 270, false, paint);
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        ValueAnimator scaleAnim=ValueAnimator.ofFloat(1,0.6f,0.5f,1);
        scaleAnim.setDuration(750);
        scaleAnim.setRepeatCount(-1);
        addUpdateListener(scaleAnim,new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                scaleFloat = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        ValueAnimator rotateAnim=ValueAnimator.ofFloat(0,180,360);
        rotateAnim.setDuration(750);
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
