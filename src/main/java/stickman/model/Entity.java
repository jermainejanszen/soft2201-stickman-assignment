package stickman.model;

public interface Entity extends Gravity {
    String getImagePath();

    void setImagePath(String imagePath);

    double getXPos();

    double getYPos();

    double getXVelocity();

    double getYVelocity();

    double getHeight();

    double getWidth();

    Layer getLayer();

    boolean jump();

    boolean moveRight();

    boolean moveLeft();

    boolean stopMoving();

    void tickBehaviour();

    enum Layer {
        BACKGROUND, FOREGROUND, EFFECT
    }
}
