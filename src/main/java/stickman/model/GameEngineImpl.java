package stickman.model;

public class GameEngineImpl implements GameEngine {
    // Game engine's attributes
    private Level level;

    // Game Engine's methods
    public Level getCurrentLevel() {
        return this.level;
    }

    public void startLevel() {

    }

    // Hero inputs - boolean for success (possibly for sound feedback)
    public boolean jump() {
        return true;
    }

    public boolean moveLeft() {
        return true;
    }

    public boolean moveRight() {
        return true;
    }

    public boolean stopMoving() {
        return true;
    }

    public void tick() {

    }

    // Game engine's constructor
    public GameEngineImpl(Level inputLevel) {
        this.level = inputLevel;
    }
}