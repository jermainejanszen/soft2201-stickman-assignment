package stickman.model;

public class YellowSlime extends Slime implements SlimeStrategy {

    /**
     * Used to construct a yellow slime.
     * 
     * @param size   The size of the slime.
     * @param startX The starting x position of the slime.
     * @param level  The level that the slime is in.
     */
    public YellowSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeYa.png");
    }

    @Override
    public void think(Level level) {
        /* Always tries to go towards Hero's xPos */
        for (Entity entity : level.getEntities()) {
            if (entity instanceof Hero) {
                if (this.getXPos() < entity.getXPos()) {
                    this.moveRight();
                } else {
                    this.moveLeft();
                }
            }
        }
    }

}