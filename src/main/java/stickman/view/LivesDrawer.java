package stickman.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import stickman.model.Entity;
import stickman.model.GameEngine;
import stickman.model.Hero;

public class LivesDrawer {

    private int lives;
    private Text livesView;

    public LivesDrawer(GameEngine model) {
        for (Entity entity : model.getCurrentLevel().getEntities()) {
            if (entity instanceof Hero) {
                this.lives = ((Hero) entity).getLives();
                break;
            }
        }
        this.livesView = new Text("Lives: " + this.lives);
    }

    public void draw(GameEngine model, Pane pane) {
        double paneWidth = pane.getPrefWidth();
        double paneHeight = pane.getPrefHeight();

        this.livesView.setX(570);
        this.livesView.setY(25);
        this.livesView.setFill(Color.BLACK);
        this.livesView.setViewOrder(1);

        pane.getChildren().add(this.livesView);
    }

    public void update(GameEngine model) {
        for (Entity entity : model.getCurrentLevel().getEntities()) {
            if (entity instanceof Hero) {
                this.lives = ((Hero) entity).getLives();
                break;
            }
        }
        this.livesView.setText("Lives: " + this.lives);
    }
}