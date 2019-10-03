package stickman.model;

import stickman.model.LevelImpl.collisionType;

public interface SlimeStrategy {
    public void think(collisionType collision, Level level);
}