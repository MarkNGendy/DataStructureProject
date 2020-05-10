package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import java.awt.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainGui extends Application {
Button signIn;
Button signUp;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(15);
        grid.setVgap(15);

        primaryStage.setTitle("Mail Server");
        signIn = new Button();
        signIn.setText("Sign In");
        signUp = new Button();
        signUp.setText("Sign Up");


        GridPane.setConstraints(signIn,10,10);
        GridPane.setConstraints(signUp,10,11);
        grid.getChildren().addAll(signUp,signIn);

        Scene scene = new Scene(grid,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
