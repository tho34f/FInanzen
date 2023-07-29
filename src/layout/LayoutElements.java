package layout;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class LayoutElements {
	
	//Labels
	private Label newsListLabel = new Label("Nachrichtenliste");
	private List<Label> finaceProducts = new ArrayList<>();
	//TextFields
	private List<TextField> finaceProductsStandings = new ArrayList<>();
	//Images
	private Image account = new Image("coins.jpg");
	//ListViews
	private ListView<Label> lvNews = new ListView<>();

	public ListView<Label> getLvNews() {
		return lvNews;
	}

	public void setLvNews(ListView<Label> lvNews) {
		this.lvNews = lvNews;
	}

	public Image getAccount() {
		return account;
	}

	public void setAccount(Image account) {
		this.account = account;
	}

	public List<Label> getFinaceProducts() {
		return finaceProducts;
	}

	public void setFinaceProducts(List<Label> finaceProducts) {
		this.finaceProducts = finaceProducts;
	}

	public List<TextField> getFinaceProductsStandings() {
		return finaceProductsStandings;
	}

	public void setFinaceProductsStandings(List<TextField> finaceProductsStandings) {
		this.finaceProductsStandings = finaceProductsStandings;
	}

	public Label getNewsListLabel() {
		return newsListLabel;
	}

	public void setNewsListLabel(Label newsListLabel) {
		this.newsListLabel = newsListLabel;
	}
}
