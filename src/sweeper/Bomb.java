package sweeper;

public class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    public Bomb(int totalBombs){
        this.totalBombs = totalBombs;
    }

    void start(){
        bombMap = new Matrix(Box.ZERO);
        bombMap.set(new Coord(0,0), Box.BOMB);
    }

    Box get(Coord coord){
        return bombMap.get(coord);
    }
}
