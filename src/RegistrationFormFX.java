import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationFormFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Objects
        Text text1 = new Text("Name");
        Text text2 = new Text("DoB");
        Text text3 = new Text("Gender");
        Text text4 = new Text("Reservation");
        Text text5 = new Text("Technologies Known");
        Text text6 = new Text("Educational");
        Text text7 = new Text("Location");

        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text6.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text7.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));


        TextField textField = new TextField();
        DatePicker datePicker = new DatePicker();

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButtonMale = new RadioButton("Male");
        radioButtonMale.setToggleGroup(toggleGroup);
        RadioButton radioButtonFemale = new RadioButton("Female");
        radioButtonFemale.setToggleGroup(toggleGroup);

        ToggleGroup reservation = new ToggleGroup();
        ToggleButton toggleButton = new ToggleButton("Yes");
        ToggleButton toggleButton1 = new ToggleButton("No");
        toggleButton.setToggleGroup(reservation);
        toggleButton1.setToggleGroup(reservation);

        CheckBox checkBox = new CheckBox("Java");
        CheckBox checkBox1 = new CheckBox("Python");

        ObservableList<String> names = FXCollections.observableArrayList(
                "Engineering", "MCA", "MBA", "Graduation", "MTECH", "Mphil", "Phd"
        );

        ListView<String> listView = new ListView<>(names);

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll(
                "Hyderabad", "Chennai", "Delhi", "Mumbai", "Vishakhapatnam"
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
        gridPane.add(textField,1,0);
        gridPane.add(text2,0,1);
        gridPane.add(datePicker,1,1);
        gridPane.add(text3,0,2);
        gridPane.add(radioButtonMale,1,2);
        gridPane.add(radioButtonFemale,2,2);
        gridPane.add(text4,0,3);
        gridPane.add(toggleButton,1,3);
        gridPane.add(toggleButton1,2,3);
        gridPane.add(text5,0,4);
        gridPane.add(checkBox,1,4);
        gridPane.add(checkBox1,2,4);
        gridPane.add(text6,0,5);
        gridPane.add(listView,1,5);
        gridPane.add(text7,0,6);
        gridPane.add(choiceBox,1,6);
        gridPane.add(button,2,8);

        gridPane.setStyle("-fx-background-color: beige");
        //Scene
        Scene scene = new Scene(gridPane);

        //Stage
        primaryStage.setTitle("Register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
