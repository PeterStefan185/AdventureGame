abstract class Piece
{
    String name;
    String color;
    Square currentLocation;
    PieceRenderer renderer;

    Piece(Square startingLocation)
    {
        this.currentLocation = startingLocation;
        startingLocation.addPiece(this);
        this.color = "RED";
    }

    Piece(String name, Square startingLocation)
    {
        this.name = name;
        this.currentLocation = startingLocation;
    }

    void setPieceName(String name)
    {
        this.name = name;
    }

    boolean canMove()
    {
        return true;
    }
    
    void move(Square newLocation)
    {
        if (isLegalMove(newLocation) && this.canMove())
        {
            if (newLocation != currentLocation)
            {
                newLocation.addPiece(this);
                currentLocation.removePiece(this);
            }
            currentLocation = newLocation;
        }
    }

    void move(int deltaX, int deltaY)
    {
        Board b = currentLocation.board;

        int x = currentLocation.x;
        int y = currentLocation.y;

        move(b.getSquare(x + deltaX, y + deltaY));
    }

    void moveUp()
    {
        move(0, -1);
    }

    void moveDown()
    {
        move(0, 1);
    }

    void moveLeft()
    {
        if (currentLocation.x > 0)
        {
            move(-1, 0);
        }
    }

    void moveRight()
    {
        if (currentLocation.x < currentLocation.board.WIDTH - 1)
        {
            move(1, 0);
        }
    }

    boolean isLegalMove(Square newLocation)
    {
        if (newLocation.isBlocked() == true)
        {
            return false;
        }
        return true;
    }
    
    void removePieceFromGame()
    {
        currentLocation.removePiece(this);
    }

    ///////////////////////////////////////////////////////
    // rendering methods

    void loadRenderer(PieceRenderer r)
    {
        this.renderer = r;
    }

    void render()
    {
        renderer.drawPieceOnBoard(currentLocation.x, currentLocation.y, color, "CIRCLE");
    }
}