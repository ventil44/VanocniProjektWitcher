package Game;

import Command.Command;
import Command.GoToLocationCommand;
import Command.ExitCommand;
import Command.StatusCommand;
import Command.HealCommand;
import Command.InventoryCommand;
import Items.Potion;
import Player.Player;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private boolean exit = false;
    private HashMap<String, Command> mapa = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private GameWorld gameWorld;
    private Player player;

    public Game(GameWorld gameWorld, Player player) {
        this.gameWorld = gameWorld;
        this.player = player;
        inicializace();
    }

    private void inicializace() {
        mapa.put("go", new GoToLocationCommand(gameWorld, scanner));
        mapa.put("exit", new ExitCommand(this));
        mapa.put("status", new StatusCommand(player));
        mapa.put("heal", new HealCommand(player, new Potion("Potion", 30)));
        mapa.put("inventory", new InventoryCommand(player));
    }

    /**
     * Starts the game and handles the movement, for now
     * NOTE: this is where the main code is gonna be
     */
    public void run() {
        System.out.println("Game started.");
        System.out.println(gameWorld.getCurrentLocation().getDescription());

        while (!exit) {

            System.out.print("> ");
            String input = scanner.nextLine();

            Command command = mapa.get(input);

            if (command == null) {
                System.out.println("Unknown command.");
                continue;
            }

            String result = command.execute();
            if (result != null && !result.isBlank()) {
                System.out.println(result);
            }
        }
    }
    public void stop() {
        exit = true;
    }
}



