package layout;

import java.util.List;

import data.Konstanten;
import data.MainData;
import data.News;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

	public static void createLayoutLvNews(Pane root, LayoutElements elements) {
		Label newsListLabel = new Label("Nachrichtenliste");
		elements.getLvNews().setPrefWidth(400);
		elements.getLvNews().relocate(10, 30);
		newsListLabel.relocate(10, 10);
		root.getChildren().addAll(elements.getLvNews(), newsListLabel);
	}

	public static void setMainSettingsPrimaryStage(Stage primaryStage, Scene scene, LayoutElements elements) {
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(elements.getAccount());
		primaryStage.setTitle(Konstanten.APPICATION_TITLE);
		primaryStage.setResizable(false);
	}

}
