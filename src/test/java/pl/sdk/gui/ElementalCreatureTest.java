package pl.sdk.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementalCreatureTest {

    private Creature airElemental;
    private Creature waterElemental;
    private Creature earthElemental;
    private Creature fireElemental;

    @BeforeEach
    void initElemental(){
        airElemental = new Creature(100,30, 5, "Air Elemental",7,5, new ElementalCalculateStrategy());
        waterElemental = new Creature(100,30, 5, "Water Elemental",7,5, new ElementalCalculateStrategy());
        earthElemental = new Creature(100,30, 5, "Earth Elemental",7,5, new ElementalCalculateStrategy());
        fireElemental = new Creature(100,30, 5, "Fire Elemental",7,5, new ElementalCalculateStrategy());
    }

    @Test
    void airElementalShouldDealHalfDamageToFireElemental(){
        airElemental.attack(fireElemental);
        assertEquals(37,fireElemental.getCurrentHp());
        assertEquals(5,fireElemental.getAmount());
    }

    @Test
    void airElementalShouldDealDoubleDamageToEarthElemental(){
        airElemental.attack(earthElemental);
        assertEquals(50,earthElemental.getCurrentHp());
        assertEquals(3,earthElemental.getAmount());
    }

    @Test
    void airElementalShouldNotChangeDamageForWaterElemental(){
        airElemental.attack(waterElemental);
        assertEquals(75,waterElemental.getCurrentHp());
        assertEquals(4,waterElemental.getAmount());
    }

    @Test
    void fireElementalShouldDealHalfDamageToWaterElemental(){
        fireElemental.attack(waterElemental);
        assertEquals(37,waterElemental.getCurrentHp());
        assertEquals(5,waterElemental.getAmount());
    }

    @Test
    void fireElementalShouldDealDoubleDamageToAirElemental(){
        fireElemental.attack(airElemental);
        assertEquals(50,airElemental.getCurrentHp());
        assertEquals(3,airElemental.getAmount());
    }

    @Test
    void fireElementalShouldNotChangeDamageForEarthElemental(){
        fireElemental.attack(earthElemental);
        assertEquals(75,earthElemental.getCurrentHp());
        assertEquals(4,earthElemental.getAmount());
    }


    @Test
    void earthElementalShouldDealHalfDamageToAirElemental(){
        earthElemental.attack(airElemental);
        assertEquals(37,airElemental.getCurrentHp());
        assertEquals(5,airElemental.getAmount());
    }

    @Test
    void earthElementalShouldDealDoubleDamageToWaterElemental() {
        earthElemental.attack(waterElemental);
        assertEquals(50,waterElemental.getCurrentHp());
        assertEquals(3,waterElemental.getAmount());
    }

    @Test
    void earthElementalShouldNotChangeDamageForFireElemental(){
        earthElemental.attack(fireElemental);
        assertEquals(75,fireElemental.getCurrentHp());
        assertEquals(4,fireElemental.getAmount());
    }


    @Test
    void waterElementalShouldDealHalfDamageToEarthElemental(){
        waterElemental.attack(earthElemental);
        assertEquals(37,earthElemental.getCurrentHp());
        assertEquals(5,earthElemental.getAmount());
    }

    @Test
    void waterElementalShouldDealDoubleDamageToFireElemental(){
        waterElemental.attack(fireElemental);
        assertEquals(50,fireElemental.getCurrentHp());
        assertEquals(3,fireElemental.getAmount());
    }

    @Test
    void waterElementalShouldNotChangeDamageForAirElemental(){
        waterElemental.attack(airElemental);
        assertEquals(75,airElemental.getCurrentHp());
        assertEquals(4,airElemental.getAmount());
    }
}