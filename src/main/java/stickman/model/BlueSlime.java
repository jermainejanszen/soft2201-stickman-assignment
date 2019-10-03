package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class BlueSlime extends Slime implements SlimeStrategy {

    public BlueSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeBa.png");
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}