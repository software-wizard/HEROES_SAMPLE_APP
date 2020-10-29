package pl.sdk.gui.gui;

public class LavaObstacle implements GuiTileIf {
    @Override
    public boolean isMovePossible() {
        return true;
    }

    @Override
    public boolean isAttackPossible() {
        return false;
    }

    @Override
    public String toString() {
        return "LAVA";
    }
}
