package Tests;

import Command.InventoryCommand;
import Items.Potion;
import Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the InventoryCommand
 * @author Denis Vesely
 */
class InventoryCommandTest {

    Player player;
    InventoryCommand command;

    @BeforeEach
    void setUp() {
        player = new Player("Zbinek", 100);
        command = new InventoryCommand(player);
    }

    @Test
    void execute() {

        Potion potion = new Potion("Potion", 30);
        player.getInventory().add(potion);

        String result = command.execute();

        assertEquals("Inventory:1 - Potion\n", result);
    }
}
