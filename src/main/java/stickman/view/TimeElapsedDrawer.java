package stickman.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import stickman.model.Entity;
import stickman.model.GameEngine;
import stickman.model.Hero;

public class TimeElapsedDrawer {

    private int seconds;
    private Text secondsView;

    public TimeElapsedDrawer(GameEngine model) {
        this.seconds = model.getCurrentLevel().getSecondsElapsed();
        this.secondsView = new Text("Time Elapsed: " + this.seconds);
    }

    public void draw(GameEngine model, Pane pane) {
        double paneWidth = pane.getWidth();
        double paneHeight = pane.getHeight();

        this.secondsView.setX(paneWidth * 8 / 10);
        this.secondsView.setY(paneHeight * 1 / 10);
        this.secondsView.setFill(Color.BLACK);
        this.secondsView.setViewOrder(1);

        pane.getChildren().add(this.secondsView);
    }

    public void update(GameEngine model) {
        this.seconds = model.getCurrentLevel().getSecondsElapsed();
        this.secondsView.setText("Time Elapsed: " + this.seconds);
    }
}