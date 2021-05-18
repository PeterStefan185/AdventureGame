
import javafx.scene.canvas.Canvas;

public class GameCanvas extends Canvas
{
    // rendering constants
    final int SQUARE_WIDTH = 32;
    final int SQUARE_HEIGHT = 32;
    final int PIECE_WIDTH = 24;
    final int PIECE_HEIGHT = 24;
    final int MARGIN = 32;
    final int SQUARE_MARGIN_X = (SQUARE_WIDTH - PIECE_WIDTH)/2;
    final int SQUARE_MARGIN_Y = (SQUARE_HEIGHT - PIECE_HEIGHT)/2;

    // helper objects to manage the graphics logic
    BoardRenderer boardRenderer;
    SquareRenderer squareRenderer;
    PieceRenderer pieceRenderer;
    SelectionRenderer selectionRenderer;

    GameCanvas(int boardWidth, int boardHeight)
    {
        super(); 
        this.setWidth(16 * SQUARE_WIDTH + 2 * MARGIN);
        this.setHeight(16 * SQUARE_HEIGHT + 2 * MARGIN);

        //initialize renderers
        boardRenderer = new BoardRenderer();
        squareRenderer = new SquareRenderer();
        pieceRenderer = new PieceRenderer();
        selectionRenderer = new SelectionRenderer();
        
        boardRenderer.loadCanvas(this);
        squareRenderer.loadCanvas(this);
        pieceRenderer.loadCanvas(this);
        selectionRenderer.loadCanvas(this);

    }

    /////////////////////////////////////////////////////////////////
    // helper methods for coordinate conversions:

    /**
     * Converts a square's integer x coordinate to the canvas x coordinate
     * measured in pixels.
     * 
     * @param x The x coordinate of the square on the game board.
     * @return The x coordinate of the canvas measured in pixels.
     */
    double convertToCanvasX(int x)
    {
        return x * SQUARE_WIDTH + MARGIN;
    }

    /**
     * Converts a square's integer y coordinate to the canvas y coordinate
     * measured in pixels.
     * 
     * @param y The y coordinate of the square on the game board.
     * @return The y coordinate of the canvas measured in pixels.
     */
    double convertToCanvasY(int y)
    {
        return y * SQUARE_HEIGHT + MARGIN;
    }

    /**
     * Converts a canvas x coordinate to the board x coordinate
     * measured in squares.
     * 
     * @param x The x coordinate of the canvas measured in pixels.
     * @return The x coordinate of the board measured in squares.
     */
    int convertToBoardX(double x)
    {
        return (int)((x - MARGIN) / SQUARE_WIDTH);
    }

    /**
     * Converts a canvas y coordinate to the board y coordinate
     * measured in squares.
     * 
     * @param y The y coordinate of the canvas measured in pixels.
     * @return The y coordinate of the board measured in squares.
     */
    int convertToBoardY(double y)
    {
        return (int)((y - MARGIN) / SQUARE_HEIGHT);
    }
}
