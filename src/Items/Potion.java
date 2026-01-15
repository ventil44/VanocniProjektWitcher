package Items;

import Player.Player;

public class Potion extends Item {

    private int healAmount;

    public Potion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    @Override
    public void use(Player player) {}
}
