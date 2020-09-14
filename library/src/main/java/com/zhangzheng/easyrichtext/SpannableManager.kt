package com.zhangzheng.easyrichtext

import android.text.SpannableString
import android.view.View
import com.zhangzheng.easyrichtext.viewparse.ImageViewParse
import com.zhangzheng.easyrichtext.viewparse.OtherViewParse
import com.zhangzheng.easyrichtext.viewparse.TextViewParse
import com.zhangzheng.easyrichtext.viewparse.textparse.*

interface IViewParse {

    fun isMatching(view: View): Boolean

    fun parse(view: View): SpannableString
}

internal object SpannableManager {

    private val viewParseList = arrayListOf(
        TextViewParse(
            ColorTextParse(
                TextSizeParse(
                    BoldItalicTextParse(
                        ClickTextParse(
                            BackgroundTextParse(
                                StrikethroughTextParse(
                                    UnderlineTextParse()
                                )
                            )
                        )
                    )
                )
            )
        ),
        ImageViewParse(),
        OtherViewParse()
    )


    fun parse(view: View) = viewParseList.first { it.isMatching(view) }.parse(view)


}