package com.zhangzheng.easyrichtext.viewparse.common

import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import android.widget.ImageView

class ClickableSpanImpl(var view: View) : ClickableSpan() {
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