package layout;

import java.util.List;

import data.FinanceProduct;
import data.Konstanten;
import data.MainData;
import data.News;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import queries.MySql;

public class LayoutService {
	
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

	public static void createLayoutLvNews(BorderPane root, LayoutElements elements) {
		VBox leftBorder = LayoutService.createVBOX(10, new Insets(15, 15, 15, 15));
		elements.getLvNews().setPrefWidth(400);
		elements.getLvNews().relocate(10, 30);
		elements.getNewsListLabel().relocate(10, 10);
		leftBorder.getChildren().addAll(elements.getNewsListLabel(), elements.getLvNews());
		root.setLeft(leftBorder);
	}
	
	public static void createLayoutKontoStaende(BorderPane root, LayoutElements elements) {
		VBox rightBorder = createVBOX(10, new Insets(15, 15, 15, 15));
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

}
