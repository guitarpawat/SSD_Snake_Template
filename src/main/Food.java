package main;

import lib.Block;

public class Food extends Block{

    public Food(int x, int y) {
        super(x, y);
    }
    
    public static class Memento {
        private int x, y;
        public Memento(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public Memento save() {
        return new Memento(x,y);
    }
    
    public void load(Memento m) {
        x = m.x;
        y = m.y;
    }
}
