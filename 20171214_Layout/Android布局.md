## 一、利用线性布局实现界面

![image](https://qqadapt.qpic.cn/txdocpic/0/b6b4397aaab1874c730b94938ebbd4f2/0)

注：实现边框线条方法
1. 在drawable文件夹下面创建setbar_bg.xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" >
    <!-- 背景色 -->
    <solid android:color="#FFE4B5"/>
    <!-- 边框色 -->
    <stroke android:width="0.5dip" android:color="#81CE47" />
</shape>


2. 设置TextView顺序
 android:background="@drawable/setbar_bg"

## 二、利用相对布局实现界面
tools:context="activity name"这一句不会被打包进APK。只是ADT的Layout Editor在你当前的Layout文件里面设置对应的渲染上下文，说明你当前的Layout所在的渲染上下文是activity name对应的那个activity，如果这个activity在manifest文件中设置了Theme，那么ADT的Layout Editor会根据这个Theme来渲染你当前的Layout。就是说如果你设置的MainActivity设置了一个Theme.Light（其他的也可以），那么你在可视化布局管理器里面看到的背景就应该是Theme.Light的样子。仅用于给你看所见即所得的效果而已。
![image](https://qqadapt.qpic.cn/txdocpic/0/f59f1ac0847a38514d5111c2276f7193/0)

## 三、利用表格布局实现界面
![image](https://qqadapt.qpic.cn/txdocpic/0/a5cd7d1390742c5bcbce6d193d3c8005/0)
# 线性布局
线性布局是程序中最常见的一种布局方式，线性布局可以分为水平线性布局和垂直线性布局两种，通过android:orientation属性可以设置线性布局的方向。
当 android:orientation="vertical"  时， 只有水平方向的设置才起作用，垂直方向的设置不起作用。即：left，right，center_horizontal 是生效的。
当 android:orientation="horizontal" 时， 只有垂直方向的设置才起作用，水平方向的设置不起作用。即：top，bottom，center_vertical 是生效的。



线性布局中，有 几个及其重要的参数，直接决定元素的布局和位置，这几个参数是
android:layout_gravity ( 是本元素相对于父元素的对齐方式 )![image](http://my.csdn.net/uploads/201207/25/1343192611_7216.jpg)

android:gravity="bottom|right"（是本元素所有子元素的对齐方式，设置在父元素上,多个值用｜隔开）
android:layout_gravity (子元素在父元素的对齐方式，设置在子元素上)
android:padding="10dp" （是本元素所有子元素的与父元素边缘的距离，设置在父元素上）
android:layout_marginLeft="10dp"(子元素与父元素边缘的距离，设置在子元素上)
android:orientation （线性布局以列或行来显示内部子元素）
android:layout_weight="1"（线性布局内子元素对未占用空间【水平或垂直】分配权重值，其值越小，权重越大。
前提是子元素 设置了 android:layout_width = "fill_parent" 属性（水平方向）或 android:layout_height = "fill_parent" 属性（垂直方向）如果某个子元素的 android:layout_width = "wrap_content" 或 android:layout_height =" wrap_content” ，则 android:layout_weight 的设置值 对该方向上空间的分配刚好相反。

# 相对布局
RelativeLayout用到的一些重要的属性：
##### 第一类:属性值为true或false
- android:layout_centerHrizontal 水平居中
- android:layout_centerVertical 垂直居中
- android:layout_centerInparent 相对于父元素完全居中
- android:layout_alignParentBottom 贴紧父元素的下边缘
- android:layout_alignParentLeft 贴紧父元素的左边缘
- android:layout_alignParentRight 贴紧父元素的右边缘
- android:layout_alignParentTop 贴紧父元素的上边缘
- android:layout_alignWithParentIfMissing 如果对应的兄弟元素找不到的话就以父元素做参照物
##### 第二类：属性值必须为id的引用名“@id/id-name”
- android:layout_below 在某元素的下方
- android:layout_above 在某元素的的上方
- android:layout_toLeftOf 在某元素的左边
- android:layout_toRightOf 在某元素的右边
- android:layout_alignTop 本元素的上边缘和某元素的的上边缘对齐
- android:layout_alignLeft 本元素的左边缘和某元素的的左边缘对齐
- android:layout_alignBottom 本元素的下边缘和某元素的的下边缘对齐
- android:layout_alignRight 本元素的右边缘和某元素的的右边缘对齐
##### 第三类：属性值为具体的像素值，如30dip，40px
- android:layout_marginBottom 离某元素底边缘的距离
- android:layout_marginLeft 离某元素左边缘的距离
- android:layout_marginRight 离某元素右边缘的距离
- android:layout_marginTop 离某元素上边缘的距离

- EditText的android:hint设置EditText为空时输入框内的提示信息。
- android:gravity　
android:gravity属性是对该view 内容的限定．比如一个button 上面的text. 你可以设置该text在view的靠左，靠右等位置．以button为例，android:gravity="right"则button上面的文字靠右
- android:layout_alignParentRight使当前控件的右端和父控件的右端对齐。这里属性值只能为true或false，默认false。
- android:scaleType：控制图片如何resized/moved来匹对ImageView的size。
###### android:scaleType值的意义区别：
- CENTER /center 按图片的原来size居中显示，当图片长/宽超过View的长/宽，则截取图片的居中部分显示
- CENTER_CROP / centerCrop 按比例扩大图片的size居中显示，使得图片长(宽)等于或大于View的长(宽)
- CENTER_INSIDE / centerInside 将图片的内容完整居中显示，通过按比例缩小或原来的size使得图片长/宽等于或小于View的长/宽
- FIT_CENTER / fitCenter 把图片按比例扩大/缩小到View的宽度，居中显示
- FIT_END / fitEnd 把图片按比例扩大/缩小到View的宽度，显示在View的下部分位置
- FIT_START / fitStart 把图片按比例扩大/缩小到View的宽度，显示在View的上部分位置
- FIT_XY / fitXY 把图片不按比例扩大/缩小到View的大小显示
- MATRIX / matrix 用矩阵来绘制，动态缩小放大图片来显示。
- ** 要注意一点，Drawable文件夹里面的图片命名是不能大写的。
- 
## TableLayout(表格布局)
表格布局模型以行列的形式管理子控件，每一行为一个TableRow的对象，当然也可以是一个View的对象。TableRow可以添加子控件，每添加一个为一列。

##### TableLayout属性：

　　android:collapseColumns:将TableLayout里面指定的列隐藏，若有多列需要隐藏，请用逗号将需要隐藏的列序号隔开。             

　　android:stretchColumns:设置指定的列为可伸展的列，以填满剩下的多余空白空间，若有多列需要设置为可伸展，请用逗号将需要伸展的列序号隔开。                

　　android:shrinkColumns:设置指定的列为可收缩的列。当可收缩的列太宽(内容过多)不会被挤出屏幕。当需要设置多列为可收缩时，将列序号用逗号隔开。