package com.zhangzheng.easyrichtext.viewparse

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.View
import com.zhangzheng.easyrichtext.IViewParse

class OtherViewParse : IViewParse {
    override fun isMatching(view: View) = true

    override fun parse(view: View): SpannableString {
        if(view.visibility == View.GONE){
            return SpannableString("")
        }
        val lp = view.layoutParams
        if (lp.width > 0 && lp.height > 0){
            val widthSpec = View.MeasureSpec.makeMeasureSpec(lp.width, View.MeasureSpec.EXACTLY)
            val heightSpec = View.MeasureSpec.makeMeasureSpec(lp.height, View.MeasureSpec.EXACTLY)
            view.measure(widthSpec, heightSpec)
        }else{
            view.measure(0, 0)
        }

        val bitmap = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)

        val d = BitmapDrawable(bitmap)

        val spanString = SpannableString("1")
        d.setBounds(0, 0, bitmap.width, bitmap.height)
        val span = ImageSpan(d, ImageSpan.ALIGN_BASELINE)
        spanString.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spanString
    }
}