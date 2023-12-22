package news.service;

import java.sql.SQLException;
import java.util.ArrayList;

import news.dao.NewsDAO;
import news.dto.News;

public class NewsService {
	
	public static ArrayList<News> getAllData() throws ClassNotFoundException, SQLException{
		ArrayList<News> newsList = null;
		newsList = NewsDAO.getAllNews();
		
		return newsList;
	}

	public static String geturlbytitle(String title) {

	}

	public static String gettitlebyurl(String url) {

	}

}
