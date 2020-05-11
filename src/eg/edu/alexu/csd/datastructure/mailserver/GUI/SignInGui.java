package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignInGui extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage Primarystage) throws Exception {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(15);
        grid.setVgap(15);

        //Username label
        Label UserName = new Label("User Name");
        GridPane.setConstraints(UserName,0,0);

        //Username input
        TextField NameInput = new TextField();
        GridPane.setConstraints(NameInput,1,0);

        //Password label
        Label PassWord = new Label("PassWord");
        GridPane.setConstraints(PassWord,0,1);

        //Password input
        TextField PasswordInput = new TextField();
        GridPane.setConstraints(PasswordInput,1,1);

        //sign in button
        Button SignInButton = new Button("Sign In");
        GridPane.setConstraints(SignInButton,1,2);

        grid.getChildren().addAll(UserName,NameInput,PassWord,PasswordInput,SignInButton);

        Scene LogInScene = new Scene(grid,400,400);
        Primarystage.setTitle("Sign In");
        Primarystage.setScene(LogInScene);
        Primarystage.show();
    }
}
