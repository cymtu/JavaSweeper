package sweeper;

public class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    public Bomb(int totalBombs){
        this.totalBombs = totalBombs;
    }

    void start(){
        bombMap = new Matrix(Box.ZERO);
        for(int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    Box get(Coord coord){
        return bombMap.get(coord);
    }

    void placeBomb(){
        bombMap.set(Ranges.getRandomCoord(), Box.BOMB);
    }
}
