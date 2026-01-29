package Game;

import Characters.Enemy;
import Characters.NPC;
import Items.Potion;
import Locations.Location;
import com.google.gson.Gson;
import com.sun.tools.javac.Main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content, such as items, characters, locations, and quests.
 *
 */
public class GameData {

    public ArrayList<Location> locations;
    public ArrayList<Enemy> enemies;
    public ArrayList<NPC> npcs;
    public ArrayList<Potion> potions;


    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a game.GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        //Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        //Načtení souboru gamedata.json, musí být ve složce res/resources, ta musí být označena jako resource složka projektu
        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {

            //Zde ověřujeme, zdali soubor existuje
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }

            //Přečte celý JSON a vytvoří instanci game.GameData, naplní vlastnosti podle názvů klíčů v JSONU, vrátí se hotová třída game.GameData
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }



    }






}

