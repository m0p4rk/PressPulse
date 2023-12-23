package news.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import news.model.NewsScraper;

public class JSOUPUtil {

    public static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = NewsScraper.class.getClassLoader().getResourceAsStream("jsoup.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find jsoup.properties");
                return null;
            }
            properties.load(input);
        }
        return properties;
    }
}
