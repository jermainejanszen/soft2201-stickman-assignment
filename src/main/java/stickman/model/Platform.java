package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class Platform implements Entity {
    private String imagePath;
    private double xPos;
    private double yPos;
    private double xVelocity;
    private double yVelocity;
    private double height;
    private double width;
    private Layer layer;

    @Override
    public void applyGravity() {
        // No action needed
    }

    @Override
    public String getImagePath() {
        return this.imagePath;
    }

    @Override
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return;
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

    @Override
    public boolean jump() {
        return false;
    }

    @Override
    public boolean moveRight() {
        if (this.xVelocity == 0.0) {
            this.xVelocity = 1.0;
            return true;
        } else if (this.xVelocity < 0) {
            this.xVelocity = 0.0;
            return true;
        }
        return false;
    }

    @Override
    public boolean moveLeft() {
        if (this.xVelocity == 0.0) {
            this.xVelocity = -1.0;
            return true;
        } else if (this.xVelocity > 0) {
            this.xVelocity = 0.0;
            return true;
        }
        return false;
    }

    @Override
    public boolean stopMoving() {
        if (this.xVelocity != 0.0) {
            this.xVelocity = 0.0;
            return true;
        }
        return false;
    }

    @Override
    public void tickBehaviour(int tick) {
        return;
    }

    @Override
    public void collisionBehaviour(collisionType collision, Entity entityB) {
        return;
    }

    public Platform(double xPos, double yPos, double width, Level level) {
        this.xPos = xPos;
        if (yPos > level.getFloorHeight() - 4.0) {
            this.yPos = level.getFloorHeight() - 4.0;
        } else {
            this.yPos = yPos;
        }
        this.width = width;

        this.height = 8.0;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.imagePath = "foot_tile.png";
        this.layer = Layer.FOREGROUND;
    }
}