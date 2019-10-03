package stickman.model;

import stickman.model.LevelImpl.collisionType;

public class GreenSlime extends Slime implements SlimeStrategy {

    public GreenSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeGa.png");
    }

    @Override
    public void think(collisionType collision, Level level) {
        // TODO Auto-generated method stub

    }

}