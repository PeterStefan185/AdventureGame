public class Wall extends Square
{
    Wall(Board board, int x, int y)
    {
        super(board, x, y);
        
        fillColor = "ORANGE";
    }
    
    
    boolean isBlocked()
    {
        return true;
    }
}
