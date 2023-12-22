package news.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import news.controller.NewsController;

public class NewsView {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int input = Integer.parseInt(br.readLine());

			switch (input) {
			case 1:
				String url = br.readLine();
				NewsController.urltogettitle(url);
				break;

			case 2:
				String title = br.readLine();
				NewsController.titletogeturl(title);
				break;

			default:
				System.out.println("Input proper command");
				continue;
			}

		}
	}

}
