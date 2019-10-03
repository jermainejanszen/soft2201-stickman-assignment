package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class RedSlime extends Slime implements SlimeStrategy {

    public RedSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeRa.png");
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}