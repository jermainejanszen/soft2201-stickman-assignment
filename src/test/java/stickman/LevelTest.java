package stickman;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import stickman.model.*;
import stickman.Paths;

public class LevelTest {

    @Test
    public void nothingBelowFloorHeight() {
        GameEngine model = new GameEngineImpl(Paths.LevelsPath + "level1.json");
        List<Entity> entities = model.getCurrentLevel().getEntities();

        for (Entity entity : entities) {
            assertFalse((entity.getYPos() + entity.getHeight()) > model.getCurrentLevel().getFloorHeight());
        }
    }

    @Test
    public void canAddEntitiesToLevel() {
        GameEngine model = new GameEngineImpl(Paths.LevelsPath + "level1.json");
        Level level = model.getCurrentLevel();
        List<Entity> entities = level.getEntities();

        PurpleSlime entityToAdd = new PurpleSlime("small", 300.0, level);
        level.addEntity(entityToAdd);

        assertTrue(entities.contains(entityToAdd));
    }

    @Test
    public void canDetectCollisions() {
        GameEngine model = new GameEngineImpl(Paths.LevelsPath + "levelBlank.json");
        LevelImpl level = (LevelImpl) model.getCurrentLevel();

        Hero hero = null;

        for (Entity entity : level.getEntities()) {
            if (entity instanceof Hero) {
                hero = (Hero) entity;
            }
        }

        Platform platform = new Platform(hero.getXPos(), hero.getYPos(), hero.getWidth(), level);

        LevelImpl.collisionType collision = level.checkCollision(hero, platform);
        assertNotSame(LevelImpl.collisionType.NONE, collision);
    }

}