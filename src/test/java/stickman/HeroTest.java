package stickman;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import stickman.model.*;
import stickman.Paths;

public class HeroTest {

    @Test
    public void doesNotSpawnBelowFloorHeight() {
        GameEngine model = new GameEngineImpl(Paths.LevelsPath + "levelBlank.json");
        List<Entity> entities = model.getCurrentLevel().getEntities();

        for (Entity entity : entities) {
            if (entity instanceof Hero) {
                assertTrue(entity.getYPos() - entity.getHeight() < model.getCurrentLevel().getFloorHeight());
                break;
            }
        }
    }

    @Test
    public void canMove() {
        GameEngine model = new GameEngineImpl(Paths.LevelsPath + "level1.json");
        List<Entity> entities = model.getCurrentLevel().getEntities();

        for (Entity entity : entities) {
            if (entity instanceof Hero) {

                double startingXVelocity = entity.getXVelocity();
                double startingYVelocity = entity.getYVelocity();

                entity.moveLeft();
                assertTrue(startingXVelocity > entity.getXVelocity());

                entity.moveRight();
                assertTrue(startingXVelocity == entity.getXVelocity());

                entity.moveRight();
                assertTrue(startingXVelocity < entity.getXVelocity());

                entity.jump();
                assertTrue(startingYVelocity > entity.getYVelocity());

                entity.stopMoving();
                assertTrue(startingXVelocity == entity.getXVelocity());

                break;
            }
        }
    }

    @Test
    public void checkHeroCanLoseLives() {
        GameEngine model = new GameEngineImpl(Paths.LevelsPath + "levelBlank.json");
        Level level = model.getCurrentLevel();
        List<Entity> entities = level.getEntities();

        for (Entity entity : entities) {
            if (entity instanceof Hero) {
                Hero hero = (Hero) entity;
                int startingLives = hero.getLives();
                assertEquals(startingLives, hero.getLives());
                level.addEntity(new RedSlime("small", hero.getXPos(), level));
                level.tick();
                assertEquals((startingLives - 1), hero.getLives());
                break;
            }
        }
    }
}