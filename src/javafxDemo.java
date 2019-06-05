import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class javafxDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Group objects
        Line line = new Line();
        line.setStartX(100);
        line.setStartY(150);
        line.setEndX(500);
        line.setEndY(150);

        Circle circle = new Circle(300,180,90);

        Text text = new Text();
        text.setX(350);
        text.setY(140);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC,30));
        text.setText("Text Sample!");
        text.setFill(Color.BEIGE);
        text.setStrokeWidth(0.5);
        text.setStroke(Color.BLUE);
        text.setStrikethrough(true);

        //Linear Gradient Coloring
        Stop[] stops = new Stop[]{
                new Stop(0,Color.DARKSLATEBLUE),
                new Stop(1,Color.DARKRED)
        };
        LinearGradient linearGradient = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE,stops);


        Text text1 = new Text();
        text1.setX(350);
        text1.setY(170);
        text1.setText("Text Sample 2!");
        text1.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,25));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(1);
        text1.setStroke(Color.BLACK);
        text1.setUnderline(true);

        Image image = new Image("https://encrypted-tbn1.gstatic.com"
                + "/images?q=tbn:ANd9GcRQub4GvEezKMsiIf67U"
                + "rOxSzQuQ9zl5ysnjRn87VOC8tAdgmAJjcwZ2qM");
        //Image Pattern
        ImagePattern imagePattern = new ImagePattern(image,20,20,40,40,false);

//        circle.setFill(imagePattern);
        circle.setFill(linearGradient);

        ImageView imageView = new ImageView(image);
        imageView.setX(20);
        imageView.setY(50);
        imageView.setFitHeight(200);
        imageView.setFitWidth(400);

        //Effect
//        Glow glow = new Glow();
//        glow.setLevel(0.9);

//        imageView.setEffect(glow);

        Path myShape = new Path();
        MoveTo moveTo = new MoveTo(126,232); //Starting point of the shape
        LineTo line1 = new LineTo(232,52);
        LineTo line2 = new LineTo(269,250);
        LineTo line3 = new LineTo(108,71);
        LineTo line4 = new LineTo(321,161);
        LineTo line5 = new LineTo(126,232);

        myShape.getElements().add(moveTo);
        myShape.getElements().addAll(line1,line2,line3,line4,line5);
        myShape.setFill(Color.BLUE);

        TextField textField = new TextField();
        textField.setLayoutX(20);
        textField.setLayoutY(50);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circle.setFill(Color.WHITE);
            }
        };
        EventHandler<KeyEvent> eventHandler1 = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                circle.setFill(Color.BLUE);
            }
        };
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
        textField.addEventFilter(KeyEvent.KEY_TYPED,eventHandler1);


        Group root = new Group();

        // Setting the nodes to root
        ObservableList list = root.getChildren();
//        list.add(line);
//        list.add(text);
//        list.add(text1);
//        list.add(myShape);
//        list.add(imageView);
        list.add(circle);
        list.add(textField);

        //Scene
        Scene scene = new Scene(root,600,300);
        scene.setFill(Color.BLACK);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sample!");
        primaryStage.show();

    }
}
