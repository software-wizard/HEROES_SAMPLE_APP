package pl.sdk.gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureTest {

    @Test
    void defenderShouldLost2HpBecauseOfArmor(){
        //given
        Creature student = new Creature(1,1, 1, "Student",1,512);
        Creature professor = new Creature(1000,500, 500, "Professor",11,1);
        //when
        professor.attack(student);
        //then
        assertEquals(13, student.getAmount());
    }

    @Test
    void defenderShouldLost0HpBecauseArmorIsGraterThanAttackerDamage(){
        //given
        Creature student = new Creature(1,1, 1, "Student",1,1);
        Creature professor = new Creature(1000,500, 500, "Professor",11,1);
        //when
        student.attack(professor);
        //then
        assertEquals(1000, professor.getCurrentHp());
    }

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
