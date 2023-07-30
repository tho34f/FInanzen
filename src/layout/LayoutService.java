package layout;

import java.util.List;

import data.FinanceProduct;
import data.Konstanten;
import data.MainData;
import data.News;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import queries.MySql;
import service.DierkesLooger;

public class LayoutService {
	
	private final DierkesLooger LOGGER = new DierkesLooger();
	private static final Insets PADDING_ONE = new Insets(0, 0,15, 0);
	private static final Insets PADDING_TWO = new Insets(15, 15, 15, 15);
	
	private LayoutService() {
		throw new IllegalStateException("Utility class");
	}

	public static void addNewsItem(LayoutElements elements, MainData data) {
		List<News> allNews = data.getTableOfNews();
		for(int i = 0; i < allNews.size(); i++) {
			addItem(allNews.get(i),elements);
		}
	}
	
	public static void addItem(News item, LayoutElements elements) {
		if(!item.getTitle().isBlank()) {
	        Label label = new Label(item.getTitle());
	        label.setWrapText(true);
	        elements.getLvNews().getItems().add(label);
		}
    }
	
	public static void createMenuBar(LayoutElements elements) {
		elements.getMenuBar().setPrefWidth(1000);
		elements.getMenuBar().getMenus().addAll(elements.getMenuFile(), elements.getMenuEdit(), elements.getMenuView());
		elements.getCloseApplication().setGraphic(createImageView(elements.getExit()));
		elements.getMenuFile().getItems().addAll(elements.getCloseApplication());
	}
	
	public static void createTopBorder(BorderPane root, LayoutElements elements) {
		VBox topBorder = createVBOXWithAlignment(10, PADDING_ONE);
		elements.getWelcome().setFont(Font.font("cambria", 24));
		topBorder.getChildren().addAll(elements.getMenuBar(), elements.getWelcome());
		root.setTop(topBorder);
	}

	public static void createLayoutLvNews(BorderPane root, LayoutElements elements) {
		VBox leftBorder = createVBOX(10, PADDING_TWO);
		elements.getLvNews().setPrefWidth(400);
		elements.getLvNews().relocate(10, 30);
		elements.getNewsListLabel().relocate(10, 10);
		leftBorder.getChildren().addAll(elements.getNewsListLabel(), elements.getLvNews());
		root.setLeft(leftBorder);
	}
	
	public static void createLayoutKontoStaende(BorderPane root, LayoutElements elements) {
		VBox rightBorder = createVBOX(10, PADDING_TWO);
		HBox hLeftBorder = null;
		Label productLabel = null;
		TextField productField = null;
		
		List<FinanceProduct> financeProducts = MySql.getInstance().getProductQueries().getFinanceProducts();
		for(FinanceProduct product : financeProducts) {
			hLeftBorder = createHBOX(10);
			//Label
			productLabel = new Label(product.getBezeichnung());
			productLabel.setWrapText(true);
			elements.getFinaceProducts().add(productLabel);
			//TextField with Standings
			productField = new TextField(product.getStanding().toString());
			productField.setDisable(true);
			elements.getFinaceProductsStandings().add(productField);
			hLeftBorder.getChildren().addAll(productLabel, productField);
			rightBorder.getChildren().add(hLeftBorder);
		}

		root.setRight(rightBorder);
	}

	public static void setMainSettingsPrimaryStage(Stage primaryStage, Scene scene, LayoutElements elements) {
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(elements.getAccount());
		primaryStage.setTitle(Konstanten.APPICATION_TITLE);
		primaryStage.setResizable(false);
	}
	
	public static VBox createVBOX(double spacing, Insets padding) {
		VBox vbox = new VBox();
		vbox.setSpacing(spacing);
		vbox.setPadding(padding);
		return vbox;
	}
	
	public static HBox createHBOX(double spacing) {
		HBox hbox = new HBox();
		hbox.setSpacing(spacing);
		return hbox;
	}
	
	public static VBox createVBOXWithAlignment(double spacing, Insets padding) {
		VBox vbox = new VBox();
		vbox.setSpacing(spacing);
		vbox.setPadding(padding);
		vbox.setAlignment(Pos.CENTER);
		return vbox;
	}
	
	public static ImageView createImageView(Image im) {
		ImageView iv = new ImageView(im);
		iv.setFitHeight(20);
		iv.setFitWidth(20);
		return iv;
	}

	public static void createLayout(BorderPane root, LayoutElements elements) {
		createMenuBar(elements);
		createTopBorder(root, elements);
		createLayoutLvNews(root, elements);
		createLayoutKontoStaende(root, elements);
	}

}
