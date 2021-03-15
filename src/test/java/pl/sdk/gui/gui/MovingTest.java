package pl.sdk.gui.gui;

import org.junit.jupiter.api.Test;
import pl.sdk.gui.Creature;
import pl.sdk.gui.CreatureFactory;

import java.awt.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MovingTest {

    @Test
    void creatureShouldNotCanMoveOnTakenField(){
        //given
        HashMap<Point, GuiTileIf> testMap = new HashMap<>();
        testMap.put(new Point (0,1), CreatureFactory.create(CreatureFactory.WATER_ELEMENTAL));
        testMap.put(new Point (1,1), CreatureFactory.create(CreatureFactory.BEHEMOTH));
        GameEngine engine = new GameEngine(testMap);

        //when
        boolean result = engine.isMoveAllowed(1, 1);

        //then
        assertFalse(result);
    }

    @Test
    void creatureShouldNotCanMoveOutsideTheMap(){
        //given
        HashMap<Point, GuiTileIf> testMap = new HashMap<>();
        testMap.put(new Point (0,1), CreatureFactory.create(CreatureFactory.WATER_ELEMENTAL));
        GameEngine engine = new GameEngine(testMap);

        //when
        boolean result = engine.isMoveAllowed(-1, 1);

        //then
        assertFalse(result);
    }

    @Test
    void creatureShouldCanStandOnLava(){
        //given
        HashMap<Point, GuiTileIf> testMap = new HashMap<>();
        testMap.put(new Point (0,1), CreatureFactory.create(CreatureFactory.WATER_ELEMENTAL));
        testMap.put(new Point (1,1), new LavaObstacle());
        GameEngine engine = new GameEngine(testMap);

        //when
        boolean result = engine.isMoveAllowed(1, 1);

        //then
        assertTrue(result);
    }

    @Test
    void LavaShouldNotDisappearAfterCreatureMove(){
        //given
        HashMap<Point, GuiTileIf> testMap = new HashMap<>();
        Creature creature = CreatureFactory.create(CreatureFactory.WATER_ELEMENTAL);
        testMap.put(new Point (0,1), creature);
        LavaObstacle lava = new LavaObstacle();
        testMap.put(new Point (1,1), lava);
        GameEngine engine = new GameEngine(testMap);

        //when
        engine.move(1, 1);
        GuiTileIf tempResult = engine.board.get(new Point(1, 1));
        engine.move(1, 2);
        GuiTileIf result = engine.board.get(new Point(1, 1));

        //then
        assertEquals(tempResult, creature);
        assertEquals(result, lava);
    }
}