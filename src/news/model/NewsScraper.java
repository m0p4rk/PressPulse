package news.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import news.util.JSOUPUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class NewsScraper {

	public static Map<String, String> getNews() throws IOException {
		Properties properties = JSOUPUtil.loadProperties();
		if (properties == null) {
			return new HashMap<>();
		}
		String url = properties.getProperty("js.url");
		String selectQuery = properties.getProperty("js.select");

		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select(selectQuery);

		HashMap<String, String> newsList = new HashMap<>();
		for (Element link : links) {
			String title = link.text();
			String linkUrl = link.absUrl("href");
			newsList.put(title, linkUrl);
		}
		return newsList;
	}

	public static void main(String[] args) throws IOException {
		Map<String, String> newsMap = getNews();
		for (Map.Entry<String, String> entry : newsMap.entrySet()) {
			System.out.println("Title: " + entry.getKey() + "\nURL: " + entry.getValue() + "\n");
		}
	}
}
