package stickman.model;

import java.util.List;
import java.util.Random;

public class LevelImpl implements Level {
    private List<Entity> entities;
    private double cloudVelocity;
    private double height;
    private double width;
    private double floorHeight;
    private int tickCounter;

    /**
     * Used to construct a level with a given height, width, and floor height.
     * Entities are added to the given list of entities.
     * 
     * @param entities    List<Entity> that stores all the entities on a level.
     * @param height      Double of the height of the level.
     * @param width       Double of the width of the level.
     * @param floorHeight Double of the floor height of the level.
     */
    public LevelImpl(List<Entity> entities, double height, double width, double floorHeight) {
        this.entities = entities;
        this.height = height;
        this.width = width;
        this.floorHeight = floorHeight;
        this.tickCounter = 0;
    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public boolean addEntity(Entity entity) {
        return this.entities.add(entity);
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public int getTickCounter() {
        return this.tickCounter;
    }

    @Override
    public void setCloudVelocity(double cloudVelocity) {
        this.cloudVelocity = cloudVelocity;
    }

    @Override
    public void tick() {
        /* Randomly add clouds */
        Random rand = new Random();
        if (rand.nextInt(4000) == 0) {
            this.entities.add(new Cloud(this.cloudVelocity, this));
        }

        /* Check if any slimes were killed */
        for (int i = entities.size() - 1; i > -1; i--) {
            if (entities.get(i) instanceof Slime) {
                if (((Slime) entities.get(i)).die) {
                    entities.remove(entities.get(i));
                }
            }
        }

        /* Check and handle collisions */
        for (Entity entityA : entities) {
            entityA.tickBehaviour(tickCounter);
            if (entityA instanceof Slime) {
                ((Slime) entityA).think(this);
            }

            for (Entity entityB : entities) {
                collisionType collision = checkCollision(entityA, entityB);
                if (collision != collisionType.NONE) {
                    handleCollision(entityA, entityB, collision);
                }
            }
        }

        this.tickCounter = this.tickCounter + 1;
        return;
    }

    @Override
    public double getFloorHeight() {
        return this.floorHeight;
    }

    @Override
    public double getHeroX() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).getXPos();
            }
        }
        return -1;
    }

    @Override
    public boolean jump() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).jump();
            }
        }
        return false;
    }

    @Override
    public boolean moveLeft() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).moveLeft();
            }
        }
        return false;
    }

    @Override
    public boolean moveRight() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).moveRight();
            }
        }
        return false;
    }

    @Override
    public boolean stopMoving() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).stopMoving();
            }
        }
        return false;
    }

    public enum collisionType {
        TOP, BOTTOM, LEFT, RIGHT, NONE
    }

    public collisionType checkCollision(Entity entityA, Entity entityB) {
        if (entityA == entityB) {
            return collisionType.NONE;
        }

        if (entityA instanceof Cloud || entityB instanceof Cloud) {
            return collisionType.NONE;
        }

        boolean collision = false;

        if (entityA.getXPos() < (entityB.getXPos() + entityB.getWidth())
                && ((entityA.getXPos() + entityA.getWidth()) > entityB.getXPos())
                && (entityA.getYPos() < (entityB.getYPos() + entityB.getHeight()))
                && ((entityA.getYPos() + entityA.getHeight()) > entityB.getYPos())) {
            collision = true;
        }

        if (collision) {
            if (Math.abs(entityA.getYPos() + entityA.getHeight() - entityB.getYPos()) < entityB.getHeight() * 0.25) {
                return collisionType.TOP;
            } else if (Math.abs(entityB.getYPos() + entityB.getHeight() - entityA.getYPos()) < entityA.getHeight()
                    * 0.25) {
                return collisionType.BOTTOM;
            } else if (entityA.getXPos() < entityB.getXPos()) {
                return collisionType.LEFT;
            } else {
                return collisionType.RIGHT;
            }
        } else {
            return collisionType.NONE;
        }
    }

    private void handleCollision(Entity entityA, Entity entityB, collisionType collision) {
        entityA.collisionBehaviour(collision, entityB);
        return;
    }
}