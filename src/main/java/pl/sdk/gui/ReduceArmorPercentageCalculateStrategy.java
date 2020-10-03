package pl.sdk.gui;

public class ReduceArmorPercentageCalculateStrategy implements CalculateStrategy {

    private int armorPercentageReduce;
    public ReduceArmorPercentageCalculateStrategy(int aArmorToReduce) {
        armorPercentageReduce = aArmorToReduce;
    }

    @Override
    public int calculateDamageToDeal(Creature aDefender, Creature aAttacker) {
        int damageToDeal = (aAttacker.getAttack() - (aDefender.getArmor() - aDefender.getArmor() * armorPercentageReduce/100)) * aAttacker.getAmount();
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        return damageToDeal;
    }
}
