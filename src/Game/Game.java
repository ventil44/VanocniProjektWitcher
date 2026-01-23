package Game;

import Command.Command;
import Command.GoToLocationCommand;
import Command.ExitCommand;
import Command.StatusCommand;
import Command.HealCommand;
import Player.Player;
import Player.Inventory;
import Items.Potion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private boolean exit = false;
    private HashMap<String, Command> mapa = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private GameWorld gameWorld;
    private Player p;
    private Inventory inv;
    private Potion potion;

    public Game(GameWorld gameWorld, Player p) {
        this.p = p;
        this.gameWorld = gameWorld;
        //this.inv = inv;
        //this.potion = potion;
        inicializace();
    }

    private void inicializace() {
        mapa.put("go", new GoToLocationCommand(gameWorld, scanner));
        mapa.put("exit", new ExitCommand());
        mapa.put("status", new StatusCommand(p));
        mapa.put("heal", new HealCommand(p, inv, potion));
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
            } else {
                command.execute();
            }
            }
        }

        public void stop () {
            exit = true;
        }


    }



