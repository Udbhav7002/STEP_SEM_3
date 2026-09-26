package week_7.encapsulation.assignment_problems;

public class Character {
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