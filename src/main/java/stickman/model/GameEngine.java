package stickman.model;

public interface GameEngine {
    /**
     * Used to get the current level managed by the game engine.
     * 
     * @return Level
     */
    Level getCurrentLevel();

    /**
     * Used to start a level.
     */
    void startLevel();

    /**
     * Used to call on the level to make the hero jump.
     * 
     * @return boolean
     */
    boolean jump();

    /**
     * Used to call on the level to make the hero move left.
     * 
     * @return boolean
     */
    boolean moveLeft();

    /**
     * Used to call on the level to make the hero move right.
     * 
     * @return boolean
     */
    boolean moveRight();

    /**
     * Used to call on the level to make the hero stop moving.
     * 
     * @return boolean
     */
    boolean stopMoving();

    /**
     * Used to make computations and changes each tick.
     */
    void tick();
}
