package com.itheima.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itheima.service.bean.NewsBean;

public class NewsDao {

	public static ArrayList<NewsBean> getNews(){

		 Connection connection = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        String sql = null;

	        try {
	            /*****填写数据库相关信息(请查找数据库详情页)*****/
	            String databaseName = "heimanews";
	            String host = "localhost";
	            String port = "3306";
	            String username = "root"; //用户AK
	            String password = "root"; //用户SK
	            String driverName = "com.mysql.jdbc.Driver";
	            String dbUrl = "jdbc:mysql://";
	            String serverName = host + ":" + port + "/";
	            String connName = dbUrl + serverName + databaseName;

	            /******接着连接并选择数据库名为databaseName的服务器******/
	            Class.forName(driverName);
	            connection = DriverManager.getConnection(connName, username,
	                    password);
	            stmt = connection.createStatement();
	            /******至此连接已完全建立，就可对当前数据库进行相应的操作了*****/
	            /******接下来就可以使用其它标准mysql函数操作进行数据库操作*****/
	            //创建一个数据库表
	            sql = "select * from news  order by id desc";
	            ResultSet rss = stmt.executeQuery(sql);
	            ArrayList<NewsBean> arrayList = new ArrayList<NewsBean>();
	            if(rss != null){
	            	while(rss.next()){
	            		int id = rss.getInt("id");
	            		String title = rss.getString("title");
	            		String des = rss.getString("des");
	            		String icon_url = rss.getString("icon_url");
	            		String news_url = rss.getString("news_url");
	            		int type = rss.getInt("type");
	            		int comment = rss.getInt("comment");
	            		String time = rss.getString("time");
	            		
	            		NewsBean newsBean = new NewsBean();
	            		newsBean.setId(id);
	            		newsBean.setTitle(title);
	            		newsBean.setDes(des);
	            		newsBean.setIcon_url(icon_url);
	            		newsBean.setNews_url(news_url);
	            		newsBean.setTime(time);
	            		newsBean.setType(type);
	            		newsBean.setComment(comment);
	            		arrayList.add(newsBean);
	            		
	            	}
	            	return arrayList;
	            	
	            }
	            
//	            response.getOutputStream().write((execute+"").getBytes());
	        } catch (Exception e) {
	        }
	        return null;
		
	}
	
}
