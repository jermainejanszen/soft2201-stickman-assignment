package stickman;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import stickman.model.*;
import stickman.Paths;

public class CloudTest {

    @Test
    public void checkCloudsGenerated() {
        GameEngine model = new GameEngineImpl(Paths.LevelsPath + "levelBlank.json");
        List<Entity> entities = model.getCurrentLevel().getEntities();

        boolean cloudExists = false;

        for (Entity entity : entities) {
            if (entity instanceof Cloud) {
                cloudExists = true;
            }
        }

        assertTrue(cloudExists);
    }
}