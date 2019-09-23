package stickman.model;

import java.util.Random;

public class Slime implements Entity {

    // Slime's attributes
    private String imagePath;
    private double xPos;
    private double yPos;
    private double floorHeight;
    private double xVelocity;
    private double yVelocity;
    private double height;
    private double width;
    private Layer layer;

    // Slime's methods
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
        if (this.yVelocity == 0) {
            this.yVelocity = -5.0;
            return true;
        }
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
    public void applyGravity() {
        if (this.yPos + this.yVelocity > (this.floorHeight - this.height)) {
            this.yVelocity = 0;
            return;
        }

        this.yVelocity = this.yVelocity + acceleration;
        return;
    }

    @Override
    public void tickBehaviour() {
        this.xPos = this.xPos + this.xVelocity;
        this.yPos = this.yPos + this.yVelocity;
        this.applyGravity();
    }

    // Slime's contructor
    public Slime(String colour, String size, double startX, Level level) {
        this.floorHeight = level.getFloorHeight();

        switch (colour) {
        case "r":
            this.imagePath = "slimeRa.png";
            break;
        case "g":
            this.imagePath = "slimeGa.png";
            break;
        case "b":
            this.imagePath = "slimeBa.png";
            break;
        case "y":
            this.imagePath = "slimeYa.png";
            break;
        case "p":
            this.imagePath = "slimePa.png";
            break;
        default:
            System.out.println("Invalid colour: " + colour);
            break;
        }

        switch (size) {
        case "big":
            this.height = 40.0;
            this.width = 53.3;
            break;
        case "small":
            this.height = 20.0;
            this.width = 26.7;
            break;
        default:
            System.out.println("Invalid slime size: " + size);
            break;
        }

        this.xPos = startX;
        this.yPos = floorHeight;

        this.xVelocity = 0.0;
        this.yVelocity = 0.0;

        this.layer = Layer.FOREGROUND;
    }
}