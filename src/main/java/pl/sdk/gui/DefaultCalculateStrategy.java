package pl.sdk.gui;

public class DefaultCalculateStrategy implements CalculateStrategy {
    @Override
    public int calculateDamageToDeal(Creature aDefender, Creature aAttacker) {
        int damageToDeal = (aAttacker.getAttack() - aDefender.getArmor()) * aAttacker.getAmount();
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        return damageToDeal;
    }
}
