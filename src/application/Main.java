package application;

import java.io.IOException;

import api.FinanzenApi;
import data.Konstanten;
import data.MainData;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import layout.LayoutElements;
import layout.LayoutService;
import service.DierkesLooger;


public class Main extends Application {
	
	private static final DierkesLooger LOOGER = new DierkesLooger();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,1800,1000);
		LayoutElements elements = new LayoutElements();
		MainData mainData = new MainData();
			
		try {
			mainData.setTableOfNews(FinanzenApi.createTableOfNews());
		} catch(IOException e) {
			LOOGER.writeExceptionLog(e, Konstanten.NEWS_MESSAGE_ERROR, Main.class.getName());
		}
		
		LayoutService.addNewsItem(elements, mainData);
		
		MultipleSelectionModel<Label> newsModel = elements.getLvNews().getSelectionModel();
		newsModel.getSelectedItems().addListener((ListChangeListener<Label>)e->{
			LOOGER.writeInfoLog(newsModel.getSelectedItem().getText(), Main.class.getName());
		});
		
		LayoutService.createLayoutLvNews(root, elements);
		LayoutService.createLayoutKontoStaende(root, elements);
		LayoutService.setMainSettingsPrimaryStage(primaryStage, scene, elements);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
