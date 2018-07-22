package com.example.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 86188 on 2018/7/20.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);//获取当前项的Fruit实例
        View view;
        ViewHolder viewholder;
        if (convertView==null){
//            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewholder = new ViewHolder();
            viewholder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewholder.fruitname = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewholder); //将ViewHolder存储在View中
        } else{
            view = convertView;
            viewholder = (ViewHolder) view.getTag(); //重新获取ViewHolder
        }
//        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitname = (TextView) view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitname.setText(fruit.getName());
        viewholder.fruitImage.setImageResource(fruit.getImageId());
        viewholder.fruitname.setText(fruit.getName());
        return view;
    }
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitname;
    }
}
