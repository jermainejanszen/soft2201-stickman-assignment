package stickman.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GameEngineImpl implements GameEngine {
    // Game engine's attributes
    private Level level;
    private double cloudVelocity;

    // Game Engine's methods
    public Level getCurrentLevel() {
        return this.level;
    }

    public void startLevel() {
        return;
    }

    public boolean jump() {
        return this.level.jump();
    }

    public boolean moveLeft() {
        return this.level.moveLeft();
    }

    public boolean moveRight() {
        return this.level.moveRight();
    }

    public boolean stopMoving() {
        return this.level.stopMoving();
    }

    public void tick() {
        // Randomly add clouds
        Random rand = new Random();
        if (rand.nextInt(900) == 0) {
            this.level.getEntities().add(new Cloud(this.cloudVelocity, this.level));
        }

        this.level.tick();
    }

    /**
     * Used to construct a Game Engine object to begin the game. Also creates level
     * with a hero and two clouds.
     * 
     * @param jsonPath String to a JSON config file.
     */
    public GameEngineImpl(String jsonPath) {
        String configFilePath = jsonPath;
        String stickmanSize = null;
        double stickmanXPos = -1.0;
        this.cloudVelocity = 0.0;

        // Begin parsing JSON file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(configFilePath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            stickmanSize = (String) jsonObject.get("stickmanSize");
            stickmanXPos = (double) ((JSONObject) jsonObject.get("stickmanPos")).get("x");
            this.cloudVelocity = (double) jsonObject.get("cloudVelocity");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("IO exception thrown.");
        } catch (ParseException e) {
            System.out.println("Parse exception thrown.");
        }

        List<Entity> entities = new ArrayList<Entity>();

        this.level = new LevelImpl(entities, 400, 640, 300);

        level.addEntity(new Hero(stickmanXPos, stickmanSize, this.level));
        level.addEntity(new Cloud(this.cloudVelocity, this.level));
        level.addEntity(new Cloud(this.cloudVelocity, this.level));
    }
}