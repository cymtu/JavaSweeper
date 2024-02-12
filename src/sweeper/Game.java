package sweeper;

public class Game {

    Matrix bombMap;
    public Game(int cols, int rows) {
        Ranges.setSize(new Coord(cols, rows));
    }

    public Box getBox(Coord coord){
        return bombMap.matrix[coord.x][coord.y];
    }

    public void start(){
        bombMap = new Matrix(Box.ZERO);
    }
}
