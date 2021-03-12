package pl.sdk.gui.gui;

import org.junit.jupiter.api.Test;
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
}