package stickman.model;

import java.util.List;
import java.util.Random;

public class LevelImpl implements Level {
    // Level's attributes
    private List<Entity> entities;
    private double cloudVelocity;
    private double height;
    private double width;
    private double floorHeight;
    private int tickCounter;

    // Level's methods
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
    public void setCloudVelocity(double cloudVelocity) {
        this.cloudVelocity = cloudVelocity;
    }

    @Override
    public void tick() {
        // Randomly add clouds
        Random rand = new Random();
        if (rand.nextInt(4000) == 0) {
            this.entities.add(new Cloud(this.cloudVelocity, this));
        }

        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).tickBehaviour(this.tickCounter);
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
}