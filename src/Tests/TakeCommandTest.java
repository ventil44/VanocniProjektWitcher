package Tests;

import Command.TakeCommand;
import Game.GameData;
import Game.GameWorld;
import Items.Weapon;
import Locations.Location;
import Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TakeCommandTest {

    Player player;
    Location location;
    Weapon sword;
    TakeCommand command;
    FakeWorld fakeWorld;

    /**
     * Tests the TakeCommand
     * @author Denis Vesely
     */
    private static class FakeWorld extends GameWorld {

        private static final HashMap<String, Location> map = new HashMap<>();

        public FakeWorld(GameData data, String startLocationId) {
            super(data, startLocationId);
        }

        static void add(Location loc) {
            map.put(loc.getId(), loc);
        }

        @Override
        public Location findLocation(String id) {
            return map.get(id);
        }
    }

    @BeforeEach
    void setUp() {

        player = new Player("pepa", 20);

        location = new Location("a", "Start", "Start location", new ArrayList<>());
        sword = new Weapon("Steel Sword", 15);
        location.getItems().add(sword);

        FakeWorld.add(location);

        GameData data = new GameData();
        fakeWorld = new FakeWorld(data, "a");

        fakeWorld.setCurrentLocation(location);

        Scanner scanner = new Scanner("1\n");
        command = new TakeCommand(player, fakeWorld, scanner);
    }

    @Test
    void execute() {
        String result = command.execute();
        assertEquals("You took and equipped: Steel Sword", result);
    }
}
