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

    private final GameEngine gameEngine = new GameEngine();

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

        gameEngine.board.put(new Point(0,8),c1);
        gameEngine.board.put(new Point(14,8),c2);
        gameEngine.board.put(new Point(0,3),c3);
        gameEngine.board.put(new Point(14,3),c4);
        gameEngine.board.put(new Point(7,5),beh);
        gameEngine.board.put(new Point(7,6),new LavaObstacle());
        gameEngine.board.put(new Point(7,7),new RockObstacle());
        gameEngine.board.put(new Point(7,8),new RockObstacle());
        gameEngine.board.put(new Point(7,4),new LavaObstacle());
        gameEngine.board.put(new Point(7,3),new RockObstacle());
        gameEngine.board.put(new Point(7,2),new RockObstacle());
        gameEngine.putCreaturesToQueue(List.of(c1, c2, c3, c4, beh));
    }
// ====================================== GUI =====================================
    @FXML
    private void initialize() {
        refreshGui();
        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            gameEngine.pass();
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
        GuiTileIf creature = gameEngine.board.get(new Point(aX, aY));
        MapTile tile = new MapTile("");
        if (creature != null) {
            tile.setName(creature.toString());
            if (gameEngine.findCreaturePosition(gameEngine.activeCreature).equals(new Point(aX, aY))) {
                tile.setBackground(Color.GREEN);
            }
            if (gameEngine.isAttackPossible(aX, aY)) {
                tile.setBackground(Color.RED);
                tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.attack(aX, aY));
            }
        }

        if (gameEngine.isMoveAllowed(aX, aY)) {
            tile.setBackground(Color.GRAY);
            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> gameEngine.move(aX, aY));
        }
        gridMap.add(tile, aX, aY);
    }


// =============================== LOGIC ==============================
    public boolean isMoveAllowed(int x, int y) {
        return gameEngine.isMoveAllowed(x, y);
    }

    public void move(int x, int y) {
        gameEngine.move(x, y);
    }

    public void attack(int x, int y) {
        gameEngine.attack(x, y);
    }

    public boolean isAttackPossible(int x, int y) {
        return gameEngine.isAttackPossible(x, y);
    }

    public void pass() {
        gameEngine.pass();
    }

    public void putCreaturesToQueue(List<Creature> aCreatures) {

        gameEngine.putCreaturesToQueue(aCreatures);
    }

    public Point findCreaturePosition(Creature aCreature) {
        return gameEngine.findCreaturePosition(aCreature);
    }
}
