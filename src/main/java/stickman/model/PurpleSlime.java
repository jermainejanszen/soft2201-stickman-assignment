package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class PurpleSlime extends Slime implements SlimeStrategy {

    public PurpleSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimePa.png");
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}