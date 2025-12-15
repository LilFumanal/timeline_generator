package fr.lil.timeline;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @java.lang.Override
    public void start(Stage stage) throws Exception {
        Label titre = new Label("Titre");
        VBox conteneur = new VBox(titre);
        Scene scene = new Scene(conteneur);
        stage.setTitle("Fenêtre");
        stage.setScene(scene);
        stage.show();
    }
}