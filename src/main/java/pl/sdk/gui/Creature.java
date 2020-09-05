package pl.sdk.gui;


public class Creature {

    private final int maxHp;
    private final Integer attack;
    private final Integer armor;
    private final String name;
    private int currentHp;
    private int amount;
    private final int moveRange;
    private boolean counterAttack;
    private Geberish geberish;

    public Creature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount) {
        maxHp = aMaxHp;
        attack = aAttack;
        armor = aArmor;
        currentHp = maxHp;
        name = aName;
        moveRange = aMoveRange;
        amount = aAmount;
        geberish = new Geberish();
    }

    public String getName() {
        return name;
    }

    public void attack(Creature aDefender) {
        if (isAlive()) {
            int damageToDeal = countDamageToDeal(aDefender, this);
            damageToDeal = geberish.considerSpecialMechanic(this, aDefender, damageToDeal);
            applyDamage(aDefender, damageToDeal);

            ca(aDefender);
        }
    }

    protected void ca(Creature aDefender) {
        if (canCounterAttack(aDefender)) {
            int damageToDealInCounterAttack = countDamageToDeal(this, aDefender);
            damageToDealInCounterAttack = geberish.considerSpecialMechanic(aDefender, this, damageToDealInCounterAttack);
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

    private int countDamageToDeal(Creature aDefender, Creature aAttacker) {
        int damageToDeal = (aAttacker.attack - aDefender.armor) * aAttacker.amount;
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        return damageToDeal;
    }

    private boolean isAlive() {
        return currentHp > 0 && amount > 0;
    }

    int getMoveRange() {
        return moveRange;
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
}
