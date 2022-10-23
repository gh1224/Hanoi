package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int N = 9;  // 1 ~ 13
    public static final int GAP = 20;
    public static final int HEIGHT = 30;
    public static final int BAR_X = 16;
    public static final int BAR_Y = HEIGHT * N + 50;
    public static final int DISTANCE = BAR_X + GAP * N * 2 + 50;
    public static final int START_X = GAP * N + 100;
    public static final int START_Y = BAR_Y + 200;
    public static final int WINDOW_X = (DISTANCE + START_X) * 2;
    public static final int BOTTOM_X = WINDOW_X - 50;
    public static final int BOTTOM_Y = 70;
    public static final int WINDOW_Y = START_Y + BOTTOM_Y + 50;

    public static AnchorPane root = new AnchorPane();
    public static Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);
    public static Controller control = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tower of Hanoi");
        primaryStage.setScene(scene);
        primaryStage.show();

        control.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
