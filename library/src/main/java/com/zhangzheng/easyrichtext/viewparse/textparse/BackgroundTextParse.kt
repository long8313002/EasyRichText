package com.zhangzheng.easyrichtext.viewparse.textparse

import android.graphics.drawable.ColorDrawable
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse


class BackgroundTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {

    override fun parseImpl(view: TextView, spanString: SpannableString) {
        if(view.background is ColorDrawable){
            val span = BackgroundColorSpan((view.background as ColorDrawable).color)
            spanString.setSpan(span, 0, spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        }
    }
}