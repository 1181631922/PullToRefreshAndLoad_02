package com.jingchen.pulltorefresh.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class MyNewBean implements Parcelable ,Comparable{

	private String name;
	private String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(getName());
		dest.writeString(getNumber());
	}

	public MyNewBean(Parcel source) {
		setName(source.readString());
		setNumber(source.readString());
	}

	

	public MyNewBean(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}



	public static final Creator<MyNewBean> CREATOR = new Creator<MyNewBean>() {

		@Override
		public MyNewBean createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new MyNewBean(source);
		}

		@Override
		public MyNewBean[] newArray(int size) {
			// TODO Auto-generated method stub
			return new MyNewBean[size];
		}
	};

	@Override
	public int compareTo(Object another) {
		// TODO Auto-generated method stub
		return 0;
	}

}
