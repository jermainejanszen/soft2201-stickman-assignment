package stickman.model;

import java.util.Random;

public class Cloud implements Entity {
    private String imagePath;
    private double xPos;
    private double yPos;
    private double xVelocity;
    private double yVelocity;
    private double height;
    private double width;
    private Layer layer;

    /**
     * Used to construct a Cloud entity object.
     * 
     * @param velocity The velocity that the cloud will travel at.
     * @param level    The level that the cloud will be a part of.
     */
    public Cloud(double velocity, Level level) {
        Random rand = new Random();
        int randomCloud = rand.nextInt(2);
        if (randomCloud == 1) {
            this.imagePath = "cloud_2.png";
            this.height = 22;
            this.width = 80;
        } else {
            this.imagePath = "cloud_1.png";
            this.height = 10;
            this.width = 40;
        }

        this.yPos = 30 + rand.nextInt(60);
        this.xPos = -20 + rand.nextInt(200);

        this.xVelocity = velocity / 60;
        this.yVelocity = 0;
        this.layer = Layer.BACKGROUND;
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
    public void applyGravity() {
        return;
    }

    @Override
    public void tickBehaviour(int tick) {
        this.xPos = this.xPos + this.xVelocity;
    }

    @Override
    public void collisionBehaviour(LevelImpl.collisionType collision, Entity entityB) {
        return;
    }
}