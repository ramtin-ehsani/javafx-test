import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainScene {
    public static Scene mainScene(){
        Text text = new Text("Welcome to Messenger!");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text.setFill(Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1000,800);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10,10,10,10));

        String background = LoginFX.class.getResource("wall1.jpg").toExternalForm();
        gridPane.setStyle("-fx-background-image: url('" + background + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");

        gridPane.add(text,0,50);


//        Button button = new Button("ClickMe!");
//        Button button1 = new Button("ClickMe!");

        Background focusBackground = new Background( new BackgroundFill( Color.DARKSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY ) );
        Background unfocusBackground = new Background( new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY ) );
        Border border = new Border( new BorderStroke( Color.TRANSPARENT , BorderStrokeStyle.SOLID, null, null ) );

        VBox vboxChild = new VBox();
        VBox vboxChild1 = new VBox();

        HBox hBox = new HBox(30);
        Image image = new Image("file:nima.jpg");
        Circle circle = new Circle(40);
        circle.setFill(new ImagePattern(image));
        Text text1 = new Text("Nima Ab");
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text1.setFill(Color.WHITE);
        hBox.getChildren().addAll(circle,text1);
        hBox.setAlignment(Pos.CENTER_LEFT);

        HBox hBox1 = new HBox(30);
        Image addImage = new Image("file:add.png");
        Rectangle rectangle = new Rectangle(30,30);
        rectangle.setFill(new ImagePattern(addImage));
        rectangle.setOnMouseClicked(MouseEvent ->{
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(LoginFX.mainWindow);
            VBox dialogVbox = new VBox(20);
            dialogVbox.setAlignment(Pos.CENTER);
            Text text2 = new Text("Add Your Friend:");
            TextField textField2 = new TextField();
            textField2.setPromptText("Username...");
            textField2.setMaxWidth(200);

            HBox hBox2 = new HBox(25);
            hBox2.setAlignment(Pos.CENTER);
            Button button = new Button("Search");
            Button button1 = new Button("Cancel");
            button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
            button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white");
            button1.setOnMouseClicked(mouseEvent ->{
                dialog.close();
            });
            hBox2.getChildren().addAll(button1,button);

            dialogVbox.getChildren().addAll(text2,textField2,hBox2);
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();

        });
        hBox1.getChildren().addAll(rectangle);

        vboxChild.getChildren().addAll(hBox);
        vboxChild1.getChildren().addAll(hBox1);


        // parent vBox that includes all vBoxes
        VBox parentVBox = new VBox(vboxChild1, vboxChild);
        parentVBox.setStyle("-fx-background-color: #172930");
//        String background2 = LoginFX.class.getResource("wall2.jpg").toExternalForm();
//        parentVBox.setStyle("-fx-background-image: url('" + background2 + "'); " +
//                "-fx-background-position: center center; " +
//                "-fx-background-repeat: stretch;");

        for ( Node child : parentVBox.getChildren() )
        {

            VBox vb = ( VBox ) child;
            vb.setPadding( new Insets( 10 ) );
            vb.setBorder( border );

            // when vBox is clicked focus on it
            vb.setOnMouseClicked( ( e ) ->
            {
                vb.requestFocus();
                TextArea textArea = new TextArea();
                textArea.setPromptText("TextMessage...");
                textArea.getStylesheets().add("CSS.css");
                textArea.setMinWidth(700);
                gridPane.getChildren().remove(text);
                gridPane.add(textArea,0,140);
            } );

            // use different backgrounds for focused and unfocused states
            vb.backgroundProperty().bind( Bindings
                    .when( vb.focusedProperty() )
                    .then( focusBackground )
                    .otherwise( unfocusBackground )
            );

        }
        GridPane gridPane1 = new GridPane();
        gridPane1.setMinSize(40,800);
        gridPane1.setMaxSize(60,800);

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(gridPane1,parentVBox,gridPane);
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getStylesheets().add("CSS.css");

//        splitPane.getItems().add(anchorPane);
//        gridPane.add(text,1,1);
//        splitPane.getItems().add(text);


        Scene scene = new Scene(splitPane,1400,800);

        return scene;
        //test
    }
}
