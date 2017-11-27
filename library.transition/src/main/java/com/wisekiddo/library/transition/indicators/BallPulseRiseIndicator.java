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

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;


import com.wisekiddo.library.transition.Indicator;

import java.util.ArrayList;

/**
 */
public class BallPulseRiseIndicator extends Indicator {

    private Camera mCamera;
    private Matrix mMatrix;

    private float degress;

    public BallPulseRiseIndicator(){
        mCamera=new Camera();
        mMatrix=new Matrix();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {

        mMatrix.reset();
        mCamera.save();
        mCamera.rotateX(degress);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();

        mMatrix.preTranslate(-centerX(), -centerY());
        mMatrix.postTranslate(centerX(), centerY());
        canvas.concat(mMatrix);

        float radius=getWidth()/10;
        canvas.drawCircle(getWidth()/4,radius*2,radius,paint);
        canvas.drawCircle(getWidth()*3/4,radius*2,radius,paint);

        canvas.drawCircle(radius,getHeight()-2*radius,radius,paint);
        canvas.drawCircle(getWidth()/2,getHeight()-2*radius,radius,paint);
        canvas.drawCircle(getWidth()-radius,getHeight()-2*radius,radius,paint);
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators=new ArrayList<>();
        ValueAnimator animator=ValueAnimator.ofFloat(0,360);
        addUpdateListener(animator,new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degress = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(-1);
        animator.setDuration(1500);
        animators.add(animator);
        return animators;
    }

}
