package pl.sdk.gui;


public class Creature {

    private final int maxHp;
    private final Integer attack;
    private final String name;
    private int currentHp;
    private final int moveRange;

    public Creature(int aMaxHp, Integer aAttack, String aName, int aMoveRange) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        name = aName;
        moveRange = aMoveRange;
    }

    public void attack(Creature aDefender) {
        aDefender.currentHp = aDefender.currentHp - attack;
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
}
