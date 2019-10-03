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

    /**
     * Used to create a new platform entity.
     * 
     * @param xPos  The x position of the platform.
     * @param yPos  The y position of the platform.
     * @param width The width of the platform.
     * @param level The level that the platform is in.
     */
    public Platform(double xPos, double yPos, double width, Level level) {
        this.xPos = xPos;
        this.width = width;
        this.height = 10.0;
        if (yPos > level.getFloorHeight() - this.height) {
            this.yPos = level.getFloorHeight() - this.height;
        } else {
            this.yPos = yPos;
        }
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.imagePath = "foot_tile.png";
        this.layer = Layer.FOREGROUND;
    }

    @Override
    public void applyGravity() {
        /* No action needed */
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
        return;
    }
}