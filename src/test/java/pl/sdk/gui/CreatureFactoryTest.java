package pl.sdk.gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureFactoryTest {

    @Test
    void shouldCreateBehemoth(){

        Creature beh = CreatureFactory.create("Behemoth");

        assertEquals("Behemoth", beh.getName());
    }
}
