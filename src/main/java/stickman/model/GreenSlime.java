package stickman.model;

public class GreenSlime extends Slime implements SlimeStrategy {

    private boolean hasJumped = false;

    public GreenSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeGa.png");
    }

    @Override
    public void think(Level level) {
        // Jumps once when the hero gets within 20px of it
        for (Entity entity : level.getEntities()) {
            if (entity instanceof Hero) {
                if (Math.abs(entity.getXPos() - this.getXPos()) < 21) {
                    if (!hasJumped) {
                        this.jump();
                        this.hasJumped = true;
                    }
                }
            }
        }
    }

}