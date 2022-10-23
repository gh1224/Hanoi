package application;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {
    private static final int N = Main.N;  // 1 ~ 9
    private static final int GAP = Main.GAP;
    private static final int HEIGHT = Main.HEIGHT;
    private static final int BAR_X = Main.BAR_X;
    private static final int DISTANCE = Main.DISTANCE;
    private static final int START_X = Main.START_X;
    private static final int START_Y = Main.START_Y;

    private static AnchorPane root = Main.root;

    private static final Color[] COLOR = {
            Color.rgb(15, 0, 0),
            Color.rgb(35, 0, 0),
            Color.rgb(55, 0, 0),
            Color.rgb(75, 0, 0),
            Color.rgb(95, 0, 0),
            Color.rgb(115, 0, 0),
            Color.rgb(135, 0, 0),
            Color.rgb(155, 0, 0),
            Color.rgb(175, 0, 0),
            Color.rgb(195, 0, 0),
            Color.rgb(215, 0, 0),
            Color.rgb(235, 0, 0),
            Color.rgb(255, 0, 0)
    };

    private Rectangle rect;

    public Form(int n) {
        int x = START_X - (GAP * (n + 1));
        int y = START_Y - (N - n) * HEIGHT;
        int width = GAP * (n + 1) * 2 + BAR_X;
        int height = HEIGHT;
        rect = new Rectangle(x, y, width, height);
        rect.setFill(COLOR[n]);

        root.getChildren().add(rect);
    }

    public void move(int moveX, int moveY) {
        rect.setX(rect.getX() + moveX * DISTANCE);
        rect.setY(START_Y - (moveY + 1) * HEIGHT);
    }
}
