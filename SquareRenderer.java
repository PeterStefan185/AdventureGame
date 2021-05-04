
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class SquareRenderer extends Renderer
{
    void drawSquare(int x, int y, String fillColor)
    {
        gc.setFill(Color.valueOf(fillColor));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        gc.fillRect(canvas.convertToCanvasX(x), canvas.convertToCanvasY(y),
            canvas.SQUARE_WIDTH, canvas.SQUARE_HEIGHT);

        gc.strokeRect(canvas.convertToCanvasX(x), canvas.convertToCanvasY(y),
            canvas.SQUARE_WIDTH, canvas.SQUARE_HEIGHT);
    }
    
    
}
