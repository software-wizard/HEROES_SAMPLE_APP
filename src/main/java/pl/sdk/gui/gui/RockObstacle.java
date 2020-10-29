package pl.sdk.gui.gui;

public class RockObstacle implements GuiTileIf{

    @Override
    public boolean isMovePossible() {
        return false;
    }

    @Override
    public boolean isAttackPossible() {
        return false;
    }

    @Override
    public String toString() {
        return "ROCK";
    }
}
