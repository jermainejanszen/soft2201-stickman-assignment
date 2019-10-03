package stickman.model;

public interface SlimeStrategy {
    /**
     * Used to compute the behaviour of a slime.
     * 
     * @param level The level that the slime is in.
     */
    public void think(Level level);
}