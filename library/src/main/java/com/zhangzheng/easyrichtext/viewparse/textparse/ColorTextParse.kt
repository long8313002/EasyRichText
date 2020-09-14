package com.zhangzheng.easyrichtext.viewparse.textparse

import android.text.style.ForegroundColorSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse

class ColorTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {
    override fun isMatching(view: TextView) = true

    override fun createSpan(view: TextView) = ForegroundColorSpan(view.currentTextColor)
}