/**
 * The RandomPlayer class models a Tic-Tac-Toe playing strategy 
 * in which moves are selected randomly from the open spaces on the board.
 * 
 * @author John Slack
 */
public class RandomPlayer extends Player {

	/**
	 * The constructor takes the same arguments as the Player constructor does. 
	 * It invokes the Player constructor, passing along the arguments, then creates our 
	 * random-number generator.
	 * 
	 * @param symbol  One of the player constants from the Board class (Board.X or Board.O).
	 * @param name  The player's name.
	 */
	public RandomPlayer(int symbol, String name)
	{
		super(symbol, name);
	}

	/**
	 *makeMove selects randomly from among the open positions on the board. 
	 *If no spaces are open, it throws an IllegalArgumentException
	 * 
	 * @param theBoard  The board on which we're to make a move.
	 * 
	 * @throws IllegalArgumentException  If the board is full.
	 */
	public void makeMove(Board theBoard)
	{
		int row; //int to represent row (0-2)
		int col; //int to represent column (0-2)
		int switchInt;
		int[] positions;

		positions = new int[]{1,2,3,4,5,6,7,8,9};

		switchInt = (int)(Math.random() * positions.length);

		//Random Starting Position
		col = (int) (Math.random() * 2); 
		row = (int) (Math.random() * 2);

		//Throw IllegalArgumentException if board is full
		if(theBoard.boardFilled() == true)
		{
			System.out.println(name + " has lost.");
			throw new IllegalArgumentException("Board is full.");
		}

		//Randomly selects from all postions
		while(theBoard.isOpen(col, row) == false)
		{
			switch (switchInt)
						{	
							case 1: col = 0; //Bottom Left Corner
									row = 0;
									break;
							case 2: col = 1; //Bottom Middle
									row = 0;
									break;
							case 3: col = 2; //Bottom right Corner
									row = 0;
									break;
							case 4: col = 0; //Left Middle
									row = 1;
									break;
							case 5: col = 1; //Center
									row = 1;
									break;
							case 6: col = 2; //Right Middle
									row = 1;
									break;
							case 7: col = 0; //Top Left Corner
									row = 2;
									break;
							case 8: col = 1; //Top Middle
									row = 2;
									break;
							case 9: col = 2; //Top Right Corner
									row = 2;
									break;
							default: break;
			}//switch
		
			switchInt = (int)(Math.random() * positions.length);
			
		}//while loop

		theBoard.fillPosition(col, row, symbol);


	}//makeMove(Board theBoard)


}//Class RandomPlayer
