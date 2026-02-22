package Game;

import Characters.Enemy;
import Command.Command;
import Command.GoToLocationCommand;
import Command.ExitCommand;
import Command.StatusCommand;
import Command.HealCommand;
import Command.InventoryCommand;
import Command.TakeCommand;
import Command.AttackCommand;
import Command.TalkCommand;
import Command.QuestCommand;
import Command.HelpCommand;
import Player.Player;



import java.util.HashMap;
import java.util.Scanner;

/**
 * Main game controller, initializing all commands and running the main loop of the game
 * The loop runs until exit is true
 * @author Denis Vesely
 */
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

    /**
     * Initializes all the commands into a map
     */
    private void inicializace() {
        mapa.put("go", new GoToLocationCommand(gameWorld, scanner));
        mapa.put("exit", new ExitCommand(this));
        mapa.put("status", new StatusCommand(player));
        mapa.put("heal", new HealCommand(player));
        mapa.put("inventory", new InventoryCommand(player));
        mapa.put("take", new TakeCommand(player, gameWorld, scanner));
        mapa.put("attack", new AttackCommand(player, gameWorld));
        mapa.put("talk", new TalkCommand(gameWorld, scanner));
        mapa.put("quest", new QuestCommand(gameWorld, scanner, player));
        mapa.put("help", new HelpCommand());
    }

    /**
     * Starts the game and handles the whole game
     * The method prints a start message and the description of the current location
     * It repeatedly reads the users inputs until exit is true
     * If the user inputs an unknown word, it informs the user
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

            Enemy lordStinu = gameWorld.findEnemy("lord_stinu");

            if (!lordStinu.isAlive()) {
                System.out.println("You killed the cause of bad, you freed the world, yippie yay, the game ends now ok");
                exit = true;
            }
        }
    }
    public void stop() {
        exit = true;
    }



}



