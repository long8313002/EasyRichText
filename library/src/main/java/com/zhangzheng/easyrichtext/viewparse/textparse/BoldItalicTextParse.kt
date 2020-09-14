package com.zhangzheng.easyrichtext.viewparse.textparse

import android.graphics.Typeface
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.RichTextLayout
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse

class BoldItalicTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {

    override fun isMatching(view: TextView) = true
    override fun createSpan(view: TextView): Any {
        val textStyle = (view.layoutParams as RichTextLayout.LayoutParam).textStyle
        val isBold = textStyle and 1 == 1
        val italic = view.typeface.isItalic
        return if (italic && isBold) {
            StyleSpan(Typeface.BOLD_ITALIC)
        } else if (isBold) {
            StyleSpan(Typeface.BOLD)
        } else if (italic) {
            StyleSpan(Typeface.ITALIC)
        } else {
            TypefaceSpan("default")
        }
    }


}