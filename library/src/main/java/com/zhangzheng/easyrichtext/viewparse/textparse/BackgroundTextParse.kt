package com.zhangzheng.easyrichtext.viewparse.textparse

import android.graphics.drawable.ColorDrawable
import android.text.style.BackgroundColorSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse


class BackgroundTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {

    override fun isMatching(view: TextView) = view.background is ColorDrawable

    override fun createSpan(view: TextView) =
        BackgroundColorSpan((view.background as ColorDrawable).color)

}