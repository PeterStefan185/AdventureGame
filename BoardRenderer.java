
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BoardRenderer extends Renderer
{   
    void drawBackground()
    {
        // "erase" the canvas by drawing a white rectangle
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
    }
    
}
