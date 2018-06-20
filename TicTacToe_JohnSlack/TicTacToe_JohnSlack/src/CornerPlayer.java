/**
*The CornerPlayer class models a Tic-Tac-Toe playing strategy in which
*open corners are taken first. If no corners are available, it selects
*randomly from among the open spaces on the board.
*
*@author John Slack
*/
public class CornerPlayer extends RandomPlayer {

	/**
	 * The constructor takes the same arguments as the RandomPlayer
	 *  constructor does, and does nothing more than invoke the
	 *   RandomPlayer constructor and pass along the arguments. 
	 *   
	 *  @param symbol  One of the player constants from the Board class (Board.X or Board.O).
	 *  @param name  The player's name.
	 */ 
	public CornerPlayer(int symbol, String name) {
		super(symbol, name);
		}//CornerPlayer Constructor


	/**
	 * makeMove looks first for unfilled corner positions on the board.
	 * 
	 * @param theBoard  The board on which we're to make a move.
	 * 
	 * @throws IllegalArgumentException  If the board is full.
	 */
	public void makeMove(Board theBoard)
	{
		int col; //int to represent column (0-2)
		int row; //int to represent row (0-2)
		int cornerSwitchInt; //int to iterate through switch for the corner positions
		int noncornerSwitchInt; //int to iterate through switch for the noncorner positions
		int[] noncornerPositions;

		col = 0; //Bottom Left Corner
		row = 0;
		
		cornerSwitchInt = 1;
		noncornerPositions = new int[] {1,2,3,4,5};

		//Throw IllegalArgumentException if board is full
		if(theBoard.boardFilled() == true)
		{
			System.out.println(name + " has lost.");
			throw new IllegalArgumentException("Board is full." + "\n" + name + " has lost");
		}

		while(theBoard.isOpen(col, row) == false)
		{
			//Plays the corner positions
			switch (cornerSwitchInt) {
				case 1: col = 2; //Bottom Right Corner
						row = 0;
						break;
				case 2: col = 0; //Top Left Corner
						row = 2;
						break;
				case 3: col = 2; //Top Right Corner
						row = 2;
						break;
				default: break;
			}//corner switch

			if(cornerSwitchInt < 4)
			{
			cornerSwitchInt = cornerSwitchInt + 1;
			} else
			{
				noncornerSwitchInt = noncornerPositions[(int)(Math.random() * noncornerPositions.length)];
				
				////Plays the noncorner positions
				switch (noncornerSwitchInt) {
					case 1: col = 1; //Bottom Middle
							row = 0;
							break;
					case 2: col = 0; //Left Middle
							row = 1;
							break;
					case 3: col = 1; //Center
							row = 1;
							break;
					case 4: col = 2; //Right Middle
							row = 1;
							break;
					case 5: col = 1; //Top Middle
							row = 2;
							break;
					default: break;
				}//non-corner switch
			}//else
		}//while loop

		theBoard.fillPosition(col, row, symbol);

	}//makeMove(Board theBoard)



}//CornerPlayer
