package pl.sdk.gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShootingCreatureTest {

    @Test
    void shouldNotCounterAttackWhenAttackerIsShooter(){
        //given
        Creature attacker = new ShootingCreature(100,1, 1, "Student",1,100);
        Creature defender = new Creature(100,10, 1, "Student",1,100);
        //when
        attacker.attack(defender);
        //then
        assertEquals(100,attacker.getCurrentHp());
        assertEquals(100,attacker.getAmount());
    }
}