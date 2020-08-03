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

    public Creature(int aMaxHp, Integer aAttack, Integer aArmor, String aName, int aMoveRange, int aAmount) {
        maxHp = aMaxHp;
        attack = aAttack;
        armor = aArmor;
        currentHp = maxHp;
        name = aName;
        moveRange = aMoveRange;
        amount = aAmount;
    }

    public void attack(Creature aDefender) {
        if (currentHp > 0 && amount > 0) {
            int damageToDeal = (attack - aDefender.armor) * amount;
            if (damageToDeal < 0) {
                damageToDeal = 0;
            }

            if (name.equals("Water Elemental")) {
                if (aDefender.name.equals("Fire Elemental")) {
                    damageToDeal = damageToDeal * 2;
                } else if (aDefender.name.equals("Earth Elemental")) {
                    damageToDeal = (int) Math.round(damageToDeal * 0.5);
                }
            } else if (name.equals("Fire Elemental")) {
                if (aDefender.name.equals("Air Elemental")) {
                    damageToDeal = damageToDeal * 2;
                } else if (aDefender.name.equals("Water Elemental")) {
                    damageToDeal = (int) Math.round(damageToDeal * 0.5);
                }
            } else if (name.equals("Air Elemental")) {
                if (aDefender.name.equals("Earth Elemental")) {
                    damageToDeal = damageToDeal * 2;
                } else if (aDefender.name.equals("Fire Elemental")) {
                    damageToDeal = (int) Math.round(damageToDeal * 0.5);
                }
            } else if (name.equals("Earth Elemental")) {
                if (aDefender.name.equals("Water Elemental")) {
                    damageToDeal = damageToDeal * 2;
                } else if (aDefender.name.equals("Air Elemental")) {
                    damageToDeal = (int) Math.round(damageToDeal * 0.5);
                }
            }

            int killedUnits = damageToDeal / aDefender.maxHp;
            int lostHp = damageToDeal % aDefender.maxHp;
            aDefender.amount = aDefender.amount - killedUnits;
            aDefender.currentHp = aDefender.currentHp - lostHp;

            if (!aDefender.counterAttack && aDefender.currentHp > 0 && aDefender.amount > 0) {
                int damageToDealInCounterAttack = (aDefender.attack - armor) * amount;
                if (damageToDealInCounterAttack < 0) {
                    damageToDealInCounterAttack = 0;
                }

                if (aDefender.name.equals("Water Elemental")) {
                    if (name.equals("Fire Elemental")) {
                        damageToDealInCounterAttack = damageToDeal * 2;
                    } else if (name.equals("Earth Elemental")) {
                        damageToDealInCounterAttack = (int) Math.round(damageToDeal * 0.5);
                    }
                } else if (aDefender.name.equals("Fire Elemental")) {
                    if (name.equals("Air Elemental")) {
                        damageToDealInCounterAttack = damageToDeal * 2;
                    } else if (name.equals("Water Elemental")) {
                        damageToDealInCounterAttack = (int) Math.round(damageToDeal * 0.5);
                    }
                } else if (aDefender.name.equals("Air Elemental")) {
                    if (name.equals("Earth Elemental")) {
                        damageToDealInCounterAttack = damageToDeal * 2;
                    } else if (name.equals("Fire Elemental")) {
                        damageToDealInCounterAttack = (int) Math.round(damageToDeal * 0.5);
                    }
                } else if (aDefender.name.equals("Earth Elemental")) {
                    if (name.equals("Water Elemental")) {
                        damageToDealInCounterAttack = damageToDeal * 2;
                    } else if (name.equals("Air Elemental")) {
                        damageToDealInCounterAttack = (int) Math.round(damageToDeal * 0.5);
                    }
                }

                int killedUnitsAfterCounterAttack = damageToDealInCounterAttack / aDefender.maxHp;
                int lostHpAfterCounterAttack = damageToDealInCounterAttack % aDefender.maxHp;
                amount = aDefender.amount - killedUnitsAfterCounterAttack;
                currentHp = aDefender.currentHp - lostHpAfterCounterAttack;
                counterAttack=true;
            }
        }
    }

    int getMoveRange() {
        return moveRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String[] splitName = name.split(" ");
        for (int i = 0; i < splitName.length; i++){
            sb.append(splitName[i]);
            if (i != splitName.length-1){
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
