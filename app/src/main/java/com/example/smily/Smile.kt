package com.example.smily

import android.content.Context
import android.graphics.*
import android.view.View
//import androidx.constraintlayout.helper.widget.CircularFlow
import android.graphics.RectF as RectF1

class Smile (context: Context): View(context) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val faceColor = Color.YELLOW
    private val eyesColor = Color.BLACK
    private val mouthColor = Color.BLACK
    private val borderColor = Color.BLACK
    private val borderWidth = 4.0f
    private var size = 320
    private val mouthPath = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
        
    }

    private fun drawMouth(canvas: Canvas?) {
        mouthPath.moveTo(size*0.22f, size*0.7f)
        mouthPath.quadTo(size*0.50f, size*0.80f, size*0.78f, size*0.70f)
        mouthPath.quadTo(size*0.50f, size*0.90f, size*0.22f, size*0.70f)
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        canvas?.drawPath(mouthPath,paint)
    }

    private fun drawEyes(canvas: Canvas?) {
        paint.color = eyesColor
        paint.style = Paint.Style.FILL

        val leftEyeRect = RectF1(size*0.32f, size*0.23f, size*0.43f, size*0.50f)
        canvas?.drawOval(leftEyeRect, paint)

        val rightEyeRect = RectF1(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)
        canvas?.drawOval(rightEyeRect, paint)

    }

    private fun drawFaceBackground(canvas: Canvas?) {

        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = size/2f

        canvas?.drawCircle(size/2f,size/2f,radius,paint)
        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        canvas?.drawCircle(size/2f,size/2f,radius-borderWidth/2f,paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        size = Math.min(measuredWidth,measuredHeight)
        setMeasuredDimension(size,size)
    }
}