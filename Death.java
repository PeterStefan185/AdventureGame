public class Death extends Square
{
    Death(Board board, int x, int y)
    {
        super(board, x, y);
        
        fillColor = "RED";
    }
    boolean kill()
    {
        return true;
    }
}
