package stickman.model;

public interface Entity {
    String getImagePath();

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
