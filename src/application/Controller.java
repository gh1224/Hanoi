package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {
    private static final int N = Main.N;  // 1 ~ 9
    public static final int BOTTOM_X = Main.BOTTOM_X;
    public static final int BOTTOM_Y = Main.BOTTOM_Y;
    private static final int BAR_X = Main.BAR_X;
    private static final int BAR_Y = Main.BAR_Y;
    private static final int DISTANCE = Main.DISTANCE;
    private static final int START_X = Main.START_X;
    private static final int START_Y = Main.START_Y;
    private static final int WINDOW_X = Main.WINDOW_X;

    private static AnchorPane root = Main.root;

    private static final Color BAR_COLOR = Color.rgb(200, 200, 200);
    private static final Color BOTTOM_COLOR = Color.rgb(200, 200, 200);

    private int[] cnt = { N, 0, 0 };
    private Form[] disk = new Form[N];
    private int time = 0;
    private Timeline timeline;

    public void play() {
        init();
        move(N - 1, 0, 2, 1);
    }

    private void init() {
        draw();
        for (int i = 0; i < N; i++)
            disk[i] = new Form(i);
    }

    private void draw() {
        Rectangle[] bar = new Rectangle[3];
        for (int i = 0; i < 3; i++) {
            bar[i] = new Rectangle(START_X + DISTANCE * i, START_Y - BAR_Y, BAR_X, BAR_Y);
            bar[i].setFill(BAR_COLOR);
            root.getChildren().add(bar[i]);
        }

        Rectangle bottom = new Rectangle((WINDOW_X - BOTTOM_X) / 2, START_Y, BOTTOM_X, BOTTOM_Y);
        bottom.setFill(BOTTOM_COLOR);
        root.getChildren().add(bottom);
    }

    private void move(int n, int from, int to, int by) {
        if (n == -1)
            return;
        move(n - 1, from, by, to);
        moveOne(n, from, to);
        move(n - 1, by, to, from);
    }

    private void moveOne(int n, int from, int to) {
        time++;

        timeline = new Timeline(new KeyFrame(Duration.millis(time * 500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cnt[from]--;
                disk[n].move(to - from, cnt[to]++);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
}