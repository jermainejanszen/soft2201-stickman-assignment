package stickman.model;

import java.util.List;

public class LevelImpl implements Level {
    // Level's attributes
    private List<Entity> entities;
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
    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).tickBehaviour();

            // Animate hero sprite
            if (entities.get(i) instanceof Hero) {
                Entity hero = entities.get(i);

                // Not moving
                if (hero.getXVelocity() == 0) {
                    String currentImage = hero.getImagePath();
                    if (currentImage.charAt(3) == 's') {
                        if (currentImage.charAt(8) - '0' < 4) {
                            int nextImage = Math.floorDiv(this.tickCounter, 31) + 1;
                            hero.setImagePath(String.format("ch_stand%d.png", nextImage));
                        } else {
                            int nextImage = Math.floorDiv(this.tickCounter, 31) + 4;
                            hero.setImagePath(String.format("ch_stand%d.png", nextImage));
                        }
                    } else {
                        if (currentImage.charAt(7) - '0' < 5) {
                            int nextImage = Math.floorDiv(this.tickCounter, 31) + 1;
                            hero.setImagePath(String.format("ch_stand%d.png", nextImage));
                        } else {
                            int nextImage = Math.floorDiv(this.tickCounter, 31) + 4;
                            hero.setImagePath(String.format("ch_stand%d.png", nextImage));
                        }
                    }
                }

                // Moving right
                if (hero.getXVelocity() > 0) {
                    int nextImage = Math.floorDiv(this.tickCounter, 23) + 1;
                    hero.setImagePath(String.format("ch_walk%d.png", nextImage));
                }

                // Moving left
                if (hero.getXVelocity() < 0) {
                    int nextImage = Math.floorDiv(this.tickCounter, 23) + 5;
                    hero.setImagePath(String.format("ch_walk%d.png", nextImage));
                }
            }
        }
        this.tickCounter = (this.tickCounter + 1) % 90;
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
        this.tickCounter = 0;
    }
}