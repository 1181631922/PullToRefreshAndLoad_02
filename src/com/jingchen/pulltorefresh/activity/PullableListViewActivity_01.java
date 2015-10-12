package com.jingchen.pulltorefresh.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.jingchen.pulltorefresh.PullToRefreshLayout;
import com.jingchen.pulltorefresh.R;
import com.jingchen.pulltorefresh.PullToRefreshLayout.OnRefreshListener;
import com.jingchen.pulltorefresh.adapter.MyAdapter;
import com.jingchen.pulltorefresh.bean.MyBean;

public class PullableListViewActivity_01 extends Activity {
	private ListView listView;
	private PullToRefreshLayout ptrl;
	private boolean isFirstIn = true;
	private String mAddress, mTitle;
	private List<MyBean> myBeans;
	private List<Map<String, Object>> myList = new ArrayList<Map<String, Object>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		ptrl = ((PullToRefreshLayout) findViewById(R.id.refresh_view));
		ptrl.setOnRefreshListener(new MyListener());
		listView = (ListView) findViewById(R.id.content_view);
		initListView();
	}

	public class MyListener implements OnRefreshListener {

		@Override
		public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
			// 下拉刷新操作
			new Handler() {
				@Override
				public void handleMessage(Message msg) {
					// 千万别忘了告诉控件刷新完毕了哦！
					pullToRefreshLayout
							.refreshFinish(PullToRefreshLayout.SUCCEED);
				}
			}.sendEmptyMessageDelayed(0, 3000);
		}

		@Override
		public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
			// 加载操作
			new Handler() {
				@Override
				public void handleMessage(Message msg) {
					// 千万别忘了告诉控件加载完毕
					pullToRefreshLayout
							.loadmoreFinish(PullToRefreshLayout.SUCCEED);
				}
			}.sendEmptyMessageDelayed(0, 3000);
		}

	}

//	@Override
//	public void onWindowFocusChanged(boolean hasFocus) {
//		super.onWindowFocusChanged(hasFocus);
//		// 第一次进入自动刷新
//		if (isFirstIn) {
//			ptrl.autoRefresh();
//			isFirstIn = false;
//		}
//	}

	/**
	 * ListView初始化方法
	 */
	private void initListView() {

		MyBean[] myBeanArray = new MyBean[] { 
				new MyBean("韩冰", "13303116239"),
				new MyBean("张海春", "18765432345"),
				new MyBean("及徐冰", "18765432345") };

		for (int i = 0; i < myBeanArray.length; i++) {

			MyBean myBeans = new MyBean(mTitle, mAddress);

			String mtitle = myBeanArray[i].getTV();
			String madd = myBeanArray[i].getTEXT();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("m_title", mtitle);
			map.put("m_address", madd);

			myList.add(map);
		}

		Arrays.sort(myBeanArray);

		myBeans = Arrays.asList(myBeanArray);

		MyAdapter adapter = new MyAdapter(this, myBeans);
		listView.setAdapter(adapter);
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(
						PullableListViewActivity_01.this,
						"LongClick on "
								+ parent.getAdapter().getItemId(position),
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(PullableListViewActivity_01.this,
						" Click on " + parent.getAdapter().getItemId(position),
						Toast.LENGTH_SHORT).show();

				Intent intent = new Intent(PullableListViewActivity_01.this,
						DetailActivity.class);
				startActivity(intent);
			}
		});
	}

}
