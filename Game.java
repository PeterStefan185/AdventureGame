
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Game
{

    Board board;
    Board[] levels;
    GameCanvas canvas;

    int turn = 0;
    int level;
    PlayerPiece player;

    /**
     * Default constructor for a game, which initializes the board and players.
     */
    Game() 
    throws FileNotFoundException
    {
        // load board squares from a text file
        this.levels = new Board[6];
        this.level = 1;

        // LEVEL 1
        levels[0] = new Board(8,8, "boards/board1.txt");
        levels[0].loadPieces("pieces/level1.txt");
        // LEVEL 2
        levels[1] = new Board(10,10, "boards/board2.txt");
        levels[1].loadPieces("pieces/level2.txt");
        // LEVEL 3
        levels[2] = new Board(12,12, "boards/board3.txt");
        levels[2].loadPieces("pieces/level3.txt");
        // LEVEL 4
        levels[3] = new Board(14,14, "boards/board4.txt");
        levels[3].loadPieces("pieces/level4.txt");
        // LEVEL 5
        levels[4] = new Board(16,16, "boards/board5.txt");
        levels[4].loadPieces("pieces/level5.txt");
        //THE END
        levels[5] = new Board(16,16, "boards/board6.txt");
        levels[5].loadPieces("pieces/level6.txt");
        
        board = levels[0];
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
        for (Board b : levels)
        {
            // assign boardRenderer to the board
            b.loadRenderer(canvas.boardRenderer);

            // assign squareRenderer renderer to every square
            for (Square s : b.squares)
            {
                s.loadRenderer(canvas.squareRenderer);
            }

            // assign pieceRenderer renderer to every piece
            for (Square square : b.squares)
            {
                for (Piece p : square.pieces)
                {
                    p.loadRenderer(canvas.pieceRenderer);
                }
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
    boolean hasKey()
    {
        if(player.inventory.size() >= 1)
        {
            return true;
        }
        return false;
    }
}
