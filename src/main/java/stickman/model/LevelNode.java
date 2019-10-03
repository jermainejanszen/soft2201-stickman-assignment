package stickman.model;

/**
 * Used as a return object for the LevelFactory.
 */
public class LevelNode {
    public Level level;
    public String nextLevelPath;

    /**
     * Used to create a new LevelNode.
     * 
     * @param level         The new level.
     * @param nextLevelPath File path to the next level as a String.
     */
    public LevelNode(Level level, String nextLevelPath) {
        this.level = level;
        this.nextLevelPath = nextLevelPath;
    }
}