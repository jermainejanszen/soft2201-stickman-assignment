package stickman.model;

public class RedSlime extends Slime implements SlimeStrategy {

    public RedSlime(String size, double startX, Level level) {
        super(size, startX, level);
        this.setImagePath("slimeRa.png");
    }

    @Override
    public void think(Level level) {
        // Stands still

    }

}