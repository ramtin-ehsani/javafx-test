import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SignUpScene {
    public static Scene signUpScene(){
        Text text1 = new Text("Name");
        Text text2 = new Text("Last Name");
        Text text3 = new Text("User Name");
        Text text4 = new Text("Password");
        Text text5 = new Text("Gender");
        Text text6 = new Text("Date of Birth");
        Text text7 = new Text("Location");

        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text6.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text7.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        PasswordField passwordField = new PasswordField();
        DatePicker datePicker = new DatePicker();

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButtonMale = new RadioButton("Male");
        radioButtonMale.setToggleGroup(toggleGroup);
        RadioButton radioButtonFemale = new RadioButton("Female");
        radioButtonFemale.setToggleGroup(toggleGroup);

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll(
                "Tehran", "Shiraz", "Mashhad"
        );

        Button button = new Button("Submit");
        button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white");

        //GridPane
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,500);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(text1,0,0);
        gridPane.add(textField1,1,0);
        gridPane.add(text2,0,1);
        gridPane.add(textField2,1,1);
        gridPane.add(text3,0,2);
        gridPane.add(textField3,1,2);
        gridPane.add(text5,0,3);
        gridPane.add(radioButtonMale,1,3);
        gridPane.add(radioButtonFemale,2,3);
        gridPane.add(text4,0,4);
        gridPane.add(passwordField,1,4);
        gridPane.add(text6,0,5);
        gridPane.add(datePicker,1,5);
        gridPane.add(text7,0,6);
        gridPane.add(choiceBox,1,6);
        gridPane.add(button,2,8);

        gridPane.setStyle("-fx-background-color: beige");

        Scene scene = new Scene(gridPane);
        return scene;

    }
}
