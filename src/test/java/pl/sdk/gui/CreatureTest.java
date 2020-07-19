package pl.sdk.gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureTest {

    @Test
    void defenderShouldLost2HpBecauseOfArmor(){
        //given
        Creature student = new Creature(1,1, 1, "Student",1);
        Creature professor = new Creature(1000,500, 500, "Professor",11);
        //when
        professor.attack(student);
        //then
        assertEquals(-498, student.getCurrentHp());
    }

    @Test
    void defenderShouldLost0HpBecauseArmorIsGraterThanAttackerDamage(){
        //given
        Creature student = new Creature(1,1, 1, "Student",1);
        Creature professor = new Creature(1000,500, 500, "Professor",11);
        //when
        student.attack(professor);
        //then
        assertEquals(1000, professor.getCurrentHp());
    }
}
