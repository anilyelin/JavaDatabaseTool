package org.openjfx.hellofx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;


/**
 * @author anil yelin
 */
public class App extends Application {

    private static Scene scene;
    
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
        stage.setTitle("Employee Manager v1.0");
        stage.show();
    }

    /**
     * 
     * @param fxml
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {

        scene.setRoot(loadFXML(fxml));
    }
    
    /**
     * 
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}