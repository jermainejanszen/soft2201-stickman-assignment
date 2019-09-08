package stickman.model;

public interface Gravity {
    /**
     * Global acceleration due to gravity.
     */
    static final double acceleration = 0.2;

    /**
     * Used to apply the effects of gravity onto an entity.
     */
    void applyGravity();
}