package Command;

import Player.Player;
import Items.Item;

import java.util.ArrayList;

public class GoForwardCommand implements Command {

    private Player player;
    private ArrayList<Item> items;

        @Override
        public String execute() {
            ArrayList<Item> items = player.getInventory();

            if (items.isEmpty()) {
                return "Inventory is empty.";
            }

            String result = "Inventory:\n";

            for (int i = 0; i < items.size(); i++) {
                result += (i + 1) + " - " + items.get(i).getName() + "\n";
            }

            return result.trim();
        }

}
