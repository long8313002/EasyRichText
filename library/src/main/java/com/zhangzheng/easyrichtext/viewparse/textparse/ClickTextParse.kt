package com.zhangzheng.easyrichtext.viewparse.textparse

import android.widget.TextView
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse
import com.zhangzheng.easyrichtext.viewparse.common.ClickableSpanImpl


class ClickTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {
    override fun isMatching(view: TextView) = view.hasOnClickListeners()
    override fun createSpan(view: TextView) = ClickableSpanImpl(view)
}