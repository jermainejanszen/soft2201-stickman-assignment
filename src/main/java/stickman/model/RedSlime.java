package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class RedSlime extends Slime implements SlimeStrategy {

    public RedSlime(String colour, String size, double startX, Level level) {
        super(colour, size, startX, level);
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}