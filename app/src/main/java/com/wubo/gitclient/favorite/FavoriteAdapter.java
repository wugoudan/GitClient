package com.wubo.gitclient.favorite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.wubo.gitclient.R;
import com.wubo.gitclient.favorite.model.LocalRepo;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wulog on 2016/8/18.
 */
public class FavoriteAdapter extends BaseAdapter {

    private final ArrayList<LocalRepo> datas;

    public FavoriteAdapter() {
        datas = new ArrayList<LocalRepo>();
    }

    public void setData(Collection<LocalRepo> repos) {
        datas.clear();
        datas.addAll(repos);
        notifyDataSetChanged();
    }

    @Override public int getCount() {
        return datas.size();
    }

    @Override public LocalRepo getItem(int position) {
        return datas.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.layout_item_repo, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        LocalRepo localRepo = getItem(position);
        viewHolder.tvRepoName.setText(localRepo.getFullName());
        viewHolder.tvRepoInfo.setText(localRepo.getDescription());
        viewHolder.tvRepoStars.setText(String.format("stars : %d", localRepo.getStartCount()));
        ImageLoader.getInstance().displayImage(localRepo.getAvatar(), viewHolder.ivIcon);
        return convertView;
    }

    static class ViewHolder{

        @BindView(R.id.ivIcon) ImageView ivIcon;
        @BindView(R.id.tvRepoName) TextView tvRepoName;
        @BindView(R.id.tvRepoInfo) TextView tvRepoInfo;
        @BindView(R.id.tvRepoStars) TextView tvRepoStars;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
