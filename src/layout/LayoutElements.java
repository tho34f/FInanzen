package layout;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class LayoutElements {
	
	//Labels
	private Label welcome = new Label("Herzlich Wilkommen in deiner Finanzverwaltung!");
	private Label newsListLabel = new Label("Nachrichtenliste");
	private List<Label> finaceProducts = new ArrayList<>();
	//TextFields
	private List<TextField> finaceProductsStandings = new ArrayList<>();
	//Images
	private Image account = new Image("coins.jpg");
	private Image exit = new Image("exit.png");
	//ListViews
	private ListView<Label> lvNews = new ListView<>();
	
	//Menu and MenuItems
	private Menu menuView = new Menu("View");
	private Menu menuEdit = new Menu("Edit");
	private MenuItem closeApplication = new MenuItem("Programm beenden");
	private Menu menuFile = new Menu("File");
	private MenuBar menuBar = new MenuBar();

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

	public Label getWelcome() {
		return welcome;
	}

	public void setWelcome(Label welcome) {
		this.welcome = welcome;
	}

	public Menu getMenuView() {
		return menuView;
	}

	public void setMenuView(Menu menuView) {
		this.menuView = menuView;
	}

	public Menu getMenuEdit() {
		return menuEdit;
	}

	public void setMenuEdit(Menu menuEdit) {
		this.menuEdit = menuEdit;
	}

	public MenuItem getCloseApplication() {
		return closeApplication;
	}

	public void setCloseApplication(MenuItem closeApplication) {
		this.closeApplication = closeApplication;
	}

	public Menu getMenuFile() {
		return menuFile;
	}

	public void setMenuFile(Menu menuFile) {
		this.menuFile = menuFile;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public Image getExit() {
		return exit;
	}

	public void setExit(Image exit) {
		this.exit = exit;
	}
}
