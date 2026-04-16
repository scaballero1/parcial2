package co.edu.poli.examen2_caballero.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
          getClass().getResource("/co/edu/poli/examen2_caballero/vista/formulario.fxml")
        );

        Scene scene = new Scene(loader.load(), 400, 400);

        stage.setScene(scene);
        stage.setTitle("Inmuebles");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}