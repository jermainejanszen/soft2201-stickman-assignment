package stickman.model;

import java.util.Random;

public class PurpleSlime extends Slime implements SlimeStrategy {

    /**
     * Used to construct a purple slime.
     * 
     * @param size   The size of the slime.
     * @param startX The starting x position of the slime.
     * @param level  The level that the slime is in.
     */
    public PurpleSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimePa.png");
    }

    @Override
    public void think(Level level) {
        /* Every 2 seconds randomly chooses a direction to travel */
        if (level.getTickCounter() % 120 == 0) {
            Random rand = new Random();
            if (rand.nextInt(2) == 0) {
                this.moveLeft();
            } else {
                this.moveRight();
            }
        }
    }

}