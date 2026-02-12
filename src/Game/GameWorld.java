package Game;

import Characters.Enemy;
import Items.Weapon;
import Locations.Location;
import Dialogs.Dialog;


import java.util.ArrayList;


public class GameWorld {

    private ArrayList<Location> locations;
    private ArrayList<Weapon> weapons;
    private ArrayList<Enemy> enemies;
    private ArrayList<Dialog> dialogs;
    private Location currentLocation;


    public GameWorld(GameData data, String startLocationId) {
        this.locations = data.locations;
        this.weapons = data.weapons;
        this.enemies = data.enemies;
        this.dialogs = data.dialogs;
        this.currentLocation = findLocation(startLocationId);

    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }


    /**
     * Finds a specific location by its identifier.
     * @param id the identifier of the location to be found
     * @return the matching location
     */
    public Location findLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id)){
                return l;
            }
        }
        throw new IllegalArgumentException("Location not found: " + id);
    }

    public Weapon findWeapon(String id) {
        for (Weapon w : weapons) {
            if (w.getId().equals(id)) {
                return w;
            }
        }
        throw new IllegalArgumentException("Weapon not found: " + id);
    }

    public Enemy findEnemy(String enemyId) {
        for (Enemy e : enemies) {
            if (e.getId().equals(enemyId)) return e;
        }
        return null;

    }

    private boolean talkedToJezibaba = false;

    public boolean hasTalkedToJezibaba() {
        return talkedToJezibaba;
    }

    public void setTalkedToJezibaba(boolean v) {
        talkedToJezibaba = v;
    }

    public ArrayList<Dialog> getDialogs() {
        return dialogs;
    }


}


