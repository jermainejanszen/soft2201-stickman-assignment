package stickman.model;

import stickman.model.LevelImpl.collisionType;

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
    private int lives;
    private boolean invulnerability;
    private int invulnerabilityTicks;

    // Hero's methods
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

    public int getLives() {
        return this.lives;
    }

    public boolean isInvulnerable() {
        return this.invulnerability;
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
    public void tickBehaviour(int tick) {
        this.xPos = this.xPos + this.xVelocity;
        this.yPos = this.yPos + this.yVelocity;
        this.applyGravity();
        this.animate(tick);
        if (invulnerability) {
            if (invulnerabilityTicks == 60) {
                invulnerability = false;
                invulnerabilityTicks = 0;
            }
            invulnerabilityTicks++;
        }
    }

    @Override
    public void collisionBehaviour(LevelImpl.collisionType collision, Entity entityB) {
        if (entityB instanceof Slime) {
            if (collision == collisionType.LEFT || collision == collisionType.RIGHT) {
                if (!invulnerability) {
                    this.lives = this.lives - 1;
                    invulnerability = true;
                }

                if (collision == collisionType.LEFT) {
                    this.xPos = this.xPos - 2;
                } else {
                    this.xPos = this.xPos + 2;
                }
            }
        } else if (entityB instanceof Platform) {
            switch (collision) {
            case LEFT:
                this.xPos = this.xPos - 2;
                break;
            case RIGHT:
                this.xPos = this.xPos + 2;
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

    public void animate(int tick) {
        int loopTick = tick % 90;

        // Not moving
        if (this.xVelocity == 0) {
            String currentImage = this.imagePath;
            if (currentImage.charAt(3) == 's') {
                if (currentImage.charAt(8) - '0' < 4) {
                    int nextImage = Math.floorDiv(loopTick, 31) + 1;
                    this.imagePath = (String.format("ch_stand%d.png", nextImage));
                } else {
                    int nextImage = Math.floorDiv(loopTick, 31) + 4;
                    this.imagePath = (String.format("ch_stand%d.png", nextImage));
                }
            } else {
                if (currentImage.charAt(7) - '0' < 5) {
                    int nextImage = Math.floorDiv(loopTick, 31) + 1;
                    this.imagePath = (String.format("ch_stand%d.png", nextImage));
                } else {
                    int nextImage = Math.floorDiv(loopTick, 31) + 4;
                    this.imagePath = (String.format("ch_stand%d.png", nextImage));
                }
            }
        }

        // Moving right
        if (this.xVelocity > 0) {
            int nextImage = Math.floorDiv(loopTick, 23) + 1;
            this.imagePath = (String.format("ch_walk%d.png", nextImage));
        }

        // Moving left
        if (this.xVelocity < 0) {
            int nextImage = Math.floorDiv(loopTick, 23) + 5;
            this.imagePath = (String.format("ch_walk%d.png", nextImage));
        }
    }

    /**
     * Used to construct a Hero entity object.
     * 
     * @param xPos  X position to start the Hero at.
     * @param size  How large the hero will be. Can be tiny, normal, large, or
     *              giant.
     * @param level The level that the hero will be a part of.
     */
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
        this.lives = 3;
        this.invulnerability = false;
    }
}