package stickman.model;

public class Hero implements Entity {
    // Hero's attributes
    private String imagePath;
    private double xPos;
    private double yPos;
    private double floorHeight;
    private double xVelocity;
    private double yVelocity;
    private double height;
    private double width;
    private Layer layer;

    // Hero's methods
    @Override
    public String getImagePath() {
        return this.imagePath;
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

    // Hero's constructor
    public Hero(double xPos, String size, Level level) {
        this.imagePath = "ch_stand1.png";
        this.xPos = xPos;
        switch (size) {
        case "tiny":
            this.height = 17;
            this.width = 10;
            break;
        case "normal":
            this.height = 34;
            this.width = 20;
            break;
        case "large":
            this.height = 51;
            this.width = 30;
            break;
        case "giant":
            this.height = 68;
            this.width = 40;
            break;
        default:
            System.out.println("Invalid hero size.");
            System.exit(1);
        }
        this.yPos = level.getFloorHeight() - this.height;
        this.floorHeight = level.getFloorHeight();
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.layer = Layer.FOREGROUND;
    }
}