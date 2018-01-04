### 一、Android ListView的用法
利用SimpleAdapter实现如下界面效果
- 注意列表项的布局
- 图片使用QQ群附件资源
- 使用Toast显示选中的列表项

![image](https://qqadapt.qpic.cn/txdocpic/0/3eb611a783b818afca2ad7ad892ff22f/0)

activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="horizontal">

<ListView
    android:id="@+id/mylist"
    android:layout_width="fill_parent"
    android:layout_height="match_parent"
    android:listSelector="@color/colorPrimary"
    android:divider="@color/colorPrimaryDark"
    android:dividerHeight="2dp">
</ListView>

</LinearLayout>
```
simple_adapter.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal" >


    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:id="@+id/name1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="10dp"
            android:textColor="#000000"
            android:textSize="20dp"
            android:layout_alignParentLeft="true"
            android:layout_centerInParent="true"/>

        <ImageView
            android:id="@+id/header"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:padding="10dp"
            android:layout_alignParentRight="true"
            android:layout_centerHorizontal="true"/>

    </RelativeLayout>

</LinearLayout>  
```
MainActivity.java

```
package com.android.cc.a20171221_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private String[] name1 = { "cat", "dog", "elephant", "lion","monkey","tiger" };
    private int[] images = { R.drawable.cat, R.drawable.dog, R.drawable.elephant,
            R.drawable.lion ,R.drawable.monkey,R.drawable.tiger};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.mylist);
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name1.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("n1", name1[i]);
            item.put("img", images[i]);
            items.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, items,
                R.layout.simple_adapter, new String[] { "n1", "img" },
                new int[] { R.id.name1, R.id.header });
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position,long id) {
                TextView text=(TextView)v.findViewById(R.id.name1);
                Toast.makeText(getApplicationContext(),text.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
```
##### 实验结果截图
![image](https://qqadapt.qpic.cn/txdocpic/0/d845010e83b7007c983711c2ed3537cb/0)

### 二、创建自定义布局的AlertDialog
- 请创建一个如图所示的布局，
- 调用 AlertDialog.Builder 对象上的 setView() 将布局添加到 AlertDialog。
 ![image](https://qqadapt.qpic.cn/txdocpic/0/a09f121b2825cd1fc7f548583e985cd9/0)
activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="300dp"
    android:layout_height="250dp"
    tools:context="com.android.cc.a20171221_alertdialog.MainActivity">

    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true">

        <TextView
            android:id="@+id/dialog_title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:paddingTop="15dp"
            android:paddingBottom="15dp"
            android:gravity="center"
            android:text="ANDROID APP"
            android:textSize="30sp"
            android:background="@color/colorOrange"/>

        <EditText
            android:id="@+id/username"
            android:hint="@string/username"
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:layout_below="@+id/dialog_title"
            android:theme="@style/MyEditText"
            />
        <EditText
            android:id="@+id/password"
            android:hint="@string/password"
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:layout_below="@+id/username"
            android:theme="@style/MyEditText"
            />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_below="@+id/password"
            android:orientation="horizontal"
            android:background="@color/colorLightGrey">

            <Button
                android:id="@+id/cancel"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:background="#ffffff"
                android:layout_marginRight="1dp"
                android:layout_marginTop="1dp"
                android:text="@string/cancel"
                android:textSize="14sp"
                android:textAllCaps="false"/>

            <Button
                android:id="@+id/dialog_btn_sure"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:background="#ffffff"
                android:layout_marginLeft="1dp"
                android:layout_marginTop="1dp"
                android:text="Sign in"
                android:textSize="14sp"
                android:textAllCaps="false"/>
        </LinearLayout>
    </RelativeLayout>


</RelativeLayout>

```
MainActivity.java

```
package com.android.cc.a20171221_alertdialog;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);
        view = mInflater.inflate(R.layout.activity_main, null);
        final EditText edit_loginform_username = (EditText) view
                .findViewById(R.id.username);
        final EditText edit_loginform_password = (EditText) view
                .findViewById(R.id.password);
        builder.setView(view);
        builder.create().show();
    }
}

```
##### 实验结果截图
![image](https://qqadapt.qpic.cn/txdocpic/0/1095d8821c47aac23efb8e93301bb960/0)

### 三、使用XML定义菜单
- 字体大小（有小，中，大这3个选项；分别对应10号字，16号字和20号字）；点击之后设置测试文本的字体
- 普通菜单项，点击之后弹出Toast提示
- 字体颜色（有红色和黑色这2个选项），点击之后设置测试文本的字体

MainActivity.java
```
package com.android.cc.a20171222_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        
        TextView textView = (TextView) findViewById(R.id.test);
        switch (item.getItemId()){
            case R.id.Size_ten:
                textView.setTextSize(10);
                break;
            case R.id.Size_sixteen:
                textView.setTextSize(16);
                break;
            case R.id.Size_twenty:
                textView.setTextSize(20);
                break;
            case R.id.action_simple:
                textView.setTextColor(Color.parseColor("#808080"));
                textView.setTextSize(13);
                break;
            case R.id.Color_black:
                textView.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.Color_red:
                textView.setTextColor(Color.parseColor("#ff0000"));

        }

        return super.onOptionsItemSelected(item);
    }
}
```

menu_main.xml
```
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context="com.android.cc.a20171222_menu.MainActivity">
    <item
        android:id="@+id/action_textSize"
        android:title="@string/action_textSize"
        app:showAsAction="never" >
        <menu>
            <item
                android:id="@+id/Size_ten"
                android:title="@string/Size_ten"
                app:showAsAction="never"/>
            <item
                android:id="@+id/Size_sixteen"
                android:title="@string/Size_sixteen"
                app:showAsAction="never"/>
            <item
                android:id="@+id/Size_twenty"
                android:title="@string/Size_twenty"
                app:showAsAction="never"/>
        </menu>
    </item>
    <item
        android:id="@+id/action_simple"
        android:title="@string/action_simple"
        app:showAsAction="never" />
    <item
        android:id="@+id/action_textColor"
        android:title="@string/action_textColor"
        app:showAsAction="never" >
        <menu>
            <item
                android:id="@+id/Color_black"
                android:title="@string/Color_black"
                app:showAsAction="never"/>
            <item
                android:id="@+id/Color_red"
                android:title="@string/Color_red"
                app:showAsAction="never"/>
        </menu>
    </item>
</menu>

```
content_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context="com.android.cc.a20171222_menu.MainActivity"
    tools:showIn="@layout/activity_main">

    <TextView
        android:id="@+id/test"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="用于测试的句子...."
        android:textSize="13dp"
        android:textColor="@color/none"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

```

activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.android.cc.a20171222_menu.MainActivity">


    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/AppTheme.AppBarOverlay">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            app:popupTheme="@style/AppTheme.PopupOverlay" />

    </android.support.design.widget.AppBarLayout>

    <include layout="@layout/content_main" />


</android.support.design.widget.CoordinatorLayout>

```
##### 实验结果截图
![image](https://qqadapt.qpic.cn/txdocpic/0/1095d8821c47aac23efb8e93301bb960/0)