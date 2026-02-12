package Command;

import Game.Game;

/**
 * Command for exiting the game
 * @author Denis Vesely
 */
public class ExitCommand implements Command {

    private final Game game;

    public ExitCommand(Game game) {
        this.game = game;
    }

    /**
     * Exits the game
     * @return a bye message
     */
    @Override
    public String execute() {
        game.stop();
        return "Bye";
    }
}
