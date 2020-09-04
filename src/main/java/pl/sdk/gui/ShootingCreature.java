package pl.sdk.gui;

public class ShootingCreature extends Creature {

    public ShootingCreature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount) {
        super(aMaxHp, aAttack, aArmor, aName, aMoveRange, aAmount);
    }

    @Override
    protected void ca(Creature aDefender) {
        
    }

    @Override
    protected int considerSpecialMechanic(Creature aDefender, Creature aAttacker, int damageToDeal) {
        return damageToDeal;
    }
}
