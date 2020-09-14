package com.zhangzheng.easyrichtext.viewparse.textparse

import android.text.style.StrikethroughSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.RichTextLayout
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse


class StrikethroughTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {
    override fun isMatching(view: TextView) =
        (view.layoutParams as RichTextLayout.LayoutParam).isStrikethrough

    override fun createSpan(view: TextView) = StrikethroughSpan()

}