package Command;

/**
 * Command that displays all commands that the user can use
 * @author Denis Vesely
 */
public class HelpCommand implements Command {
    /**
     * Executes help command
     * @return a lit of all available commands
     */
    @Override
    public String execute() {
        return "attack - attack enemies.\n exit - exits game. \n go - move from your location. \n help - helps. \n inventory - shows inventory. \n quest - starts quest. \n status - shows Hp. \n take - takes item. \n talk - talks to npc";
    }
}
