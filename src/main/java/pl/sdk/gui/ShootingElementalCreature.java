package pl.sdk.gui;

public class ShootingElementalCreature extends ElementalCreature{

    public ShootingElementalCreature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount) {
        super(aMaxHp, aAttack, aArmor, aName, aMoveRange, aAmount);
    }

    @Override
    protected void ca(Creature aDefender) {

    }
}
