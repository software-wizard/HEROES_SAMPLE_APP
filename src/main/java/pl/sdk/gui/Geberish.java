package pl.sdk.gui;

public class Geberish {
    public int considerSpecialMechanic(Creature aAttacker, Creature aDefender, int aDamageToDeal) {
        if (aAttacker.getName().equals("Water Elemental")) {
            if (aDefender.getName().equals("Fire Elemental")) {
                aDamageToDeal = aDamageToDeal * 2;
            } else if (aDefender.getName().equals("Earth Elemental")) {
                aDamageToDeal = (int) Math.round(aDamageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Fire Elemental")) {
            if (aDefender.getName().equals("Air Elemental")) {
                aDamageToDeal = aDamageToDeal * 2;
            } else if (aDefender.getName().equals("Water Elemental")) {
                aDamageToDeal = (int) Math.round(aDamageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Air Elemental")) {
            if (aDefender.getName().equals("Earth Elemental")) {
                aDamageToDeal = aDamageToDeal * 2;
            } else if (aDefender.getName().equals("Fire Elemental")) {
                aDamageToDeal = (int) Math.round(aDamageToDeal * 0.5);
            }
        } else if (aAttacker.getName().equals("Earth Elemental")) {
            if (aDefender.getName().equals("Water Elemental")) {
                aDamageToDeal = aDamageToDeal * 2;
            } else if (aDefender.getName().equals("Air Elemental")) {
                aDamageToDeal = (int) Math.round(aDamageToDeal * 0.5);
            }
        }
        return aDamageToDeal;
    }
}
