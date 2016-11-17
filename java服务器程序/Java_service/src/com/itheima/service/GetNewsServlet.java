package com.itheima.service;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.itheima.service.bean.NewsBean;
import com.itheima.service.dao.NewsDao;


public class GetNewsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetNewsServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		/*
	新闻请求路径：
//		http://192.168.14.101:8080/itheima72/servlet/GetNewsServlet

	返回值：

	{
	    "newss": [
	        {
	            "id": 2,
	            "time": "2015-08-07",
	            "des": "7月29日，历经9个月数百万人内测完善之后，微软终于发布Win10正式版系统。但是可能对于部分用户而言，Win7仍然是绝对的经典、游戏玩家的不二之选，为何非要升级到Win10系统呢？Windows10性能和功能相比Windows7，有提升吗？下面IT之家就为大家带来Win7与Win10功能与性能的正面PK，相信还在犹豫不决的用户看完本文心里就会有了答案。",
	            "title": "升还是不升：Win7、Win10全面对比评测",
	            "news_url": "http://toutiao.com/a5229867988/",
	            "icon_url": "http://p2.pstatp.com/large/6850/6105376239",
	            "comment": 5000,
	            "type": 1
	        },
	        {
	            "id": 1,
	            "time": "2015-08-09",
	            "des": "苹果iPhone6s发布的具体时间越传越近了，但至今还没有官方的准信儿。今天还是让我们关注一下火狐漏洞吧。火狐浏览器开发商Mozilla提醒用户立即升级到最新版本，最好还要修改密码和登录信息。",
	            "title": "苹果或于9月9日发布iPhone6s 火狐爆严重漏洞",
	            "news_url": "http://m.jiemian.com/article/347958.html",
	            "icon_url": "http://img.jiemian.com/101/original/20150808/143899303035536900_a580x330.jpg",
	            "comment": 1200,
	            "type": 3
	        },
	        {
	            "id": 0,
	            "time": "2015-08-10",
	            "des": "凤凰科技讯 8月8日消息，今天有网友爆料，京东创始人兼CEO刘强东已与奶茶妹妹章泽天在朝阳区民政局领证结婚。",
	            "title": "刘强东与奶茶妹妹领证结婚 有图为证",
	            "news_url": "http://i.ifeng.com/news/sharenews.f?aid=100435430",
	            "icon_url": "http://d.ifengimg.com/mw604/y3.ifengimg.com/ifengimcp/pic/20150808/ce1b80056cfc584fafbf_size20_w450_h800.jpg",
	            "comment": 3000,
	            "type": 2
	        }
	    ]
	}
	
	json格式：
	用{}包含的是一个JsonObject  用[]包含的是一个JsonArray


		 */

		try{
			//从数据库获取新闻数据
			ArrayList<NewsBean> news = NewsDao.getNews();

			//将list中的数据封装成一个jsonArray对象
			JSONArray jsonArray = new JSONArray();
			for (NewsBean newsBean : news) {
				JSONObject newsJson = new JSONObject();
				newsJson.put("id", newsBean.getId());
				newsJson.put("title", newsBean.getTitle());
				newsJson.put("des", newsBean.getDes());
				newsJson.put("icon_url", newsBean.getIcon_url());
				newsJson.put("news_url", newsBean.getNews_url());
				newsJson.put("type", newsBean.getType());
				newsJson.put("time", newsBean.getTime());
				newsJson.put("comment", newsBean.getComment());
				jsonArray.put(newsJson);

			}

			//将jsonArray对象作为一个json对象，用来返回给客户端
			JSONObject allNewsJson = new JSONObject();
			allNewsJson.put("newss", jsonArray);
			response.getOutputStream().write(allNewsJson.toString().getBytes("gbk"));

		}catch (Exception e) {
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
