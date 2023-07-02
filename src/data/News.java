package data;

public class News {
	
	private String link;
	private String teaser;
	private String title;
	
	public News(String link, String teaser, String title) {
		this.link = link;
		this.teaser = teaser;
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
