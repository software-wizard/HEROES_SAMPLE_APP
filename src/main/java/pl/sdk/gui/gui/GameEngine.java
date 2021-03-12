package pl.sdk.gui.gui;

import pl.sdk.gui.Creature;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class GameEngine {
    final Map<Point, GuiTileIf> board;
    Creature activeCreature;
    final Queue<Creature> creaturesQueue = new LinkedList<>();

    public GameEngine() {
        this(new HashMap<>());
    }

    public GameEngine(Map<Point, GuiTileIf> aBoard){
        board = aBoard;
        putCreaturesToQueue(aBoard.values().stream().filter(Creature.class::isInstance).map(Creature.class::cast).collect(Collectors.toList()));
    }

    public boolean isMoveAllowed(int x, int y) {
        boolean isMovePossible = true;
        if (board.containsKey(new Point(x, y))) {
            isMovePossible = board.get(new Point(x, y)).isMovePossible();
        }
        return isMovePossible && new Point(x, y).distance(findCreaturePosition(activeCreature)) <= activeCreature.getMoveRange();
    }

    public void move(int x, int y) {
        Point oldPosition = findCreaturePosition(activeCreature);
        board.remove(oldPosition);
        board.put(new Point(x, y), activeCreature);
    }

    public void pass() {
        Creature creatureFromQueue = creaturesQueue.poll();
        activeCreature = creatureFromQueue;
        creaturesQueue.add(creatureFromQueue);
    }

    public void attack(int x, int y) {
        activeCreature.attack((Creature) board.get(new Point(x, y)));
        pass();
    }

    public boolean isAttackPossible(int x, int y) {
        boolean distanceAllow = findCreaturePosition(activeCreature).distance(new Point(x, y)) == 1;
        return distanceAllow && board.get(new Point(x, y)).isAttackPossible();
    }

    public void putCreaturesToQueue(List<Creature> aCreatures) {
        List<Creature> creatures = new ArrayList<Creature>(aCreatures);
        creatures.sort(Comparator.comparingInt(Creature::getMoveRange).reversed());

        creaturesQueue.addAll(creatures);
        activeCreature = creaturesQueue.poll();
        creaturesQueue.add(activeCreature);
    }

    public Point findCreaturePosition(Creature aCreature) {
        return board.keySet().stream().filter(p -> board.get(p).equals(aCreature)).findAny().get();
    }
}