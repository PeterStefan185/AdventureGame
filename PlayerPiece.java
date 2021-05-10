
public class PlayerPiece extends Piece
{
    String direction;
    
    PlayerPiece(Square startingLocation)
    {
        super(startingLocation);
        this.color = "Turquoise";
        this.direction = "UP";
    }
    
    void moveUp()
    {
        move(0, -1);
        this.direction = "UP";
    }

    void moveDown()
    {
        move(0, 1);
        this.direction = "DOWN";
    }

    void moveLeft()
    {
        this.direction = "LEFT";
        if (currentLocation.x > 0)
        {
            move(-1, 0);
        }
    }

    void moveRight()
    {
        this.direction = "RIGHT";
        if (currentLocation.x < currentLocation.board.WIDTH - 1)
        {
            move(1, 0);
        }
    }
    
    
    void render()
    {
        if (direction.equals("UP"))
        {
            renderer.drawPieceOnBoard(currentLocation.x, currentLocation.y, color, "TRIANGLEUP");
        }
        else if (direction.equals("DOWN"))
        {
            renderer.drawPieceOnBoard(currentLocation.x, currentLocation.y, color, "TRIANGLEDOWN");
        }
        else if (direction.equals("LEFT"))
        {
            renderer.drawPieceOnBoard(currentLocation.x, currentLocation.y, color, "TRIANGLELEFT");
        }
        else if (direction.equals("RIGHT"))
        {
            renderer.drawPieceOnBoard(currentLocation.x, currentLocation.y, color, "TRIANGLERIGHT");
        }
        
        
    }

    
}
