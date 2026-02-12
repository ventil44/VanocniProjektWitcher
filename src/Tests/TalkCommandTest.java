package Tests;

import Command.TalkCommand;
import Dialogs.Dialog;
import Game.GameData;
import Game.GameWorld;
import Locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TalkCommandTest {

    Location location;
    TalkCommand command;
    FakeWorld fakeWorld;

    /**
     * Tests the AttackCommand
     * @author Denis Vesely
     */
    private static class FakeWorld extends GameWorld {

        private static final HashMap<String, Location> map = new HashMap<>();
        private final ArrayList<Dialog> dialogs = new ArrayList<>();

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

        @Override
        public ArrayList<Dialog> getDialogs() {
            return dialogs;
        }
    }

    @BeforeEach
    void setUp() {
        location = new Location("a", "Start", "Start location", new ArrayList<>());

        FakeWorld.add(location);

        GameData data = new GameData();
        fakeWorld = new FakeWorld(data, "a");
        fakeWorld.setCurrentLocation(location);

        Scanner scanner = new Scanner("");
        command = new TalkCommand(fakeWorld, scanner);
    }

    @Test
    void execute() {
        String result = command.execute();
        assertEquals("Není tu nikdo, s kým by se dalo mluvit.", result);
    }
}
