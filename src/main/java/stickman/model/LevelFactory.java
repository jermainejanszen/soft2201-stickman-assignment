package stickman.model;

import java.util.List;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LevelFactory {

    public static LevelNode levelMake(String jsonPath) {
        List<Entity> entities = new ArrayList<Entity>();
        Level newLevel = new LevelImpl(entities, 400, 640, 300);

        String configFilePath = jsonPath;
        String nextLevelFilePath = null;
        String stickmanSize = null;
        double stickmanXPos = -1.0;
        double cloudVelocity = 0.0;
        newLevel.setCloudVelocity(cloudVelocity);
        ArrayList<Slime> slimes = new ArrayList<Slime>();
        ArrayList<Platform> platforms = new ArrayList<Platform>();
        double finishLineXPos = -1.0;

        // Begin parsing JSON file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(configFilePath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            nextLevelFilePath = (String) jsonObject.get("nextLevel");
            finishLineXPos = (double) ((JSONObject) jsonObject.get("finishLinePos")).get("x");
            stickmanSize = (String) jsonObject.get("stickmanSize");
            stickmanXPos = (double) ((JSONObject) jsonObject.get("stickmanPos")).get("x");
            cloudVelocity = (double) jsonObject.get("cloudVelocity");
            newLevel.setCloudVelocity(cloudVelocity);
            JSONArray jsonSlimes = (JSONArray) jsonObject.get("slimes");
            JSONArray jsonPlatforms = (JSONArray) jsonObject.get("platforms");

            // Adding the slimes to the level
            for (int i = 0; i < jsonSlimes.size(); i++) {
                String slimeColour = (String) ((JSONObject) jsonSlimes.get(i)).get("colour");
                String slimeSize = (String) ((JSONObject) jsonSlimes.get(i)).get("size");
                double slimeX = (double) ((JSONObject) jsonSlimes.get(i)).get("x");
                switch (slimeColour) {
                case "r":
                    slimes.add(new RedSlime(slimeColour, slimeSize, slimeX, newLevel));
                    break;
                case "g":
                    slimes.add(new GreenSlime(slimeColour, slimeSize, slimeX, newLevel));
                    break;
                case "b":
                    slimes.add(new BlueSlime(slimeColour, slimeSize, slimeX, newLevel));
                    break;
                case "y":
                    slimes.add(new YellowSlime(slimeColour, slimeSize, slimeX, newLevel));
                    break;
                case "p":
                    slimes.add(new PurpleSlime(slimeColour, slimeSize, slimeX, newLevel));
                    break;
                default:
                    System.out.println("'" + slimeColour + "' is an invalid slime colour.");
                }
            }

            // Adding the platforms to the level
            for (int i = 0; i < jsonPlatforms.size(); i++) {
                double platformX = (double) ((JSONObject) jsonPlatforms.get(i)).get("x");
                double platformY = (double) ((JSONObject) jsonPlatforms.get(i)).get("y");
                double platformWidth = (double) ((JSONObject) jsonPlatforms.get(i)).get("width");
                platforms.add(new Platform(platformX, platformY, platformWidth, newLevel));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("IO exception thrown.");
        } catch (ParseException e) {
            System.out.println("Parse exception thrown.");
        }

        for (int i = 0; i < slimes.size(); i++) {
            newLevel.addEntity(slimes.get(i));
        }
        for (int i = 0; i < platforms.size(); i++) {
            newLevel.addEntity(platforms.get(i));
        }
        newLevel.addEntity(new Hero(stickmanXPos, stickmanSize, newLevel));
        newLevel.addEntity(new Cloud(cloudVelocity, newLevel));
        newLevel.addEntity(new Cloud(cloudVelocity, newLevel));
        newLevel.addEntity(new FinishLine(finishLineXPos, newLevel));

        return new LevelNode(newLevel, nextLevelFilePath);
    }

}