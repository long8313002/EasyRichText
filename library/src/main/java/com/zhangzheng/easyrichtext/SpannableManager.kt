package com.zhangzheng.easyrichtext

import android.text.SpannableString
import android.view.View
import com.zhangzheng.easyrichtext.viewparse.TextViewParse
import com.zhangzheng.easyrichtext.viewparse.textparse.BoldItalicTextParse
import com.zhangzheng.easyrichtext.viewparse.textparse.ClickTextParse
import com.zhangzheng.easyrichtext.viewparse.textparse.ColorTextParse
import com.zhangzheng.easyrichtext.viewparse.textparse.TextSizeParse

interface IViewParse {

    fun isMatching(view: View): Boolean

    fun parse(view: View): SpannableString
}

internal object SpannableManager {

    private val viewParseList = arrayListOf<IViewParse>(
        TextViewParse(
            ColorTextParse(
                TextSizeParse(
                    BoldItalicTextParse(
                        ClickTextParse()))))
    )


    fun parse(view: View) = viewParseList.first { it.isMatching(view) }.parse(view)


}