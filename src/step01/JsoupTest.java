package step01;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

	public static void main(String[] args) throws IOException {

		
		Document doc = Jsoup.connect("https://www.w3schools.com/java/default.asp").get();

		Elements docs = doc.select("#main > div.w3-panel.w3-note > p");
		
		for(Element e : docs) {
			System.out.println(e.text());
		}
		


		
		
	}

}


////Loading HTML from url
//Document doc = Jsoup.connect(url).get();
////Using CSS selector get data from it
//Elements newsHeadlines = doc.select("#news-headlines");
////Circuit element / data processing
//for (Element headline : newsHeadlines) {
//    System.out.println(headline.text());
//}
////속성, 텍스트, HTML 추출
//String linkHref = element.attr("href");
//String linkText = element.text();
//String html = element.html();