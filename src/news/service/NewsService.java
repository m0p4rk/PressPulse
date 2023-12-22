package news.service;

import java.sql.SQLException;
import java.util.Map;

import news.dao.NewsDAO;

public class NewsService {
	
	public static Map<String, String> getAllData() throws ClassNotFoundException, SQLException {
	    Map<String, String> newsMap = null;
	    newsMap = NewsDAO.getAllNews();

	    return newsMap;
	}


	public static String geturlbytitle(String title) {

	}

	public static String gettitlebyurl(String url) {

	}

}
