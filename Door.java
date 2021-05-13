public class Door extends Wall
{
    Door(Board board, int x, int y)
    {
        super(board, x, y);
        
        fillColor = "ORANGE";
    }
    
    
    boolean isBlocked()
    {
        return true;
    }
}