package com.zhangzheng.easyrichtext.viewparse.textparse

import android.text.style.AbsoluteSizeSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse

class TextSizeParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {
    override fun isMatching(view: TextView) = true
    override fun createSpan(view: TextView) = AbsoluteSizeSpan(view.textSize.toInt())
}