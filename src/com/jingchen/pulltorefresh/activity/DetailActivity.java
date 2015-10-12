package com.jingchen.pulltorefresh.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jingchen.pulltorefresh.PullToRefreshLayout;
import com.jingchen.pulltorefresh.R;
import com.jingchen.pulltorefresh.PullToRefreshLayout.OnRefreshListener;
import com.jingchen.pulltorefresh.adapter.MyAdapter;
import com.jingchen.pulltorefresh.bean.MyBean;
import com.jingchen.pulltorefresh.bean.MyNewBean;

public class DetailActivity extends Activity {
	private TextView tv, text;
	private MyNewBean myNewBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_item_layout);
		initView();
		initData();
	}

	private void initView() {
		tv = (TextView) this.findViewById(R.id.tv);
		text = (TextView) this.findViewById(R.id.text);
	}

	private void initData() {
		myNewBean = getIntent().getParcelableExtra("ceshi");
		tv.setText(myNewBean.getName());
		text.setText(myNewBean.getNumber());
	}

}
