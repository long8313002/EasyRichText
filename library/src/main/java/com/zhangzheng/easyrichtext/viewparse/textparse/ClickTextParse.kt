package com.zhangzheng.easyrichtext.viewparse.textparse

import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse


class ClickTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {
    override fun parseImpl(view: TextView, spanString: SpannableString) {
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
//                p0.performClick()
                Toast.makeText(p0.context,"!!!!",Toast.LENGTH_SHORT).show()
            }
        }
        spanString.setSpan(clickableSpan,0,spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        view.movementMethod = LinkMovementMethod.getInstance()
    }
}