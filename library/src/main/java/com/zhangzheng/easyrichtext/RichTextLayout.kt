package com.zhangzheng.easyrichtext

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

class RichTextLayout : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mChildren = mutableListOf<View>()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        getChildren()
        checkChildren()
        removeAllViews()
        addView(createShowTextView(generateSpanString()))
    }

    private fun getChildren() {
        for (i in 0 until childCount) {
            mChildren.add(getChildAt(i))
        }
    }

    private fun checkChildren() {
        mChildren.forEach {
            if (it !is TextView && it !is ImageView) {
                throw RuntimeException("不支持的控件类型")
            }
        }
    }

    private fun createShowTextView(text: Spannable): TextView {
        val textView = TextView(context)
        textView.text = text
        return textView
    }

    private fun generateSpanString(): Spannable {
        val spanStringBuilder = SpannableStringBuilder()
        mChildren.forEach {
            spanStringBuilder.append(SpannableManager.parse(it))
        }
        return spanStringBuilder
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        val ts = attrs!!.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle",0)
        val lp = LayoutParam(super.generateLayoutParams(attrs))
        lp.textStyle = ts
        return lp
    }


    class LayoutParam(attrs: LayoutParams,var textStyle:Int = 0) :FrameLayout.LayoutParams(attrs)
}