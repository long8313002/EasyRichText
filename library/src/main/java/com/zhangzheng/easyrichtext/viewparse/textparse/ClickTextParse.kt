package com.zhangzheng.easyrichtext.viewparse.textparse

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.CharacterStyle
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse


class ClickTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {
    override fun parseImpl(view: TextView, spanString: SpannableString) {
        if (!view.hasOnClickListeners()) {
            return
        }
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
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
        spanString.setSpan(clickableSpan, 0, spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        view.movementMethod = LinkMovementMethod.getInstance()
    }
}