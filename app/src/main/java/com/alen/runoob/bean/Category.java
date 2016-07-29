package com.alen.runoob.bean;

import java.util.ArrayList;

/**
 * 获取分类
 * Created by Jeff on 2016/5/23.
 */
public class Category {

	private String title;
	private ArrayList<Item> item;

	public Category(String title, ArrayList<Item> item) {
		super();
		this.title = title;
		this.item = item;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Category [title=" + title + ", item=" + item + "]";
	}

	public static class Item {
		private String title;// 标题
		private String image;// 图片
		private String link;// 链接
		private String des;// 描述

		public Item(String title, String image, String link, String des) {
			super();
			this.title = title;
			this.image = image;
			this.link = link;
			this.des = des;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getDes() {
			return des;
		}

		public void setDes(String des) {
			this.des = des;
		}

		@Override
		public String toString() {
			return "Item [title=" + title + ", image=" + image + ", link=" + link + ", des=" + des + "]";
		}

	}

}
