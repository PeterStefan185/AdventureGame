
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PieceRenderer extends Renderer
{   
    void drawPieceOnBoard(int x, int y, String fillColor, String shape)
    {
        double canvasX = canvas.convertToCanvasX(x) + canvas.SQUARE_MARGIN_X;
        double canvasY = canvas.convertToCanvasY(y) + canvas.SQUARE_MARGIN_Y;

        drawPieceFloating(canvasX, canvasY, fillColor, shape);
    }

    void drawPieceFloating(double canvasX, double canvasY, String fillColor, String shape)
    {
        if (shape.toUpperCase().equals("CIRCLE"))
            drawCirclePiece(canvasX, canvasY, fillColor);
        else if (shape.toUpperCase().equals("SQUARE"))
            drawSquarePiece(canvasX, canvasY, fillColor);
        else if (shape.toUpperCase().equals("TRIANGLEUP"))
            drawTrianglePiece(canvasX, canvasY, "UP", fillColor);
        else if (shape.toUpperCase().equals("TRIANGLEDOWN"))
            drawTrianglePiece(canvasX, canvasY, "DOWN", fillColor);
        else if (shape.toUpperCase().equals("TRIANGLELEFT"))
            drawTrianglePiece(canvasX, canvasY, "LEFT", fillColor);
        else if (shape.toUpperCase().equals("TRIANGLERIGHT"))
            drawTrianglePiece(canvasX, canvasY, "RIGHT", fillColor);
        else if (shape.toUpperCase().equals("DIAMOND"))
            drawDiamondPiece(canvasX, canvasY, fillColor);
        else
            throw new IllegalArgumentException("Invalid name for piece.");

    }

    void drawCirclePiece(double canvasX, double canvasY, String fillColor)
    {
        gc.setFill(Color.valueOf(fillColor));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillOval(canvasX, canvasY, canvas.PIECE_WIDTH, canvas.PIECE_HEIGHT);
        gc.strokeOval(canvasX, canvasY, canvas.PIECE_WIDTH, canvas.PIECE_HEIGHT);
    }

    void drawSquarePiece(double canvasX, double canvasY, String fillColor)
    {
        gc.setFill(Color.valueOf(fillColor));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillRect(canvasX, canvasY, canvas.PIECE_WIDTH, canvas.PIECE_HEIGHT);
        gc.strokeRect(canvasX, canvasY, canvas.PIECE_WIDTH, canvas.PIECE_HEIGHT);
    }

    void drawTrianglePiece(double canvasX, double canvasY, String direction, String fillColor)
    {
        gc.setFill(Color.valueOf(fillColor));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        double left = canvasX;
        double right = canvasX + canvas.PIECE_WIDTH;
        double middleX = (left + right) / 2;

        double top = canvasY;
        double bottom = top + canvas.PIECE_HEIGHT;
        double middleY = (top + bottom) / 2;

        if (direction.equals("UP"))
        {
            double[] xCoords = {left, right, middleX};
            double[] yCoords = {bottom, bottom, top};
            gc.fillPolygon(xCoords, yCoords, 3);
            gc.strokePolygon(xCoords, yCoords, 3);
        }
        else if (direction.equals("DOWN"))
        {
            double[] xCoords = {left, right, middleX};
            double[] yCoords = {top, top, bottom};
            gc.fillPolygon(xCoords, yCoords, 3);
            gc.strokePolygon(xCoords, yCoords, 3);
        }
        else if (direction.equals("LEFT"))
        {
            double[] xCoords = {left, right, right};
            double[] yCoords = {middleY, bottom, top};
            gc.fillPolygon(xCoords, yCoords, 3);
            gc.strokePolygon(xCoords, yCoords, 3);
        }
        else if (direction.equals("RIGHT"))
        {
            double[] xCoords = {left, left, right};
            double[] yCoords = {top, bottom, middleY};
            gc.fillPolygon(xCoords, yCoords, 3);
            gc.strokePolygon(xCoords, yCoords, 3);
        }
    }

    void drawDiamondPiece(double canvasX, double canvasY, String fillColor)
    {
        gc.setFill(Color.valueOf(fillColor));
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        double left = canvasX;
        double right = canvasX + canvas.PIECE_WIDTH;
        double middleX = (left + right) / 2;

        double top = canvasY;
        double bottom = canvasY + canvas.PIECE_HEIGHT;
        double middleY = (top + bottom) / 2;

        double[] xCoords = {left, middleX, right, middleX};
        double[] yCoords = {middleY, bottom, middleY, top};

        gc.fillPolygon(xCoords, yCoords, 4);
        gc.strokePolygon(xCoords, yCoords, 4);
    }
}
