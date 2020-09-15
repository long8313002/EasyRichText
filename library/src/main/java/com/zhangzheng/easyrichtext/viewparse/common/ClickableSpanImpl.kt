package com.zhangzheng.easyrichtext.viewparse.common

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import com.zhangzheng.easyrichtext.RichTextLayout

class ClickableSpanImpl(var view: View) : ClickableSpan() {
    override fun onClick(p0: View) {
        view.performClick()
    }

    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = (view.layoutParams as RichTextLayout.LayoutParam).isUnderline
    }
}