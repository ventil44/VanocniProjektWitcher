package Game;

import Command.Command;
import Command.GoToLocationCommand;
import Command.ExitCommand;


import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private boolean exit = false;
    private HashMap<String, Command> mapa = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private GameWorld gameWorld;

    public Game(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        inicializace();
    }

    private void inicializace() {
        mapa.put("go", new GoToLocationCommand(gameWorld, scanner));
        mapa.put("exit", new ExitCommand());
    }

    public void run() {
        System.out.println("Game started.");
        System.out.println(gameWorld.getCurrentLocation().getDescription());

            System.out.print("> ");
            String input = scanner.nextLine();

            Command command = mapa.get(input);

            if (command != null) {
                command.execute();
            } else {
                System.out.println("Unknown command.");
            }

    }

    public void stop() {
        exit = true;
    }
}



