import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class javafxDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Group objects
        /*Line line = new Line();
        line.setStartX(100);
        line.setStartY(150);
        line.setEndX(500);
        line.setEndY(150);

        Text text = new Text();
        text.setX(50);
        text.setY(140);
        text.setFont(new Font(45));
        text.setText("Text Sample!");*/

        Path myShape = new Path();
        MoveTo moveTo = new MoveTo(126,232);
        LineTo line1 = new LineTo(232,52);
        LineTo line2 = new LineTo(269,250);
        LineTo line3 = new LineTo(108,71);
        LineTo line4 = new LineTo(321,161);
        LineTo line5 = new LineTo(126,232);

        myShape.getElements().add(moveTo);
        myShape.getElements().addAll(line1,line2,line3,line4,line5);
        myShape.setFill(Color.BLUE);

        Group root = new Group();

        // Setting the nodes to root
        ObservableList list = root.getChildren();
        /*list.add(line);
        list.add(text);*/
        list.add(myShape);

        //Scene
        Scene scene = new Scene(root,600,300);
        scene.setFill(Color.BROWN);

        //Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sample!");
        primaryStage.show();

    }
}
