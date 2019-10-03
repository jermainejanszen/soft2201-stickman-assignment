package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class Slime implements Entity {

    private String imagePath;
    private double xPos;
    private double yPos;
    private double floorHeight;
    private double xVelocity;
    private double yVelocity;
    private double height;
    private double width;
    private Layer layer;
    public boolean die;

    /**
     * Used to create a new slime entity.
     * 
     * @param size   The size of the slime.
     * @param startX The starting x position of the slime.
     * @param level  The level that the slime is in.
     */
    public Slime(String size, double startX, Level level) {
        this.floorHeight = level.getFloorHeight();

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
        this.yPos = floorHeight - this.height;

        this.xVelocity = 0.0;
        this.yVelocity = 0.0;

        this.layer = Layer.FOREGROUND;
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
        if (this.yVelocity == 0) {
            this.yVelocity = -4.0;
            return true;
        }
        return false;
    }

    @Override
    public boolean moveRight() {
        this.xVelocity = 0.5;
        return false;
    }

    @Override
    public boolean moveLeft() {
        this.xVelocity = -0.5;
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
    public void tickBehaviour(int tick) {
        this.xPos = this.xPos + this.xVelocity;
        this.yPos = this.yPos + this.yVelocity;
        this.applyGravity();
    }

    public void think(Level level) {
        return;
    }

    @Override
    public void collisionBehaviour(LevelImpl.collisionType collision, Entity entityB) {
        if (entityB instanceof Hero) {
            if (collision == collisionType.BOTTOM) {
                this.die = true;
            }
        } else if (entityB instanceof Platform) {
            switch (collision) {
            case LEFT:
                this.xPos = this.xPos - 1;
                this.xVelocity = -this.xVelocity;
                break;
            case RIGHT:
                this.xPos = this.xPos + 1;
                this.xVelocity = -this.yVelocity;
                break;
            case TOP:
                this.yVelocity = 0.0;
                break;
            case BOTTOM:
                this.yVelocity = 0.5;
                break;
            default:
                break;
            }
        }
        return;
    }
}