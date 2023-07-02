module FInanzen {
	requires javafx.controls;
	requires org.jsoup;
	requires java.xml;
	requires java.desktop;
	requires java.sql;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
