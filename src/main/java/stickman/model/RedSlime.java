package stickman.model;

public class RedSlime extends Slime implements SlimeStrategy {

    /**
     * Used to construct a red slime.
     * 
     * @param size   The size of the slime.
     * @param startX The starting x position of the slime.
     * @param level  The level that the slime is in.
     */
    public RedSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeRa.png");
    }

    @Override
    public void think(Level level) {
        /* Stands still */

    }

}