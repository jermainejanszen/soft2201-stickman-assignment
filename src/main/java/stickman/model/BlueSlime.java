package stickman.model;

import java.util.Random;

public class BlueSlime extends Slime implements SlimeStrategy {

    /**
     * Used to construct a blue slime.
     * 
     * @param size   The size of the slime.
     * @param startX The starting x position of the slime.
     * @param level  The level that the slime is in.
     */
    public BlueSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeBa.png");
    }

    @Override
    public void think(Level level) {
        /* Randomly changes direction */
        Random rand = new Random();
        if (rand.nextInt(60) == 0) {
            if (this.getXVelocity() > 0) {
                this.moveLeft();
            } else {
                this.moveRight();
            }
        }
    }

}