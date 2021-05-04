
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Renderer
{
    GameCanvas canvas;
    GraphicsContext gc;
    
    Renderer()
    {   
    }
    
    void loadCanvas(GameCanvas canvas)
    {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
    }
}
