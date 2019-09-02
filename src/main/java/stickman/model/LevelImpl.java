package stickman.model;

import java.util.List;

public class LevelImpl implements Level {
    // Level's attributes
    private List<Entity> entities;
    private double height;
    private double width;
    private double floorHeight;

    // Level's methods
    public List<Entity> getEntities() {
        return this.entities;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public void tick() {
        return;
    }

    public double getFloorHeight() {
        return this.floorHeight;
    }

    public double getHeroX() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).getXPos();
            }
        }
        return -1;
    }

    public boolean jump() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).jump();
            }
        }
        return false;
    }

    public boolean moveLeft() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).moveLeft();
            }
        }
        return false;
    }

    public boolean moveRight() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).moveRight();
            }
        }
        return false;
    }

    public boolean stopMoving() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof Hero) {
                return entities.get(i).stopMoving();
            }
        }
        return false;
    }

}