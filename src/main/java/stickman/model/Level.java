package stickman.model;

import java.util.List;

public interface Level {
    /**
     * Used to get the list of entities that currently exist on the level.
     * 
     * @return List<Entity>
     */
    List<Entity> getEntities();

    /**
     * Used to add an entity to the level.
     * 
     * @param entity
     * @return boolean
     */
    boolean addEntity(Entity entity);

    /**
     * Used to get the height of the level.
     * 
     * @return double
     */
    double getHeight();

    /**
     * Used to get the width of the level.
     * 
     * @return double
     */
    double getWidth();

    /**
     * Used to get the current tick.
     * 
     * @return int
     */
    int getTickCounter();

    /**
     * Used to get the seconds elapsed in the level.
     * 
     * @return int
     */
    int getSecondsElapsed();

    /**
     * Used to set the cloud velocity of a level.
     * 
     * @param CloudVelocity
     */
    void setCloudVelocity(double CloudVelocity);

    /**
     * Used to make computations and changes each tick.
     */
    void tick();

    /**
     * Used to get the floor height of a level.
     * 
     * @return double
     */
    double getFloorHeight();

    /**
     * Used to get the X position of the hero of a level.
     * 
     * @return double
     */
    double getHeroX();

    /**
     * Used to make the hero in a level jump.
     * 
     * @return boolean
     */
    boolean jump();

    /**
     * Used to make the hero in a level move left.
     * 
     * @return boolean
     */
    boolean moveLeft();

    /**
     * Used to make the hero in a level move right.
     * 
     * @return boolean
     */
    boolean moveRight();

    /**
     * Used to make the hero in a level stop moving.
     * 
     * @return boolean
     */
    boolean stopMoving();
}
