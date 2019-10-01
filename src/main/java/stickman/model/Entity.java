package stickman.model;

public interface Entity extends Gravity {
    /**
     * Used to get the image path of an entity.
     * 
     * @return String
     */
    String getImagePath();

    /**
     * Used to set the image path of an entity.
     * 
     * @param imagePath The string representation of the path to the image
     */
    void setImagePath(String imagePath);

    /**
     * Used to get the current X position of an entity.
     * 
     * @return double
     */
    double getXPos();

    /**
     * Used to get the current Y position of an entity.
     * 
     * @return double
     */
    double getYPos();

    /**
     * Used to get the current X velocity of an entity.
     * 
     * @return double
     */
    double getXVelocity();

    /**
     * Used to get the current Y velocity of an entity.
     * 
     * @return double
     */
    double getYVelocity();

    /**
     * Used to get the height of an entity.
     * 
     * @return double
     */
    double getHeight();

    /**
     * Used to get the width of an entity.
     * 
     * @return double
     */
    double getWidth();

    /**
     * Used to get the layer that an entity is on.
     * 
     * @return Entity.Layer
     */
    Layer getLayer();

    /**
     * Used to make an entity jump.
     * 
     * @return boolean
     */
    boolean jump();

    /**
     * Used to make an entity move right.
     * 
     * @return boolean
     */
    boolean moveRight();

    /**
     * Used to make an entity move left.
     * 
     * @return boolean
     */
    boolean moveLeft();

    /**
     * Used to make an entity stop moving.
     * 
     * @return boolean
     */
    boolean stopMoving();

    /**
     * Used to copmute any changes an entity undergoes each tick.
     * 
     * @return boolean
     */
    void tickBehaviour(int tick);

    enum Layer {
        BACKGROUND, FOREGROUND, EFFECT
    }
}
