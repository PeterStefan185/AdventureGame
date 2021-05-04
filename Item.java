class Item extends Piece
{
    Item(Square startingLocation)
    {
        super(startingLocation);
    }
    
    boolean canMove()
    {
        return false;
    }
    
    void render()
    {
        renderer.drawPieceOnBoard(currentLocation.x, currentLocation.y, color, "DIAMOND");
    }
}