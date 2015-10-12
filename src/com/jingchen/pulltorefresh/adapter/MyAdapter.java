package com.jingchen.pulltorefresh.adapter;

import java.util.List;

import com.jingchen.pulltorefresh.R;
import com.jingchen.pulltorefresh.R.id;
import com.jingchen.pulltorefresh.R.layout;
import com.jingchen.pulltorefresh.bean.MyBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	List<MyBean> myBeans;
	Context context;

	public MyAdapter(Context context, List<MyBean> myBeans) {
		this.myBeans = myBeans;
		this.context = context;
	}

	@Override
	public int getCount() {
		return myBeans.size();
	}

	@Override
	public Object getItem(int position) {
		return myBeans.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder = null;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(
					R.layout.list_item_layout, null);
			holder = new ViewHolder();
			view.setTag(holder);

			holder.tv = (TextView) view.findViewById(R.id.tv);
			holder.text = (TextView) view.findViewById(R.id.text);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.tv.setText(myBeans.get(position).getTV());
		holder.text.setText(myBeans.get(position).getTEXT());

		return view;

	}

	static class ViewHolder {
		TextView tv;
		TextView text;
	}

}
