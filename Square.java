
import java.util.ArrayList;

class Square
{
    Board board;
    int x;
    int y;

    ArrayList<Piece> pieces = new ArrayList<Piece>();
    int maxPieceCapacity;
    
    SquareRenderer renderer;
    String fillColor;
    

    Square(Board board, int x, int y)
    {
        this.board = board;
        this.x = x;
        this.y = y;

        this.maxPieceCapacity = 100;
        this.fillColor = "WHITE";
    }
    boolean kill()
    {
        return false;
    }
    boolean isBlocked()
    {
        return false;
    }
    
    boolean canAddPiece(Piece p)
    {
        if (!pieces.contains(p) && pieces.size() < maxPieceCapacity)
        {
            return true;
        }
        return false;
    }

    void addPiece(Piece p)
    {
        if (canAddPiece(p))
        {
            pieces.add(p);
        }
    }

    boolean canRemovePiece(Piece p)
    {
        if (pieces.contains(p))
        {
            return true;
        }
        return false;
    }

    void removePiece(Piece p)
    {
        pieces.remove(p);
        if (canRemovePiece(p))
        {
            pieces.remove(p);
        }
    }

    ///////////////////////////////////////////////////////
    // rendering methods
    
    void loadRenderer(SquareRenderer r)
    {
        this.renderer = r;
    }
    
    
    void render()
    {
        renderer.drawSquare(x, y, fillColor);
        
        //tell pieces to render themselves
        for (Piece p : pieces)
        {
            p.render();
        }
    }
    
    
}