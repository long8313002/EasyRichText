package com.zhangzheng.easyrichtext.viewparse.textparse

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.widget.TextView
import com.zhangzheng.easyrichtext.RichTextLayout
import com.zhangzheng.easyrichtext.viewparse.AbsTextParseWrap
import com.zhangzheng.easyrichtext.viewparse.ITextParse

class BoldItalicTextParse(vararg baseParse: ITextParse) : AbsTextParseWrap(*baseParse) {

    override fun parseImpl(view: TextView, spanString: SpannableString) {
        val textStyle = (view.layoutParams as RichTextLayout.LayoutParam).textStyle
        val isBold = textStyle and 1 == 1
        val italic = view.typeface.isItalic
        if (italic && isBold) {
            val span = StyleSpan(Typeface.BOLD_ITALIC)
            spanString.setSpan(span, 0, spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        } else if (isBold) {
            val span = StyleSpan(Typeface.BOLD)
            spanString.setSpan(span, 0, spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        } else if (italic) {
            val span = StyleSpan(Typeface.ITALIC)
            spanString.setSpan(span, 0, spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        } else {
            val span = TypefaceSpan("default")
            spanString.setSpan(span, 0, spanString.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        }
    }

}