package JavaFx;

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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainScene {
    private static int index = 0;
    static List<Label> messages = new ArrayList<>();
    public static Scene mainScene(){
        Text text = new Text("Welcome to Messenger!");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
        text.setFill(Color.WHITE);

        TextArea textArea = new TextArea();
        textArea.setPromptText("TextMessage...");
        textArea.setPrefSize(400,50);
        textArea.getStylesheets().add("JavaFx/CSS.css");
        textArea.setWrapText(true);

        VBox chatBox = new VBox(10);
        HBox textBox = new HBox(10);

        Rectangle rectangle1 = new Rectangle(40,40);
        rectangle1.setFill(new ImagePattern(new Image("Images/sendLogo.png")));
        rectangle1.setOnMouseClicked(event -> {
            String textMessage = textArea.getText();
            if (!textMessage.equals("")){
                //            Label labelText = new Label(textMessage);
                Image image = new Image("Images/nima.jpg");
                Circle circle1 = new Circle(40);
                circle1.setFill(new ImagePattern(image));

                Label lblUserLeft = new Label();
                Label lblTextLeft = new Label();
                HBox hBoxLeft = new HBox(circle1,lblTextLeft);

                Label lblUserRight = new Label();
                Label lblTextRight = new Label();
                HBox hBoxRight = new HBox(lblTextRight);

                hBoxLeft.setAlignment(Pos.CENTER_LEFT);
                hBoxLeft.setSpacing(5);
                hBoxRight.setAlignment(Pos.CENTER_RIGHT);
                hBoxRight.setSpacing(5);

//            messages.add(labelText);
                textArea.clear();
                if(index%2==0){
//                messages.get(index).setAlignment(Pos.CENTER_LEFT);
                    lblTextLeft.setText(textMessage);
                    chatBox.getChildren().add(hBoxLeft);
                    System.out.println("1");

                }else{
//                messages.get(index).setAlignment(Pos.CENTER_RIGHT);
                    lblTextRight.setText(textMessage);
                    chatBox.getChildren().add(hBoxRight);
                    System.out.println("2");
                }
//            chatBox.getChildren().add(messages.get(index));
                index++;
            }
        });


        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefSize(900,1000);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(700,800);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10,10,10,10));

//        String background = LoginFX.class.getResource("wall2.jpg").toExternalForm();
        String background = "Images/wall2.jpg";
        gridPane.setStyle("-fx-background-image: url('" + background + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");

        gridPane.getStylesheets().add("JavaFx/CSS.css");
        chatBox.getStyleClass().add("chatbox");

        textBox.getChildren().addAll(textArea,rectangle1);
        scrollPane.setContent(chatBox);



        VBox vBox = new VBox(5);
        vBox.setMaxSize(60,1400);
        vBox.setMinSize(60,800);

        VBox parentVBox = new VBox();
        ScrollPane scrollPane1 = new ScrollPane(parentVBox);
        scrollPane1.setMinWidth(220);
        scrollPane1.setStyle("-fx-background-color: #172930; fx-background: #172930");
        scrollPane1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        parentVBox.setStyle("-fx-background-color: #172930");

        Image addImage = new Image("Images/add.png");
        Rectangle rectangle = new Rectangle(40,45);
        rectangle.setFill(new ImagePattern(addImage));
        rectangle.setOnMouseClicked(MouseEvent ->{
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(LoginFX.mainWindow);
            dialog.getIcons().add(new Image("Images/logo.png"));
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
            button.setOnMouseClicked(event -> {
                VBox vboxChild = new VBox();
                HBox hBox = new HBox(30);
                Image image = new Image("Images/nima.jpg");
                Circle circle1 = new Circle(40);
                circle1.setFill(new ImagePattern(image));
                Text text1 = new Text("Nima Ab");
                text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                text1.setFill(Color.WHITE);
                hBox.getChildren().addAll(circle1,text1);
                hBox.setAlignment(Pos.CENTER_LEFT);
                vboxChild.getChildren().addAll(hBox);
                parentVBox.getChildren().add(vboxChild);
                childVBoxesClicked(parentVBox,gridPane,scrollPane,textBox);
                dialog.close();
            });
            hBox2.getChildren().addAll(button1,button);

            dialogVbox.getChildren().addAll(text2,textField2,hBox2);
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();

        });

        vBox.getChildren().add(rectangle);
        vBox.setStyle("-fx-background-color: #25434F; -fx-padding: 10 0 0 0");
        vBox.setAlignment(Pos.TOP_CENTER);

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(vBox,scrollPane1,gridPane);
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getStylesheets().add("JavaFx/CSS.css");

        Scene scene = new Scene(splitPane,1100,800);

        return scene;
    }

    public static void childVBoxesClicked(VBox vBox, GridPane gridPane, ScrollPane scrollPane, HBox textBox){
        Background focusBackground = new Background( new BackgroundFill( Color.DARKSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY ) );
        Background unfocusBackground = new Background( new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY ) );
        Border border = new Border( new BorderStroke( Color.TRANSPARENT , BorderStrokeStyle.SOLID, null, null ) );
        for ( Node child : vBox.getChildren() )
        {
            VBox vb = ( VBox ) child;
            vb.setPadding( new Insets( 10 ) );
            vb.setBorder( border );

            // when vBox is clicked focus on it
            vb.setOnMouseClicked( ( e ) ->
            {
                vb.requestFocus();
                gridPane.getChildren().removeAll();
                if (!gridPane.getChildren().contains(scrollPane)){
                    gridPane.add(scrollPane,0,0);
                    gridPane.add(textBox,0,5);
                }
            } );

            // use different backgrounds for focused and unfocused states
            vb.backgroundProperty().bind( Bindings
                    .when( vb.focusedProperty() )
                    .then( focusBackground )
                    .otherwise( unfocusBackground )
            );

        }
    }
    public static void addUser(VBox vBox){

    }
}
