package sweeper;

public class Flag {
    private Matrix flagMap;

    private int totalFlaged;
    private int totalClosed;

    void start(){
        flagMap = new Matrix(Box.CLOSED);
        totalFlaged = 0;
        totalClosed = Ranges.getSquare();
    }

    Box get (Coord coord){
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        totalClosed--;
    }

   private void setFlagedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGED);
        totalFlaged++;
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
        totalFlaged--;
    }

    void toggleFlagedToBox(Coord coord) {
        switch (flagMap.get(coord)){
            case FLAGED: setClosedToBox(coord); break;
            case CLOSED: setFlagedToBox(coord); break;
        }
    }

    int getTotalFlaged() {
        return totalFlaged;
    }

    int getTotalClosed() {
        return totalClosed;
    }

    public void setFlagedToLastClosedBoxes() {
        for(Coord coord : Ranges.getAllCoords())
            if(Box.CLOSED == flagMap.get(coord))
                setFlagedToBox(coord);
    }

    public void setBombedToBox(Coord bombedCoord) {
        flagMap.set(bombedCoord, Box.BOMBED);
    }

    public void setOpenedToClosedBox(Coord coord) {
        if(Box.CLOSED == flagMap.get(coord))
            flagMap.set(coord, Box.OPENED);
    }

    public void setNobombToFlagedBox(Coord coord) {
        if(Box.FLAGED == flagMap.get(coord))
            flagMap.set(coord, Box.NOBOMB);
    }
}
