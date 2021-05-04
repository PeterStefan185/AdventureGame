import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Board
{
    final int WIDTH;
    final int HEIGHT;
    Square[] squares;

    BoardRenderer renderer;

    /**
     * The default constructor of a game board.
     * 
     * @param width The number of squares horizontally.
     * @param height The number of squares vertically. 
     */
    Board(int width, int height)
    {
        this.WIDTH = width;
        this.HEIGHT = height;
        squares = new Square[width * height];

        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
            {
                int index = y * HEIGHT + x;
                squares[index] = new Square(this, x, y);
            }
        }
    }

    /**
     * Construct a board from a given text file where each character in the file
     * represents a type of square.
     * 
     * @param width The number of squares horizontally.
     * @param height The number of squares vertically.
     * @param filename The name of the text file.
     */
    Board(int width, int height, String filename) throws FileNotFoundException
    {
        this.WIDTH = width;
        this.HEIGHT = height;
        squares = new Square[width * height];

        // read each row of the text file as a String and save it in an array
        Scanner s = new Scanner(new File(filename));
        String[] textRows = new String[height];
        for (int i = 0; i < textRows.length; i++)
        {
            textRows[i] = s.nextLine();
        }
        s.close();

        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
            {
                int index = y * HEIGHT + x;

                char symbol = textRows[y].charAt(x);

                if (symbol == 'X')
                {
                    squares[index] = new Floor(this, x, y);
                }
                else if (symbol == 'P')
                {
                    squares[index] = new PortalBlock(this, x, y);
                }
                else if (symbol == 'G')
                {
                    squares[index] = new Goal(this, x, y);
                }
                else if (symbol == 'W')
                {
                    squares[index] = new Wall(this, x, y);
                }
                else if (symbol == 'D')
                {
                    squares[index] = new Death(this, x, y);
                }
                else
                {
                    throw new IllegalArgumentException("There are invalid characters in " + filename);
                }
            }
        }
    }

    void loadPieces(String filename) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File(filename));

        while (s.hasNextLine())
        {
            String[] data = s.nextLine().split(" ");
            if (data.length != 3)
            {
                continue; //skip and go to next loop iteration
            }

            char symbol = data[0].charAt(0);
            int x = Integer.parseInt(data[1]);
            int y = Integer.parseInt(data[2]);

            Square square = getSquare(x, y);
            Piece piece;

            if (symbol == 'b')
            {
                piece = new Bot(square);
            }
            else if (symbol == 'i')
            {
                piece = new Item(square);
            }
            else
            {
                throw new IllegalArgumentException("Invalid symbol in piece file.");
            }

            piece.currentLocation.addPiece(piece);
        }

        s.close();
    }

    Square getSquare(int x, int y)
    {
        return squares[y * HEIGHT + x];
    }

    ///////////////////////////////////////////////////////
    // rendering methods

    void loadRenderer(BoardRenderer r)
    {
        this.renderer = r;
    }

    void render()
    {
        renderer.drawBackground();

        // tell each square to render itself
        for (Square s : squares)
        {
            s.render();
        }
    }
}
