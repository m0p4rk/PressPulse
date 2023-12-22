package news.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import news.service.NewsService;

public class NewsController {

	public static void urltogettitle(String url){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("input URL : ");
		try {
			url = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(NewsService.getTitleByUrl(url));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void titletogeturl(String title){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("input TITLE : ");
		try {
			title = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			System.out.println(NewsService.getUrlByTitle(title));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
