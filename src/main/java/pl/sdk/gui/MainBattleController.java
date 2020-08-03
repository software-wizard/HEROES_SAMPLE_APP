package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.awt.Point;
import java.util.*;

public class MainBattleController {

    private final Map<Point, Creature> board = new HashMap<>();
    private Creature activeCreature;
    private final Queue<Creature> creaturesQueue = new LinkedList<>();

    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    public MainBattleController() {
        Creature c1 = new Creature(100,30, 5, "Air Elemental",7,5);
        Creature c2 = new Creature(100,30, 5, "Water Elemental",7,5);
        Creature c3 = new Creature(100,30, 5, "Earth Elemental",7,5);
        Creature c4 = new Creature(100,30, 5, "Fire Elemental",7,5);

        board.put(new Point(0,8),c1);
        board.put(new Point(14,8),c2);
        board.put(new Point(0,3),c3);
        board.put(new Point(14,3),c4);
        putCreaturesToQueue(List.of(c1, c2,c3,c4));
    }
// ====================================== GUI =====================================
    @FXML
    private void initialize() {
        refreshGui();
        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            pass();
        });
    }

    private void refreshGui() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                createTile(i, j);
            }
        }
    }

    private void createTile(int aX, int aY) {
        Creature creature = board.get(new Point(aX, aY));
        MapTile tile = new MapTile("");
        if (creature != null) {
            tile.setName(creature.toString());
            if (findCreaturePosition(activeCreature).equals(new Point(aX, aY))) {
                tile.setBackground(Color.GREEN);
            }
            if (isAttackPossible(aX, aY)) {
                tile.setBackground(Color.RED);
                tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> attack(aX, aY));
            }
        }

        if (isMoveAllowed(aX, aY)) {
            tile.setBackground(Color.GRAY);
            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> move(aX, aY));
        }
        gridMap.add(tile, aX, aY);
    }


// =============================== LOGIC ==============================
    public boolean isMoveAllowed(int x, int y) {
        return !board.containsKey(new Point(x, y)) && new Point(x, y).distance(findCreaturePosition(activeCreature)) <= activeCreature.getMoveRange();
    }

    public void move(int x, int y) {
        Point oldPosition = findCreaturePosition(activeCreature);
        board.remove(oldPosition);
        board.put(new Point(x, y), activeCreature);
        refreshGui();
    }

    public void attack(int x, int y) {
        activeCreature.attack(board.get(new Point(x, y)));
        refreshGui();
        pass();
    }

    public boolean isAttackPossible(int x, int y) {
        return findCreaturePosition(activeCreature).distance(new Point(x, y)) == 1;
    }

    public void pass() {
        Creature creatureFromQueue = creaturesQueue.poll();
        activeCreature = creatureFromQueue;
        creaturesQueue.add(creatureFromQueue);
        refreshGui();
    }

    public void putCreaturesToQueue(List<Creature> aCreatures) {
        List<Creature> creatures = new ArrayList<>(aCreatures);
        creatures.sort(Comparator.comparingInt(Creature::getMoveRange).reversed());

        creaturesQueue.addAll(creatures);
        activeCreature = creaturesQueue.poll();
        creaturesQueue.add(activeCreature);
    }

    public Point findCreaturePosition(Creature aCreature) {
        return board.keySet().stream().filter(p -> board.get(p).equals(aCreature)).findAny().get();
    }
}
