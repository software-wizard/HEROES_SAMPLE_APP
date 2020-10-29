package pl.sdk.gui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.sdk.gui.Creature;
import pl.sdk.gui.CreatureFactory;
import pl.sdk.gui.MapTile;

import java.awt.Point;
import java.util.*;


public class MainBattleController {

    private final Map<Point, GuiTileIf> board = new HashMap<>();
    private Creature activeCreature;
    private final Queue<Creature> creaturesQueue = new LinkedList<>();

    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    public MainBattleController() {
        Creature c1 = CreatureFactory.create(CreatureFactory.AIR_ELEMENTAL);
        Creature c2 = CreatureFactory.create(CreatureFactory.EARTH_ELEMENTAL);
        Creature c3 = CreatureFactory.create(CreatureFactory.FIRE_ELEMENTAL);
        Creature c4 = CreatureFactory.create(CreatureFactory.WATER_ELEMENTAL);
        Creature beh = CreatureFactory.create(CreatureFactory.BEHEMOTH);

        board.put(new Point(0,8),c1);
        board.put(new Point(14,8),c2);
        board.put(new Point(0,3),c3);
        board.put(new Point(14,3),c4);
        board.put(new Point(7,5),beh);
        board.put(new Point(7,6),new LavaObstacle());
        board.put(new Point(7,7),new RockObstacle());
        board.put(new Point(7,8),new RockObstacle());
        board.put(new Point(7,4),new LavaObstacle());
        board.put(new Point(7,3),new RockObstacle());
        board.put(new Point(7,2),new RockObstacle());
        putCreaturesToQueue(List.of(c1, c2,c3,c4,beh));
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
        GuiTileIf creature = board.get(new Point(aX, aY));
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
        boolean isMovePossible = true;
        if (board.containsKey(new Point(x, y))){
            isMovePossible = board.get(new Point(x,y)).isMovePossible();
        }
        return isMovePossible && new Point(x, y).distance(findCreaturePosition(activeCreature)) <= activeCreature.getMoveRange();
    }

    public void move(int x, int y) {
        Point oldPosition = findCreaturePosition(activeCreature);
        board.remove(oldPosition);
        board.put(new Point(x, y), activeCreature);
        refreshGui();
    }

    public void attack(int x, int y) {
        activeCreature.attack((Creature)board.get(new Point(x, y)));
        refreshGui();
        pass();
    }

    public boolean isAttackPossible(int x, int y) {
        boolean distanceAllow = findCreaturePosition(activeCreature).distance(new Point(x, y)) == 1;
        return distanceAllow && board.get(new Point(x,y)).isAttackPossible();
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
