package pl.sdk.gui;


import pl.sdk.gui.gui.GuiTileIf;

public class Creature implements GuiTileIf {

    private final int maxHp;
    private final Integer attack;
    private final Integer armor;
    private final String name;
    private int currentHp;
    private int amount;
    private final int moveRange;
    private boolean counterAttack;
    private CalculateStrategy damageCalculator;

    Creature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount) {
        this(aMaxHp, aAttack, aArmor, aName, aMoveRange, aAmount, new DefaultCalculateStrategy());
    }

    Creature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount, CalculateStrategy aDamageCalculator) {
        maxHp = aMaxHp;
        attack = aAttack;
        armor = aArmor;
        currentHp = maxHp;
        name = aName;
        moveRange = aMoveRange;
        amount = aAmount;
        damageCalculator = aDamageCalculator;
    }

    public String getName() {
        return name;
    }

    public void attack(Creature aDefender) {
        if (isAlive()) {
            int damageToDeal = damageCalculator.calculateDamageToDeal(aDefender, this);
            applyDamage(aDefender, damageToDeal);

            ca(aDefender);
        }
    }

    protected void ca(Creature aDefender) {
        if (canCounterAttack(aDefender)) {
            int damageToDealInCounterAttack = aDefender.damageCalculator.calculateDamageToDeal(this, aDefender);
            applyDamage(this, damageToDealInCounterAttack);
            aDefender.counterAttack = true;
        }
    }

    private boolean canCounterAttack(Creature aDefender) {
        return !aDefender.counterAttack && aDefender.isAlive();
    }

    private void applyDamage(Creature aDefender, int damageToDeal) {
        int killedUnits = damageToDeal / aDefender.maxHp;
        int lostHp = damageToDeal % aDefender.maxHp;
        aDefender.amount = aDefender.amount - killedUnits;
        aDefender.currentHp = aDefender.currentHp - lostHp;
    }

    private boolean isAlive() {
        return currentHp > 0 && amount > 0;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getArmor() {
        return armor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String[] splitName = name.split(" ");
        for (int i = 0; i < splitName.length; i++) {
            sb.append(splitName[i]);
            if (i != splitName.length - 1) {
                sb.append(System.lineSeparator());
            }
        }
        sb.append(System.lineSeparator());
        sb.append(amount);
        sb.append(System.lineSeparator());
        sb.append(currentHp);
        sb.append("/");
        sb.append(maxHp);
        return sb.toString();
    }

    int getCurrentHp() {
        return currentHp;
    }

    int getAmount() {
        return amount;
    }

    @Override
    public boolean isMovePossible() {
        return false;
    }

    @Override
    public boolean isAttackPossible() {
        return true;
    }
}
