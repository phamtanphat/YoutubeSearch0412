package com.ptp.phamtanphat.youtubesearch0412;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.youtubesearch0412.Retrofit2.API.Item;
import com.ptp.phamtanphat.youtubesearch0412.Retrofit2.API.YoutubeSearch;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by KhoaPhamPC on 16/3/2018.
 */

public class YoutubeSearchAdapter extends ArrayAdapter<Item> {
    public YoutubeSearchAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        ImageView imglist;
        TextView txtlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_youtube,null);
            viewHolder = new ViewHolder();
            viewHolder.imglist = convertView.findViewById(R.id.imageviewlist);
            viewHolder.txtlist = convertView.findViewById(R.id.textviewlist);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Item item = getItem(position);
        Picasso.get().load(item.getSnippet().getThumbnails().getMedium().getUrl()).into(viewHolder.imglist);
        viewHolder.txtlist.setText(item.getSnippet().getTitle());
        return convertView;
    }
}
