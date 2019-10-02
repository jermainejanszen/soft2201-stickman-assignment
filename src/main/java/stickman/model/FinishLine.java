package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class FinishLine implements Entity {

    private String imagePath;
    private double xPos;
    private double yPos;
    private double xVelocity;
    private double yVelocity;
    private double height;
    private double width;
    private Layer layer;
    private boolean levelComplete;

    @Override
    public void applyGravity() {
        return;
    }

    @Override
    public String getImagePath() {
        return this.imagePath;
    }

    @Override
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public double getXPos() {
        return this.xPos;
    }

    @Override
    public double getYPos() {
        return this.yPos;
    }

    @Override
    public double getXVelocity() {
        return this.xVelocity;
    }

    @Override
    public double getYVelocity() {
        return this.yVelocity;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public Layer getLayer() {
        return this.layer;
    }

    public boolean isLevelComplete() {
        return this.levelComplete;
    }

    @Override
    public boolean jump() {
        return false;
    }

    @Override
    public boolean moveRight() {
        return false;
    }

    @Override
    public boolean moveLeft() {
        return false;
    }

    @Override
    public boolean stopMoving() {
        return false;
    }

    @Override
    public void tickBehaviour(int tick) {
        return;
    }

    @Override
    public void collisionBehaviour(collisionType collision, Entity entityB) {
        if (entityB instanceof Hero) {
            this.levelComplete = true;
        }
        return;
    }

    public FinishLine(double xPos, Level level) {
        this.imagePath = "tree.png";
        this.height = 30.8;
        this.width = 20.0;
        this.xPos = xPos;
        this.yPos = level.getFloorHeight() - this.height;
        this.xVelocity = 0.0;
        this.yVelocity = 0.0;
        this.layer = Layer.FOREGROUND;
        this.levelComplete = false;
    }
}