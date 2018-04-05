package main;

import lib.Block;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Block> body = new ArrayList<Block>();
    private int dx = 0;
    private int dy = -1;

    public Snake(int x, int y) {
        body.add(new Block(x, y));
        body.add(new Block(x, y + 1));
        body.add(new Block(x, y + 2));
    }

    public List<Block> getBody() {
        return body;
    }

    public void move() {
        Block lastBlock = body.remove(body.size() - 1);
        Block firstBlock = body.get(0);

        lastBlock.setX(firstBlock.getX() + dx);
        lastBlock.setY(firstBlock.getY() + dy);

        body.add(0, lastBlock);
    }

    public void setDx(int dx) {
        if(this.dx == -dx) return;
        this.dx = dx;
    }

    public void setDy(int dy) {
        if(this.dy == -dy) return;
        this.dy = dy;
    }

    public Block expand() {
        Block lastBlock = body.get(body.size() - 1);
        Block last2Block = body.get(body.size() - 2);
        int ddx = lastBlock.getX() - last2Block.getX();
        int ddy = lastBlock.getY() - last2Block.getY();

        Block newBlock = new Block(
                lastBlock.getX() + ddx,
                lastBlock.getY() + ddy
        );
        body.add(newBlock);
        return newBlock;
    }

    public boolean hitItself() {
        Block head = body.get(0);
        for(int i = 1; i < body.size(); i++) {
            if(head.overlapped(body.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static class Memento {
        private List<Block> body = new ArrayList<>();
        private int dx, dy;
        
        public Memento(List<Block> body, int dx, int dy) {
            for(Block b : body) {
                this.body.add(new Block(b.getX(), b.getY()));
            }
            this.dx = dx;
            this.dy = dy;
        }
    }
    
    public Memento save() {
        return new Memento(body,dx,dy);
    }
    
    public void load(Memento m) {
        body.clear();
        for(Block b : m.body) {
            body.add(new Block(b.getX(),b.getY()));
        }
        dx = m.dx;
        dy = m.dy;
    }
}
