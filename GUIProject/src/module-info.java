module GUIProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.web;
	
	opens hust.soict.hedspi.javafx to javafx.graphics, javafx.fxml,javafx.base, javafx.controls, javafx.media, javafx.swing;
}
