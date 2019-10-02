package stickman.model;

public class GameEngineImpl implements GameEngine {
    // Game engine's attributes
    private Level level;
    private String currentLevelPath;
    private String nextLevelPath;

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
                if (((Hero) entity).getLives() == 0) {
                    this.level = LevelFactory.levelMake(currentLevelPath).level;
                }
            } else if (entity instanceof FinishLine) {
                if (((FinishLine) entity).isLevelComplete()) {
                    LevelNode nextLevel = LevelFactory.levelMake(nextLevelPath);
                    this.level = nextLevel.level;
                    this.currentLevelPath = nextLevelPath;
                    this.nextLevelPath = nextLevel.nextLevelPath;
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
        LevelNode currentLevel = LevelFactory.levelMake(jsonPath);
        this.level = currentLevel.level;
        this.nextLevelPath = currentLevel.nextLevelPath;

    }
}