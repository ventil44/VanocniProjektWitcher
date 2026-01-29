package Command;

import Game.Game;

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
