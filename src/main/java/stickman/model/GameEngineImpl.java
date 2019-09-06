package stickman.model;

import java.util.List;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GameEngineImpl implements GameEngine {
    // Game engine's attributes
    private Level level;

    // Game Engine's methods
    public Level getCurrentLevel() {
        return this.level;
    }

    public void startLevel() {
        return;
    }

    // Hero inputs - boolean for success (possibly for sound feedback)
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
        this.level.tick();
    }

    // Game engine's constructor
    public GameEngineImpl(String jsonPath) {
        String configFilePath = jsonPath;
        String stickmanSize = null;
        double stickmanXPos = -1.0;
        double cloudVelocity = 0.0;

        // Begin parsing JSON file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(configFilePath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            stickmanSize = (String) jsonObject.get("stickmanSize");
            stickmanXPos = (double) ((JSONObject) jsonObject.get("stickmanPos")).get("x");
            cloudVelocity = (double) jsonObject.get("cloudVelocity");

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
        level.addEntity(new Cloud(cloudVelocity, this.level));
        level.addEntity(new Cloud(cloudVelocity, this.level));
    }
}