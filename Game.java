
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
    boolean playerIsDead()
    {
        if (player.currentLocation.kill() == true)
        {
            return true;
        }
        return false;
    }
    
    
    boolean isGameOver()
    {
        return false;
    }

    void startNextTurn()
    {
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
}
