package stickman.model;

public class LevelNode {
    public Level level;
    public String nextLevelPath;

    public LevelNode(Level level, String nextLevelPath) {
        this.level = level;
        this.nextLevelPath = nextLevelPath;
    }
}