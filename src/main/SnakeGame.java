package main;

import lib.*;
import java.util.List;
import java.util.Random;

public class SnakeGame extends AbstractGame {

    private Random random = new Random();
    private Map map = new Map();

    public SnakeGame() {
        // Just sample blocks. Feels free to remove them
        map.addBlock(new Block(9, 9));
        map.addBlock(new Block(10, 10));
        map.addBlock(new Block(11, 11));
        map.addBlock(new Block(12, 12));
    }

    public int getMapSize() {
        return map.getSize();
    }

    public List<Block> getBlocks() {
        return map.getBlocks();
    }

    @Override
    protected void gameLogic() {
        // TODO: This method is called every loop
    }

    @Override
    protected void handleLeftKey() {
        System.out.println("Left key is pressed");
        // TODO: This method is called when left key is pressed
    }

    @Override
    protected void handleRightKey() {
        System.out.println("Right key is pressed");
        // TODO: This method is called when right key is pressed
    }

    @Override
    protected void handleUpKey() {
        System.out.println("Up key is pressed");
        // TODO: This method is called when up key is pressed
    }

    @Override
    protected void handleDownKey() {
        System.out.println("Down key is pressed");
        // TODO: This method is called when down key is pressed
    }

}
