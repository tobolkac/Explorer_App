package com.claytobolka.explorerapp.navigaitondrawer.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.claytobolka.explorerapp.app.R;
import com.claytobolka.explorerapp.navigaitondrawer.NavigationDrawerItem;

import java.util.ArrayList;

/**
 * Created by tobolkac on 3/3/14.
 */
public class NavigationListAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<NavigationDrawerItem> navDrawerItems;

    public NavigationListAdapter(Context context, ArrayList<NavigationDrawerItem> navDrawerItems)
    {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View rootView, ViewGroup parent) {
        //recycling views
        if (rootView == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            rootView = mInflator.inflate(R.layout.drawer_list_item, null);
        }
        NavigationDrawerItem item = navDrawerItems.get(position);

        ImageView imgIcon = (ImageView) rootView.findViewById(R.id.icon);
        TextView textTitle = (TextView) rootView.findViewById(R.id.title);
        TextView textCounter = (TextView) rootView.findViewById(R.id.counter);

        imgIcon.setImageResource(item.getIcon());
        textTitle.setText(item.getTitle());

        if (item.isCounterVisible())
        {
            textCounter.setText(item.getCount());
        }
        else
        {
            textCounter.setVisibility(View.GONE);
        }

        return rootView;
    }
}
