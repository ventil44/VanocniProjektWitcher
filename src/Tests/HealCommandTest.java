package Tests;

import Command.HealCommand;
import Player.Player;
import Items.Potion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the HealCommand
 * @author Denis Vesely
 */
class HealCommandTest {

    Player player;
    HealCommand command;

    @BeforeEach
    void setUp() {
        player = new Player("Zbinek", 100);
        player.setHealth(50);
        command = new HealCommand(player);
    }

    @Test
    void execute() {
        Potion potion = new Potion("p1", 30);
        player.getInventory().add(potion);

        String result = command.execute();

        assertEquals(80, player.getHealth());
        assertFalse(player.getInventory().contains(potion));
        assertEquals("Healed for 30 HP.\nCurrent HP: 80", result);
    }
}
