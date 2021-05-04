
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SelectionRenderer extends Renderer
{    
    Color highlightColor = Color.rgb(0, 0, 0, 0.3); // black with 30% opacity.
    Color outlineColor = Color.BLACK;; 
    double outlineWidth = 2;

    void drawHighlighted(int x, int y)
    {
        gc.setFill(highlightColor);
        gc.setLineWidth(outlineWidth);
        gc.setStroke(outlineColor);
        
        gc.fillRect(canvas.convertToCanvasX(x), canvas.convertToCanvasY(y),
            canvas.SQUARE_WIDTH, canvas.SQUARE_HEIGHT);

        gc.strokeRect(canvas.convertToCanvasX(x) + 1, canvas.convertToCanvasY(y) + 1,
            canvas.SQUARE_WIDTH - 1, canvas.SQUARE_HEIGHT - 1);

    }
    
    void drawSelected(int x, int y)
    {
        gc.setFill(Color.TRANSPARENT);
        gc.setLineWidth(outlineWidth);
        gc.setStroke(outlineColor);
        
        gc.fillRect(canvas.convertToCanvasX(x), canvas.convertToCanvasY(y),
            canvas.SQUARE_WIDTH, canvas.SQUARE_HEIGHT);

        gc.strokeRect(canvas.convertToCanvasX(x) + 1, canvas.convertToCanvasY(y) + 1,
            canvas.SQUARE_WIDTH - 1, canvas.SQUARE_HEIGHT - 1);
    }
}
