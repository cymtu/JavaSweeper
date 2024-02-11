package sweeper;

public class Ranges {

    static private Coord size;

    public static Coord getSize() {
        return size;
    }

    public static void setSize(Coord size) {
        Ranges.size = size;
    }

    public static void setSize(int cols, int rows){
        Coord size = new Coord(cols, rows);
        setSize(size);
    }
}
