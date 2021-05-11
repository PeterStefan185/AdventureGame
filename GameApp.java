
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;

public class GameApp extends Application
{
    Game game;
    GameCanvas canvas;

    double mouseX;
    double mouseY;

    Square selectedSquare;
    Square hoveredSquare;

    @Override
    public void start(Stage stage) throws Exception
    {
        // set up the game components 
        game = new Game();

        // create canvas
        canvas = new GameCanvas(game.board.WIDTH, game.board.HEIGHT);

        // link the canvas to the game to enable rendering methods
        game.loadCanvas(canvas);

        // put everything in a window layout manager
        BorderPane userInterface = new BorderPane();
        userInterface.setCenter(canvas);

        Scene scene = new Scene(userInterface);
        stage.setScene(scene);
        stage.setResizable(false);

        // link the methods that handle mouse and keyboard events
        canvas.setOnMouseClicked(this::handleMouseClick);
        canvas.setOnMouseMoved(this::handleMouseMove);
        scene.setOnKeyPressed(this::handleKeyPress);

        // launch the window and render the game 
        stage.show();
        renderGame();
    }

    ////////////////////////////////////////////////////////////
    // rendering methods

    void renderGame()
    {
        game.board.render();
        renderSelection();
    }

    void renderSelection()
    {
        if (selectedSquare != null)
        {
            int x = selectedSquare.x;
            int y = selectedSquare.y;
            canvas.selectionRenderer.drawSelected(x, y);
        }

        if (hoveredSquare != null)
        {
            int x = hoveredSquare.x;
            int y = hoveredSquare.y;
            canvas.selectionRenderer.drawHighlighted(x, y);
        }

    }

    ///////////////////////////////////////////////////
    // keyboard events

    void handleKeyPress(KeyEvent e) 
    {

        if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP)
        {
            game.player.moveUp();
            finishTurn();
        }
        else if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN)
        {
            game.player.moveDown();
            finishTurn();
        }
        else if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT)
        {
            game.player.moveLeft();
            finishTurn();
        }
        else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT)
        {
            game.player.moveRight();
            finishTurn();
        }
        else if (e.getCode() == KeyCode.R)
        {
            resetLevel();

        }
        renderGame();
    }

    ///////////////////////////////////////////////////
    // mouse events

    void handleMouseMove(MouseEvent e)
    {
        mouseX = e.getSceneX();
        mouseY = e.getSceneY();

        updateHoveredSquare();
    }

    void handleMouseClick(MouseEvent e)
    {
        mouseX = e.getSceneX();
        mouseY = e.getSceneY();

        Square clickedSquare = getSquareFromCanvasCoords(mouseX, mouseY);

        selectedSquare = clickedSquare;

        
        renderGame();
    }
     
    void updateHoveredSquare()
    {
        hoveredSquare = getSquareFromCanvasCoords(mouseX, mouseY);
        renderGame();
    }

    private Square getSquareFromCanvasCoords(double canvasX, double canvasY)
    {
        Square s = null;

        int x = canvas.convertToBoardX(canvasX);
        int y = canvas.convertToBoardY(canvasY);

        if (x >= 0 && x < game.board.WIDTH && y >=0 && y < game.board.HEIGHT)
        {
            int index = y * game.board.HEIGHT + x;
            s = game.board.squares[index];
        }

        return s;
    }

    void resetLevel()
    {
        try
        {
            this.game = new Game();
        } 
        catch (Exception e) 
        {

        }
        game.loadCanvas(canvas);
    }

    void teleport()
    {
    }

    void finishTurn()    
    {
        game.startNextTurn();
        if (game.playerIsDead())
        {
            resetLevel();
        }
        renderGame();
    }

}
