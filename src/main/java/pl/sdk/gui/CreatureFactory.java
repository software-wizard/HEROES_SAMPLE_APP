package pl.sdk.gui;

public class CreatureFactory {
    static Creature create(String aName) {
        switch(aName){
            case "Behemoth":
                return new Creature(160,50, 17, "Behemoth",6,6,
                new ReduceArmorPercentageCalculateStrategy(60));
            default:
                throw new UnsupportedOperationException("Not recognized creature" + aName);
        }
    }
}
