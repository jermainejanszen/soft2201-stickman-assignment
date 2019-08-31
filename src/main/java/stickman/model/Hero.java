package stickman.model;

public class Hero implements Entity {
    // Hero's attributes
    private String imagePath;
    private double xPos;
    private double yPos;
    private double height;
    private double width;
    private Layer layer;

    // Hero's methods
    public String getImagePath() {
        return this.imagePath;
    }

    public double getXPos() {
        return this.xPos;
    }

    public double getYPos() {
        return this.yPos;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public Layer getLayer() {
        return this.layer;
    }
}