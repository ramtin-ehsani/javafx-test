import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Group Objects
        Text text = new Text("Email");
        Text text1 = new Text("Password");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));

        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();

//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                javafxDemo javafxDemo = new javafxDemo();
//                javafxDemo.start(primaryStage);
//            }
//        };

        Button button1 = new Button("Cancel");
        Button button2 = new Button("Submit");

//        button2.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);

        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400,200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(text,0,0);
        gridPane.add(textField,1,0);
        gridPane.add(text1,0,1);
        gridPane.add(passwordField,1,1);
        gridPane.add(button1,0,2);
        gridPane.add(button2,1,2);

        //Scene
        Scene scene = new Scene(gridPane);

        //Stage
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
