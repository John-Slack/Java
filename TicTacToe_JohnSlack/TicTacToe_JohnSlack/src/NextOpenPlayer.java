/**
 * The NextOpenPlayer class models a Tic-Tac-Toe playing strategy 
 * in which the first open space is selected on each move, starting 
 * at the top left corner and searching the top row first, then the 
 * middle, and finally the bottom row. If no open positions are 
 * found, no move is made.
 * 
 * @author John Slack
 * 
 */
public class NextOpenPlayer extends Player
{

	/**
	 * The constructor takes the same arguments as the Player 
	 * constructor does, and does nothing more than invoke the Player 
	 * constructor and pass along the arguments.
	 * 
	 * @param symbol  One of the player constants from the Board class (Board.X or Board.O).
	 * @param name  The player's name.
	 */
	public NextOpenPlayer(int symbol, String name)
	{
		super(symbol, name);
	}//NextOpenPlayer Constructor

	/**
	 * makeMove selects the first open space it encounters. 
	 * It searches the board from the top left corner, and 
	 * looks left-to-right through the first row, then the 
	 * middle, and finally the third row. If no open positions are 
	 * found, no move is made.
	 * 
	 * @param theBoard  The board on which we're to make a move.
	 * 
	 * @throws IllegalArgumentException  If the board is full.
	 */
	public void makeMove(Board theBoard)
	{
		int col; //int to represent column (0-2)
		int row; //int to represent row (0-2)
		int switchInt;


		col = 0; //Top Left Corner
		row = 2;
		
		switchInt = 0;
		
		//Throw IllegalArgumentException if board is full
		if(theBoard.boardFilled() == true)
		{
			System.out.println(name + " has lost.");
			throw new IllegalArgumentException("Board is full." + "\n" + name + " has lost");
		}
		
		//Checks each case in order to find next open position
		while(theBoard.isOpen(col, row) == false)
		{
			switch (switchInt)
			{
				case 1: col = 1; //Top Middle
						row = 2;
						break;
				case 2: col = 2; //Top Right Corner
						row = 2;
						break;
				case 3: col = 0; //Left Middle
						row = 1;
						break;
				case 4: col = 1; //Center
						row = 1;
						break;
				case 5: col = 2; //Right Middle
						row = 1;
						break;
				case 6: col = 0; //Bottom Left Corner
						row = 0;
						break;
				case 7: col = 1; //Bottom Middle
						row = 0;
						break;
				case 8: col = 2; //Bottom right Corner
						row = 0;
						break;
				default: break;
			}//switch
			
			switchInt = switchInt + 1;
			
		}//while loop
		
		theBoard.fillPosition(col, row, symbol);
		
	}//makeMove(Board theBoard)
	
}//Class NextOpenPlayer
