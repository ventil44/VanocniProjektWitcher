package Tests;

import Command.AttackCommand;
import Game.GameData;
import Game.GameWorld;
import Locations.Location;
import Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the AttackCommand
 * @author Denis Vesely
 */
class AttackCommandTest {

    Player player;
    Location location;
    AttackCommand command;
    FakeWorld fakeWorld;

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
        player = new Player("Zbienk", 100);

        location = new Location("a", "Start", "Start location", new ArrayList<>());

        FakeWorld.add(location);

        GameData data = new GameData();
        fakeWorld = new FakeWorld(data, "a");
        fakeWorld.setCurrentLocation(location);

        command = new AttackCommand(player, fakeWorld);
    }

    @Test
    void execute() {
        String result = command.execute();
        assertEquals("There is no enemy to attack here.", result);
    }
}
