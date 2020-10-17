package pl.sdk.gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureFactoryTest {

    @Test
    void shouldCreateBehemoth(){
//        Creature beh = new Creature(160,50, 17, "Behemoth",6,6,
//                new ReduceArmorPercentageCalculateStrategy(60));

        Creature beh = CreatureFactory.create("Behemoth");

        assertEquals("Behemoth", beh.getName());
    }
}
