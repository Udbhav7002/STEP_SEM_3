public class Problem1_Character {

    static class Character {
        private final int maxHealth;
        private int currentHealth;

        public Character(int maxHealth) {
            this.maxHealth = maxHealth;
            this.currentHealth = maxHealth;
        }

        public void takeDamage(int amount) {
            if (amount > 0) {
                currentHealth -= amount;
                if (currentHealth < 0) {
                    currentHealth = 0;
                }
            }
        }

        public void heal(int amount) {
            if (amount > 0) {
                currentHealth += amount;
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
        }

        public int getHealth() {
            return currentHealth;
        }

        public int getMaxHealth() {
            return maxHealth;
        }
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After damage 30: " + c.getHealth());
        c.heal(50);
        System.out.println("After heal 50: " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After damage 150: " + c.getHealth());
    }
}