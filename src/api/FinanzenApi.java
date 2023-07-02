package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import data.Konstanten;
import data.News;

public class FinanzenApi {
	
	private FinanzenApi() {
		 throw new IllegalStateException("Utility class");
	}
	
	public static List<News> createTableOfNews() throws IOException {
		List<News> newsListToCreate = new ArrayList<>();
		List<Node> newsList = new ArrayList<>();
		
		Document doc = Jsoup.connect(Konstanten.PREFIX + "nachrichten/topnachrichten").get();
		Elements element =  doc.select("table[class='table news-list']");
		Node newsTable;
		if(!element.isEmpty()) {
			newsTable = element.get(0).childNodes().get(1);
			newsList = newsTable.childNodes();
		}
		
		for(int i = 0; i < newsList.size(); i++) {
			if(!newsList.get(i).childNodes().isEmpty()) {
				Node firstNode = newsList.get(i).childNode(0);
				if(firstNode.childNodeSize() > 1) {
					Node news = firstNode.childNode(1);
					Node news1 = firstNode.childNode(2);
					
					Node title = news.childNodes().get(0);
					String titleString = "";
					if(!title.childNodes().isEmpty()) {
						titleString = title.childNode(0).toString();
					}
					String link = title.attributes().get("href");
					
					String teaser = "";
					if(!news1.childNodes().isEmpty()) {
						teaser = news1.childNode(0).toString();
					}	
					
					News nachricht = new News(link, teaser, titleString);
					newsListToCreate.add(nachricht);
				}
			}
		}
		
		return newsListToCreate;
	}

}
