package stickman.model;

public class GameEngineImpl implements GameEngine {
    // Game engine's attributes
    private Level level;

    // Game Engine's methods
    public Level getCurrentLevel() {
        return this.level;
    }

    public void startLevel() {
        Level newLevel = new LevelImpl();
        this.level = newLevel;
    }

    // Hero inputs - boolean for success (possibly for sound feedback)
    public boolean jump() {
        return this.level.jump();
    }

    public boolean moveLeft() {
        return this.level.moveLeft();
    }

    public boolean moveRight() {
        return this.level.moveRight();
    }

    public boolean stopMoving() {
        return this.level.stopMoving();
    }

    public void tick() {
        this.level.tick();
    }

    // Game engine's constructor
    public GameEngineImpl(Level inputLevel) {
        this.level = inputLevel;
    }
}