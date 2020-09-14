package com.zhangzheng.easyrichtext

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
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
        removeAllViews()
        checkChildren()
        monitorChildren()
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

    private fun monitorChildren() {
        mChildren.forEach {
            if (it is TextView) {
                it.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(p0: Editable?) = Unit

                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) =
                        Unit

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        it.removeTextChangedListener(this)
                        removeAllViews()
                        addView(createShowTextView(generateSpanString()))
                        it.addTextChangedListener(this)
                    }
                })
            }
        }
    }

    private fun createShowTextView(text: Spannable): TextView {
        val textView = TextView(context)
        textView.text = text
        textView.highlightColor = Color.TRANSPARENT
        textView.movementMethod = LinkMovementMethod.getInstance()
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
        val ts = attrs!!.getAttributeIntValue(
            "http://schemas.android.com/apk/res/android",
            "textStyle",
            0
        )
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.rich_text)
        val lp = LayoutParam(super.generateLayoutParams(attrs))
        lp.textStyle = ts
        lp.isUnderline = typedArray.getBoolean(R.styleable.rich_text_layout_isUnderline, false)
        lp.isStrikethrough = typedArray.getBoolean(R.styleable.rich_text_layout_isStrikethrough, false)
        typedArray.recycle()
        return lp
    }


    class LayoutParam(
        attrs: LayoutParams, var textStyle: Int = 0,
        var isUnderline: Boolean = false,
        var isStrikethrough: Boolean = false
    ) : FrameLayout.LayoutParams(attrs)
}