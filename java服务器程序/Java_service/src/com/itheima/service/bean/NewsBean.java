package com.itheima.service.bean;

public class NewsBean {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getIcon_url() {
		return icon_url;
	}
	public void setIcon_url(String iconUrl) {
		icon_url = iconUrl;
	}
	public String getNews_url() {
		return news_url;
	}
	public void setNews_url(String newsUrl) {
		news_url = newsUrl;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	private int id;
	private String title;
	private String des;
	private String icon_url;
	private String news_url;
	private int type;
	private int comment;
	private String time ;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
