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
	            /*****��д���ݿ������Ϣ(��������ݿ�����ҳ)*****/
	            String databaseName = "heimanews";
	            String host = "localhost";
	            String port = "3306";
	            String username = "root"; //�û�AK
	            String password = "root"; //�û�SK
	            String driverName = "com.mysql.jdbc.Driver";
	            String dbUrl = "jdbc:mysql://";
	            String serverName = host + ":" + port + "/";
	            String connName = dbUrl + serverName + databaseName;

	            /******�������Ӳ�ѡ�����ݿ���ΪdatabaseName�ķ�����******/
	            Class.forName(driverName);
	            connection = DriverManager.getConnection(connName, username,
	                    password);
	            stmt = connection.createStatement();
	            /******������������ȫ�������ͿɶԵ�ǰ���ݿ������Ӧ�Ĳ�����*****/
	            /******�������Ϳ���ʹ��������׼mysql���������������ݿ����*****/
	            //����һ�����ݿ��
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
