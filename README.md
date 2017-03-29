>前情提要：公司不让UI干重活，让我自己找图标。然后推荐使用这个开源库。优质Icon多到数不清，还可以随意修改icon的颜色，大小，使用起来略爽。简书和掘金上搜不到相关博客，踩了点坑，凡事只能靠自己啊。

[项目demo地址请点击这里](https://github.com/zjxuzhj/IconFontDemo)

###一、添加依赖
```
compile "com.mikepenz:iconics-core:2.8.2@aar"

compile 'com.android.support:appcompat-v7:25.1.0'
```
###二、选择需要依赖的图标库
```
compile 'com.mikepenz:google-material-typeface:3.0.1.0.original@aar'
compile 'com.mikepenz:material-design-iconic-typeface:2.2.0.2@aar'
compile 'com.mikepenz:fontawesome-typeface:4.7.0.0@aar'
compile 'com.mikepenz:octicons-typeface:3.2.0.2@aar'
compile 'com.mikepenz:meteocons-typeface:1.1.0.2@aar'
compile 'com.mikepenz:community-material-typeface:1.8.36.1@aar'
compile 'com.mikepenz:weather-icons-typeface:2.0.10.2@aar'
compile 'com.mikepenz:typeicons-typeface:2.0.7.2@aar'
compile 'com.mikepenz:entypo-typeface:1.0.0.2@aar'
compile 'com.mikepenz:devicon-typeface:2.0.0.2@aar'
compile 'com.mikepenz:foundation-icons-typeface:3.0.0.2@aar'
compile 'com.mikepenz:ionicons-typeface:2.0.1.2@aar'    

```
每个图标库都有自己的网站，可以在上面挑选自己喜欢的图标，查找对应的图标id
[Font Awesome](http://fontawesome.dashgame.com/)
[ionicons](http://ionicons.com/)


![已Font Awesome 为例](http://upload-images.jianshu.io/upload_images/1877523-8401c1acc25556e0.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



###三、icon前缀和依赖库对应表
1. Google Material Design Icons
"gmd"
ORIGINAL by Google compile 'com.mikepenz:google-material-typeface:+.original@aar'
2. Material Design Iconic Font
"gmi"
Google Material Iconic compile 'com.mikepenz:material-design-iconic-typeface:+@aar'
3. Fontawesome
"faw"
compile 'com.mikepenz:fontawesome-typeface:+@aar'
4. Meteocons
"met"
compile 'com.mikepenz:meteocons-typeface:+@aar'
5. Octicons
"oct"
compile 'com.mikepenz:octicons-typeface:+@aar'
6. Community Material
"cmd"
compile 'com.mikepenz:community-material-typeface:+@aar'
7. Weather Icons
"wic"
compile 'com.mikepenz:weather-icons-typeface:+@aar'
8. Typeicons
"typ"
compile 'com.mikepenz:typeicons-typeface:+@aar'
9. Entypo
"ent"
compile 'com.mikepenz:entypo-typeface:+@aar'
10. Devicon
"dev"
compile 'com.mikepenz:devicon-typeface:+@aar'
11. Foundation Icons
"fou"
compile 'com.mikepenz:foundation-icons-typeface:+@aar'
12. Ionicons
"ion"
compile 'com.mikepenz:ionicons-typeface:+@aar'

###四、以Drawable方式使用（在代码中动态替换图片）
> new IconicsDrawable(this)
    .icon(FontAwesome.Icon.faw_android)  //icon Id
    .color(Color.RED) 
    .sizeDp(24) //icon 大小 dp值

```
private void initView() {
        final CheckBox cb_icon = (CheckBox) findViewById(R.id.cb_icon);
        int themeColor = getResources().getColor(R.color.colorAccent);
        int blackColor = getResources().getColor(R.color.black);
        int sizeDp = 20;
        final Drawable drawable = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_ticket).color(themeColor).sizeDp(sizeDp);
        final Drawable drawableDis = new IconicsDrawable(this).icon(FontAwesome.Icon.faw_angle_right).color(blackColor).sizeDp(sizeDp * 2);
        cb_icon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    cb_icon.setCompoundDrawables(null, drawable, null, null);
                else {
                    cb_icon.setCompoundDrawables(null, drawableDis, null, null);
                }
            }
        });
        cb_icon.setChecked(true);
    }

```

![](http://upload-images.jianshu.io/upload_images/1877523-6c759d1de8afdd6a.gif?imageMogr2/auto-orient/strip)


###五、直接在XML文件中使用
1. 使用开源库自定义的控件
 ```
 <com.mikepenz.iconics.view.IconicsImageView
            android:id="@+id/iconicsImageView"
            android:layout_width="72dp"
            android:layout_height="72dp"
            android:layout_gravity="center"
            app:iiv_icon="@string/gmd_ac_unit"
            app:iiv_color="@color/colorPrimary"
            app:iiv_size="36dp"
            />
        <com.mikepenz.iconics.view.IconicsTextView
            android:text="abc{ion-ios-cloud-upload}defgh{faw-adjust}ijk{ion-ios-cloud-upload}"
            android:textColor="@android:color/holo_red_dark"
            android:layout_width="wrap_content"
            android:layout_height="56dp"
            android:textSize="16sp"/>
        <com.mikepenz.iconics.view.IconicsButton
            android:text="{faw-adjust} Button"
            android:layout_width="120dp"
            android:layout_height="60dp"/>

 ```
![](http://upload-images.jianshu.io/upload_images/1877523-1cf071442f421055.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2. 使用普通控件（需要注册）
有两种方法
 1. 在onCreate函数中加入代码
  ```
@Override
protected void onCreate(Bundle savedInstanceState) {
    LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
    super.onCreate(savedInstanceState);
}
```
 2. 重写attchBaseContext函数
```
@Override
protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
}
```

然后就可以使用了
```
<ImageView
            android:layout_width="25dp"
            android:layout_height="25dp"
            app:ico_color="@color/black"
            app:ico_icon="ion_ios_eye"
            android:layout_marginRight="15dp"
            app:ico_size="30dp"
            />

```

![](http://upload-images.jianshu.io/upload_images/1877523-108b0bf592d10eb2.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


####这里有一个坑
在所有步骤都正确完成后，AS还是会红线报错
![](http://upload-images.jianshu.io/upload_images/1877523-e63fd0332181332a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

翻遍了issues，有说把


xmlns:app="http://schemas.android.com/apk/res-auto"
改成
xmlns:app="http://schemas.android.com/apk/tool"
然而并没有软用。

https://github.com/mikepenz/Android-Iconics/issues/174
看到了这个issue，直接添加
```
Iconics.init(getApplicationContext());
Iconics.registerFont(new GoogleMaterial());

//注：应该和 LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));作用类似
```
然后报着试一试的心态，直接运行，竟然可以。。。果然是我太缺少经验么！！！

####总结
使用起来实在是方便，对比阿里的Iconfont。Icon质量也挺不错。
[Android-Iconics库的地址](https://github.com/mikepenz/Android-Iconics)
还有一个类似的库[Android-Iconify的库地址](https://github.com/JoanZapata/android-iconify) 。

 

####参考
http://blog.csdn.net/cuipp0509/article/details/60778152
