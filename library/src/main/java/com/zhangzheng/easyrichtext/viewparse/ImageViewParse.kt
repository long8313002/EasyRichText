package com.zhangzheng.easyrichtext.viewparse

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.View
import android.widget.ImageView
import com.zhangzheng.easyrichtext.IViewParse
import com.zhangzheng.easyrichtext.viewparse.common.ClickableSpanImpl


class ImageViewParse : IViewParse{

    override fun isMatching(view: View)= view is ImageView

    override fun parse(view: View): SpannableString {
        if(view.visibility == View.GONE){
            return SpannableString("")
        }
        view as ImageView
        val d = view.drawable

        val lp = view.layoutParams
        val width  =  if(lp.width>0) lp.width else d.intrinsicWidth
        val height  =  if(lp.height>0) lp.width else d.intrinsicHeight

        val spanString = SpannableString("1")
        d.setBounds(0, 0, width,height)
        val span = ImageSpan(d, ImageSpan.ALIGN_BASELINE)
        spanString.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        if(view.hasOnClickListeners()){
            spanString.setSpan(ClickableSpanImpl(view), 0, spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        }

        return spanString
    }

}