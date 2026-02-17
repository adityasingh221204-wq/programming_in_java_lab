package com.ecodrive;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Updated path to match your resources/com/ecodrive/fxml/ structure
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("EcoDrive AI - Carbon Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}