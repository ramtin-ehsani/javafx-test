import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class LoginScene extends LoginFX {
    public static Scene LoginScene(){
        //Group Objects
        Text text = new Text("Email");
        Text text1 = new Text("Password");
        Text text2 = new Text("Don't have an account?");

        Hyperlink signUp = new Hyperlink("Sign up now!");
        signUp.setOnAction(MouseEvent -> {
            mainWindow.setScene(SignUpScene.signUpScene());
        });
        TextFlow textFlow = new TextFlow(signUp);

        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,10));
        signUp.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,10));


        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("Invalid Input!" + "\n" + "Try Again");

        Button button1 = new Button("Cancel");
        Button button2 = new Button("Submit");
        button2.setOnAction(MouseEvent ->{
//            String Email = textField.getText();
//            if (Email.matches("^[a-z09A-Z][a-z0-9A-Z]*@[a-z0-9]*\\.[a-z]*"))
                mainWindow.setScene(MainScene.mainScene());
//            else{
//                textField.clear();
//                alert.showAndWait();
//            }
        } );
        button1.setOnAction(MouseEvent -> mainWindow.close());

        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1400,800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: mintcream;");

//        gridPane.getChildren().add(bg);
        gridPane.add(text,0,0);
        gridPane.add(textField,1,0);
        gridPane.add(text1,0,1);
        gridPane.add(passwordField,1,1);
        gridPane.add(button1,0,2);
        gridPane.add(button2,1,2);
        gridPane.add(text2,0,3);
        gridPane.add(textFlow,1,3);

//        String image = LoginFX.class.getResource("bg.png").toExternalForm();
//        gridPane.setStyle("-fx-background-image: url('" + image + "'); " +
//                "-fx-background-position: center center; " +
//                "-fx-background-repeat: stretch;");


        //Scene
        Scene scene;
        scene = new Scene(gridPane);

        return scene;
    }
}
