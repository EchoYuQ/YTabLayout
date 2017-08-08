# YDTabLayout——可自定义选中项和非选中项 背景、字体大小、颜色、Margin 的TabLayout
### YDTabLayout是基于design包中的TabLayout进行了功能的扩展，在保留原有功能的基础上，增加了可自定义选中项和非选中项 背景、字体大小、颜色、Margin、修改指示器长度以及限制屏幕显示范围内显示的Tab个数等功能。
![image](https://gitlab.corp.youdao.com/luna-android-framework/ydtablayout/raw/master/screenshot/3.png)
## 集成步骤：
### 1.添加YDTabLayout依赖库
#### 在app目录下的build.gradle的dependencies中添加如下引用：

    compile 'com.youdao.luna:YDTabLayout:1.1.3'
    
### 2.在布局文件中设置YDTabLayout属性

    <com.youdao.luna.YDTabLayout
        android:id="@+id/xTablayout"
        android:layout_width="match_parent"
        android:layout_height="130px"
        app:xTabIndicatorColor="#0f0"
        app:xTabIndicatorHeight="0dp"
        app:xTabMargin="5dp"
        app:xTabMode="fixed"
        app:xTabPadding="5dp"
        app:xTabSelectedBackground="@drawable/item_bg_pressed"
        app:xTabSelectedTextColor="#ffffffff"
        app:xTabSelectedTextSize="15sp"
        app:xTabTextColor="#848A90"
        app:xTabTextSelectedBold="true"
        app:xTabTextSize="15sp" />
     
#### TabLayout有的属性，在YDTabLayout中都会有。
#### 其中增加了
- #### xTabMargin、xTabMarginStart、xTabMarginTop、xTabMarginEnd、xTabMarginBottom用于设置ViewItem的margin边距。
- #### xTabBackground、xTabBackgroundColor用于设置未被选择的ViewItem的背景和背景颜色，二者同时设置时，只有xTabBackground生效。
- #### xTabSelectedBackground、xTabSelectedBackgroundColor用于设置被选择的ViewItem的背景和背景颜色，二者同时设置时，只有xTabSelectedBackground生效。
- #### xTabIndicatorWidth用于设置指示器长度，xTabTextSize用于设置未选中项的字体大小，xTabSelectedTextSize用于设置选中项的字体大小。

 
### 3.初始化
#### YDTabLayout的使用方式和TabLayout是一样的，代码如下：
    
    // 将TabLayout和ViewPager关联起来。
    YDTabLayout tabLayout = (YDTabLayout) findViewById(R.id.ydTablayout);
    tabLayout.setupWithViewPager(viewPager);
    
# 属性介绍
## 
### 1. 设置Tab背景色

    app:xTabBackgroundColor="#fff"
    app:xTabSelectedBackgroundColor="#ff0"

### 两个属性分别对应Tab未选中和被选中的背景色，效果图如下：
![](https://gitlab.corp.youdao.com/luna-android-framework/ydtablayout/raw/master/screenshot/2.png)

### 2. 设置Tab背景

    app:xTabBackground="@drawable/item_bg_normal"
    app:xTabSelectedBackground="@drawable/item_bg_pressed"
## 
### 3. 设置margin

    app:xTabMargin="5dp"
####    或者
    app:xTabMarginStart="5dp"
    app:xTabMarginEnd="5dp"
    app:xTabMarginTop="5dp"
    app:xTabMarginBottom="5dp"
## 
### 4. 设置字体粗体
   
		<!-- 使用xTabTextSelectedBold属性前，必须先设置选中Tab的字体大小-->
        app:xTabSelectedTextSize="20sp"
        <!-- 使用xTabTextBold属性前，必须先设置非选中Tab的字体大小-->
        app:xTabTextSize="20sp"
		
        <!-- 设置选中Tab的文本是否粗体显示-->
        app:xTabTextSelectedBold="true"
        <!-- 设置未选中Tab的文本是否粗体显示-->
        app:xTabTextBold="true"
		
#### ==注意：使用xTabTextSelectedBold、xTabTextBold属性前，必须先设置选中和非选中Tab的字体大小==

## 
### 5. 设置屏幕范围内显示的Tab个数
	// 注意想要使xTabDisplayNum属性生效，当前的xTabMode必须设为scrollable
	app:xTabMode="scrollable"
    app:xTabDisplayNum="3"
    
#### 或者在代码中添加
    tabLayout.setxTabDisplayNum(3);// 需要写在setupWithViewPager前
    tabLayout.setupWithViewPager(viewPager);
    
#### 这里我们限制为3个，则每个tab的宽度为屏幕的1/3，显示效果如下:
 ![](https://gitlab.corp.youdao.com/luna-android-framework/ydtablayout/raw/master/screenshot/1.png)
#### 需要注意显示的个数会受Adapter的ItemCount影响，例如ItemCount为3，但是我们设置app:xTabDisplayNum=“4”，那么显示出来的Tab的宽度其实是屏幕的1/3，并非1/4。

## 
### 6. 设置指示器长度
#### a.明确指定指示器为某个长度则设置xTabIndicatorWidth
#### b.指定指示器长度跟随文本变化则设置xTabDividerWidthWidthText
#### c.如果需要指示器长度占满，则两个属性都不设置，默认占满。
	
## 
### 7. 设置指示器长度随Tab文本内容长度变化。
#### 不设置xTabIndicatorWidth属性即可  


## 
### 8. 设置标题字母大小写转换，默认不自动转换
#### 在xml文件中添加
	app:xTabTextAllCaps="false"
#### 或者在java代码中调用
	YDTabLayout.setAllCaps(false); 


    
