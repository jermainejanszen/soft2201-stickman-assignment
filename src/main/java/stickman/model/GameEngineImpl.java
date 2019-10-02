package stickman.model;

public class GameEngineImpl implements GameEngine {
    // Game engine's attributes
    private Level level;
    private String currentLevelPath;

    // Game Engine's methods
    public Level getCurrentLevel() {
        return this.level;
    }

    public void startLevel() {
        return;
    }

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
        // Reset the level if the hero runs out of lives
        for (Entity entity : this.level.getEntities()) {
            if (entity instanceof Hero) {
                if (((Hero) entity).lives == 0) {
                    this.level = LevelFactory.levelMake(currentLevelPath);
                }
            }
        }

        this.level.tick();
    }

    /**
     * Used to construct a Game Engine object to begin the game. Also creates level
     * with a hero and two clouds.
     * 
     * @param jsonPath String to a JSON config file.
     */
    public GameEngineImpl(String jsonPath) {
        this.currentLevelPath = jsonPath;
        this.level = LevelFactory.levelMake(jsonPath);

    }
}