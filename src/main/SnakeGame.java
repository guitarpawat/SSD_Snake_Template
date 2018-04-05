package main;

import lib.*;
import java.util.List;
import java.util.Random;

public class SnakeGame extends AbstractGame {

    private Random random = new Random();
    private Map map = new Map();

    private Snake snake = new Snake(10, 10);
    private Food food = new Food(15, 15);

    public SnakeGame() {
        for(Block b : snake.getBody()) {
            map.addBlock(b);
        }
        map.addBlock(food);
    }

    public int getMapSize() {
        return map.getSize();
    }

    public List<Block> getBlocks() {
        return map.getBlocks();
    }

    @Override
    protected void gameLogic() {
        snake.move();
        // Check if snake eat food
        for(Block b : snake.getBody()) {
            if(b.overlapped(food)) {
                Block newBlock = snake.expand();
                map.addBlock(newBlock);
                food.setX(random.nextInt(map.getSize()));
                food.setY(random.nextInt(map.getSize()));
                break;
            }
        }
        // Check if snake hit itself
        if(snake.hitItself()) {
            end();
        }
    }

    @Override
    protected void handleLeftKey() {
        snake.setDx(-1);
        snake.setDy(0);
    }

    @Override
    protected void handleRightKey() {
        snake.setDx(1);
        snake.setDy(0);
    }

    @Override
    protected void handleUpKey() {
        snake.setDx(0);
        snake.setDy(-1);
    }

    @Override
    protected void handleDownKey() {
        snake.setDx(0);
        snake.setDy(1);
    }
    
    public static class Memento {
        private Food.Memento food;
        private Snake.Memento snake;
        
        public Memento(Food food, Snake snake) {
            this.food = food.save();
            this.snake = snake.save();
        }
    }
    
    public Memento save() {
        return new Memento(food, snake);
    }
    
    public void load(Memento m) {
        snake.load(m.snake);
        food.load(m.food);
        map.getBlocks().clear();
        map.getBlocks().addAll(snake.getBody());
        map.getBlocks().add(food);
    }

}
