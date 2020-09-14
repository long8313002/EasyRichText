package com.zhangzheng.easyrichtext.viewparse.textparse

import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse

class TextSizeParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {


    override fun parseImpl(view: TextView, spanString: SpannableString) {
        val span = AbsoluteSizeSpan(view.textSize.toInt())
        spanString.setSpan(span,0,spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
    }

}