package com.example.john_mac.examplepackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TowLineImageAdapter extends ArrayAdapter<TowLineImageItem> {

    LayoutInflater mInflater;

    public TowLineImageAdapter(Context context,List<TowLineImageItem> objects){
        //親のコンストラクタを呼び出す
        super(context,0,objects);

        //インフレーターを取得
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //ホルダークラスを定義
        ViewHolder holder;

        //ビューを設定
        if (convertView == null){
            //ビューに定義したレイアウトをインフレート
            convertView = this.mInflater.inflate(R.layout.list_row,parent,false);

            //ホルダークラスを生成
            holder = new ViewHolder();

            //ホルダークラスにレイアウト内のビューを設定
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            //タグにホルダークラスを設定
            convertView.setTag(holder);

        }else {
            //２回目以降はビューが設定済み
            holder = (ViewHolder) convertView.getTag();
        }

        //指定された位置のアイテムを取得
        TowLineImageItem data = getItem(position);

        //ホルダークラスのビューの値を設定
        holder.imageView.setImageDrawable(data.resourceId);
        holder.textView1.setText(data.text1);
        holder.textView2.setText(data.text2);


        //表示するビューを返す
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }
}


class TowLineImageItem{
    Drawable resourceId;
    CharSequence text1;
    String text2;


    public TowLineImageItem(Drawable resourceId,CharSequence text1,String text2){
        this.resourceId = resourceId;
        this.text1 = text1;
        this.text2 = text2;
    }
}