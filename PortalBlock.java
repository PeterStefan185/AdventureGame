 

public class PortalBlock extends Square
{
    PortalBlock(Board board, int x, int y)
    {
        super(board, x, y);
        
        fillColor = "PINK";
    }
    
    boolean canTeleport()
    {
        return true;
    }
}
