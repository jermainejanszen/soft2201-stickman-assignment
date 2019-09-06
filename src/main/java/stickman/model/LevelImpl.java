package stickman.model;

import java.util.List;

public class LevelImpl implements Level {
    // Level's attributes
    private List<Entity> entities;
    private double height;
    private double width;
    private double floorHeight;

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
    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).tickBehaviour();
        }
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

    // Level's constructor
    public LevelImpl(List<Entity> entities, double height, double width, double floorHeight) {
        this.entities = entities;
        this.height = height;
        this.width = width;
        this.floorHeight = floorHeight;
    }
}