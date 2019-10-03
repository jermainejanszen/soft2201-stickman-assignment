package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class YellowSlime extends Slime implements SlimeStrategy {

    public YellowSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeYa.png");
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}