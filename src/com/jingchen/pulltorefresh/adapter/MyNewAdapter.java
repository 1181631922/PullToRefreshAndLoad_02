package com.jingchen.pulltorefresh.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jingchen.pulltorefresh.R;
import com.jingchen.pulltorefresh.adapter.MyAdapter.ViewHolder;
import com.jingchen.pulltorefresh.bean.MyNewBean;

public class MyNewAdapter extends BaseAdapter {
	List<MyNewBean> myNewBeanList;
	Context context;

	public MyNewAdapter(Context context, List<MyNewBean> myNewBeanList) {
		super();
		this.myNewBeanList = myNewBeanList;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return myNewBeanList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return myNewBeanList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
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
		MyNewBean myNewBean = (MyNewBean) getItem(position);
		holder.tv.setText(myNewBean.getName());
		holder.text.setText(myNewBean.getNumber());

		return view;
	}

	static class ViewHolder {
		TextView tv;
		TextView text;
	}

}
