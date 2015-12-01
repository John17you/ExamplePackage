package com.example.john_mac.examplepackage;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //アプリ情報を設定するリストの作成
        List<TowLineImageItem> appList = new ArrayList<TowLineImageItem>();

        //インストールされているアプリケーションの取得
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> infos = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo info : infos){

            if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == ApplicationInfo.FLAG_SYSTEM)
                continue;

            //アイコンの取得
            Drawable icon = info.loadIcon(pm);
            //アプリ名の取得
            CharSequence appName = info.loadLabel(pm);
            //パッケージ名を取得
            String packageName = info.packageName;

            //リストに追加
            appList.add(new TowLineImageItem(icon,appName,packageName));
        }

        //リストビューにアダプタを設定
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new TowLineImageAdapter(this,appList));

        //インストール済みのアプリケーションの数
        TextView counttextView = (TextView)findViewById(R.id.counttextView);
        counttextView.setText(appList.size()+"");



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
