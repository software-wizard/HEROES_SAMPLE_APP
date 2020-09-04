package pl.sdk.gui;

public class ElementalCreature extends Creature {

    public ElementalCreature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount) {
        super(aMaxHp, aAttack, aArmor, aName, aMoveRange, aAmount);
    }

    @Override
    protected int considerSpecialMechanic(Creature aDefender, Creature aAttacker, int damageToDeal) {
        if (aAttacker.getName().equals("Water Elemental")) {
            if (aDefender.getName().equals("Fire Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.getName().equals("Earth Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Fire Elemental")) {
            if (aDefender.getName().equals("Air Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.getName().equals("Water Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Air Elemental")) {
            if (aDefender.getName().equals("Earth Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.getName().equals("Fire Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Earth Elemental")) {
            if (aDefender.getName().equals("Water Elemental")) {
                damageToDeal = damageToDeal * 2;
            } else if (aDefender.getName().equals("Air Elemental")) {
                damageToDeal = (int) Math.round(damageToDeal * 0.5);
            }
        }
        return damageToDeal;
    }
}
