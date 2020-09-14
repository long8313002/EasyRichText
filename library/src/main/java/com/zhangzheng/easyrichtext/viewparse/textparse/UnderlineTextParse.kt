package com.zhangzheng.easyrichtext.viewparse.textparse

import android.text.style.UnderlineSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.RichTextLayout
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse


class UnderlineTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {
    override fun isMatching(view: TextView) =
        (view.layoutParams as RichTextLayout.LayoutParam).isUnderline

    override fun createSpan(view: TextView) = UnderlineSpan()

}