package pl.sdk.gui;


public class Creature {

    private final int maxHp;
    private final Integer attack;
    private final Integer armor;
    private final String name;
    private int currentHp;
    private final int moveRange;

    public Creature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange) {
        maxHp = aMaxHp;
        attack = aAttack;
        armor = aArmor;
        currentHp = maxHp;
        name = aName;
        moveRange = aMoveRange;
    }

    public void attack(Creature aDefender) {
        int damageToDeal = attack - aDefender.armor;
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        aDefender.currentHp = aDefender.currentHp - damageToDeal;
    }

    int getMoveRange() {
        return moveRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(System.lineSeparator());
        sb.append(currentHp);
        sb.append("/");
        sb.append(maxHp);
        return sb.toString();
    }

    int getCurrentHp() {
        return currentHp;
    }
}
