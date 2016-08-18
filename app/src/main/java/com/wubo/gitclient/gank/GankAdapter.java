package com.wubo.gitclient.gank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wubo.gitclient.R;
import com.wubo.gitclient.gank.model.GankItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulog on 2016/8/18.
 */
public class GankAdapter extends BaseAdapter {

    private final ArrayList<GankItem> datas;


    public GankAdapter() {
        datas = new ArrayList<GankItem>();
    }

    public void setDatas(List<GankItem> gankItems) {
        datas.clear();
        datas.addAll(gankItems);
    }

    @Override public int getCount() {
        return datas.size();
    }

    @Override public GankItem getItem(int position) {
        return datas.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.layout_item_gank, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        GankItem gankItem = getItem(position);
        viewHolder.gank_item.setText(gankItem.getDesc());

        return convertView;
    }

    static class ViewHolder {
        public TextView gank_item;

        public ViewHolder(View view) {
            gank_item = (TextView) view.findViewById(R.id.gank_item);
        }
    }
}
