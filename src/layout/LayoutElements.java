package layout;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;

public class LayoutElements {
	
	private Image account = new Image("coins.jpg");
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
}
