package stickman.model;

import java.util.Random;

public class PurpleSlime extends Slime implements SlimeStrategy {

    public PurpleSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimePa.png");
    }

    @Override
    public void think(Level level) {
        // Every 2 seconds randomly chooses a direction to travel
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