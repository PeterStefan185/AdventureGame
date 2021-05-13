
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Game
{

    Board board;

    GameCanvas canvas;

    int turn = 0;
    PlayerPiece player;

    /**
     * Default constructor for a game, which initializes the board and players.
     */
    Game() 
    throws FileNotFoundException
    {
        // load board squares from a text file
        board = new Board(16,16, "boards/board1.txt");
        board.loadPieces("pieces/level1.txt");

        player = new PlayerPiece(board.getSquare(0,0));
    }
    
    void levelIsComplete() 
    throws FileNotFoundException
    {
        for (Square s: board.squares)
        {
            if (s.getClass() == Goal.class && player.currentLocation == s)
            {
                board = new Board(16,16, "boards/board2.txt");
                board.loadPieces("pieces/level2.txt");

                player = new PlayerPiece(board.getSquare(0,0));
            }
        }
        
    }
    
    boolean playerIsDead()
    {
        if (player.currentLocation.kill() == true)
        {
            return true;
        }
        return false;
    }
    
    void teleport()
    {
        
    }
    
    boolean isGameOver()
    {
        return false;
    }

    void startNextTurn()
    {
        checkForKey();
        turn++;
        
    }

    ///////////////////////////////////////////////////////
    // set up rendering methods for all game objects

    void loadCanvas(GameCanvas canvas)
    {
        this.canvas = canvas;

        // assign boardRenderer to the board
        board.loadRenderer(canvas.boardRenderer);

        // assign squareRenderer renderer to every square
        for (Square s : board.squares)
        {
            s.loadRenderer(canvas.squareRenderer);
        }

        // assign pieceRenderer renderer to every piece
        for (Square square : board.squares)
        {
            for (Piece p : square.pieces)
            {
                p.loadRenderer(canvas.pieceRenderer);
            }
        }
    }
    void checkForKey()
    {
        for (Square s: board.squares)
        {
            for (Piece p: s.pieces)
            {
                if (p.getClass() == Key.class && player.currentLocation == p.currentLocation)
                {
                    player.inventory.add(p); 
                    s.pieces.remove(p);
                    //remove key from board
                    // add key to players inventory 
                }
            }
        }
    }
    
}
