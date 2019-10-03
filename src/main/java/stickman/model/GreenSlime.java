package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class GreenSlime extends Slime implements SlimeStrategy {

    public GreenSlime(String colour, String size, double startX, Level level) {
        super(colour, size, startX, level);
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}