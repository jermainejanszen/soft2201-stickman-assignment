package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class PurpleSlime extends Slime implements SlimeStrategy {

    public PurpleSlime(String colour, String size, double startX, Level level) {
        super(colour, size, startX, level);
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}