package stickman.model;

import java.util.Random;

public class BlueSlime extends Slime implements SlimeStrategy {

    public BlueSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeBa.png");
    }

    @Override
    public void think(Level level) {
        // Randomly changes direction
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