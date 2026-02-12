package Tests;

import Command.StatusCommand;
import Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the StatusCommand
 * @author Denis Vesely
 */
class StatusCommandTest {

    Player player;
    StatusCommand command;

    @BeforeEach
    void setUp() {
        player = new Player("Zbinek", 500);
        player.setHealth(80);
        command = new StatusCommand(player);
    }

    @Test
    void execute() {
        String result = command.execute();
        assertEquals("HP: 80", result);
    }
}
