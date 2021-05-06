
class Bot extends Piece
{
   Bot(Square startingLocation)
    {
       super(startingLocation);
       this.color = "GREEN";
    }

    void render()
    {
        renderer.drawPieceOnBoard(currentLocation.x, currentLocation.y, color, "SQUARE");
    }
}
//pebsi lol ur dumb - Blake