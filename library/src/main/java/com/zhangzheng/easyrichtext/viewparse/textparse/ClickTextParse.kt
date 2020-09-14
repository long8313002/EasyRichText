package com.zhangzheng.easyrichtext.viewparse.textparse

import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse


class ClickTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {
    override fun isMatching(view: TextView) = view.hasOnClickListeners()
    override fun createSpan(view: TextView) = object : ClickableSpan() {
        override fun onClick(p0: View) {
            view.performClick()
        }

        override fun updateDrawState(ds: TextPaint) {
            ds.color = Color.TRANSPARENT
            ds.bgColor = Color.TRANSPARENT
            ds.linkColor = Color.TRANSPARENT
            ds.underlineColor = Color.TRANSPARENT
            ds.isUnderlineText = false
        }
    }
}