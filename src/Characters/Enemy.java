package Characters;

public class Enemy {

        private String name;
        private int health;
        private int damage;
        private String id;
        private String homeLocationId;

        public Enemy(String name, int health, int damage) {}

        public void takeDamage(int damage) {
                health -= damage;
                if (health < 0) health = 0;
        }
        public boolean isAlive() {
                return health > 0;
        }

        public String getName() {
                return name;
        }

        public int getHealth() {
                return health;
        }

        public int getDamage() {
                return damage;
        }

        public String getId() {
                return id;
        }

        public String getHomeLocationId() {
                return homeLocationId;
        }
}




