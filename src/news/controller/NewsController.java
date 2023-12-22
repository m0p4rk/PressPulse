package news.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import news.service.NewsService;

public class NewsController {

	public static void urltogettitle(String url) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input URL");
		url = br.readLine();

		System.out.println(NewsService.gettitlebyurl(url));

	}

	public static void titletogeturl(String title) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		title = br.readLine();
		System.out.println("input TITLE");

		System.out.println(NewsService.geturlbytitle(title));
	}

}
