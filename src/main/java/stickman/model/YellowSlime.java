package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class YellowSlime extends Slime implements SlimeStrategy {

    public YellowSlime(String colour, String size, double startX, Level level) {
        super(colour, size, startX, level);
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}