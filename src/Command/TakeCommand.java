package Command;

import Game.GameWorld;
import Items.Item;
import Items.Weapon;
import Player.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeCommand implements Command {

    private final Player player;
    private final GameWorld gameWorld;
    private final Scanner scanner;

    public TakeCommand(Player player, GameWorld gameWorld, Scanner scanner) {
        this.player = player;
        this.gameWorld = gameWorld;
        this.scanner = scanner;
    }

    @Override
    public String execute() {
        ArrayList<Item> items = gameWorld.getCurrentLocation().getItems();

        if (items.isEmpty()) {
            return "There is nothing to take here.";
        }

        System.out.println("What do you want to take?");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + " - " + items.get(i).getName());
        }
        System.out.print("> ");

        int choice;

        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return "Invalid input.";
        }

        if (choice < 1 || choice > items.size()) {
            return "This item does not exist.";
        }

        Item picked = items.remove(choice - 1);
        player.takeItem(picked);

        if (picked instanceof Weapon) {
            player.equipWeapon((Weapon) picked);
            return "You took and equipped: " + picked.getName();
        }

        return "You took: " + picked.getName();
    }
}
