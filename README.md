排版地址：https://blog.csdn.net/long8313002/article/details/108596142



 
使用指南
 

项目build.gradle

implementation 'com.zhangzheng.easyrichtext:library:1.0.1'
 

布局xml文件



 

显示效果



 

 

 
支持属性
分类

属性名称

说明

示例

基本属性

textColor

文字颜色

<TextView

android:id="@+id/tvClick"

android:text="1111111"

android:textColor="#FF0000"

android:textSize="18sp"

android:background="#FFFF00"

android:textStyle="bold|italic"

app:layout_isUnderline="true"

app:layout_isStrikethrough="true"

android:layout_width="wrap_content"

android:layout_height="wrap_content"/>

 

text

文字

textSize

文字大小

background

背景

textStyle

类型：

粗：bold

斜：italic

粗斜：bold|italic

isUnderline

下滑线

isStrikethrough

删除线

 

图片属性

src

图片

<ImageView

android:id="@+id/ivClick"

android:layout_width="30dp"

android:src="@mipmap/ic_launcher"

android:layout_height="30dp"/>

 

width

图片宽

height

图片高

 

自定义布局

所有View属性

性能会有一定影响，可以使用基本属性的建议使用基本属性

<FrameLayout

android:id="@+id/flClick"

android:layout_width="wrap_content"

android:padding="10dp"

android:background="#33FF0000"

android:layout_height="wrap_content">

<TextView

android:layout_gravity="center"

android:layout_width="wrap_content"

android:text="我是自定义视图"

android:layout_height="wrap_content"/>

</FrameLayout>

 

 

 
支持事件
 

 
点击事件
 



 

 
改变文本


 

 
改变显示状态
 



 

 
改变其他属性
上面表格列举的属性，可以直接代码进行更改，因为控件实际上并没有添加到窗口上，这里没办法直接感知到属性的变化，所以需要手动调用下update方法。
