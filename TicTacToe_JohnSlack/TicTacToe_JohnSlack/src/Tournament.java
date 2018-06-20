/**
*The Tournament class provides a static method for playing a game of 
*Tic-Tac-Toe between two player instances. Its also contains a main method 
*that plays two (or more) games to determine which of the three Player 
*subclasses wins overall.
*
*@author John Slack
*/
public class Tournament
{
	/**
	* Empty Constructor for Tournament
	*/
	public Tournament() {}

	/**
	 * The main method sets up a mini-tournament between the three Player subclasses. 
	 * It plays games between instances of RandomPlayer and NextOpenPlayer until 
	 * there's a winner, then plays a final game between the winner of that match 
	 * and a CornerPlayer.
	 */
	public static void main(String[] args)
	{
		RandomPlayer randomPlayer;
		CornerPlayer cornerPlayer;
		NextOpenPlayer nextOpenPlayer;
		Player winner;
		Player champion;

		randomPlayer = new RandomPlayer(Board.O,"Random Guy");
		cornerPlayer = new CornerPlayer(Board.O,"Corner Guy");
		nextOpenPlayer = new NextOpenPlayer(Board.X,"Next Guy");
		winner = null;
		champion = null;


		while(winner == null)
		{
			winner = playGame(nextOpenPlayer, randomPlayer);
		}
		while(champion == null)
		{
			champion = playGame(winner, cornerPlayer);
		}
	}//main(String[] args)

	/**
	 *The playGame method plays a single game between the two player instances 
	 *passed as parameters. It returns the winning player, or null if the game ends 
	 *in a draw. If a player throws an exception during play, it is disqualified 
	 *and its opponent wins.
	 *
	 *
	 * @param playerX  The player instance playing as X.
	 * @param playerO  The player instance playing as O.
	 * 
	 * @return  The winning player, or null if it's a draw.
	 */
	public static Player playGame(Player playerX, Player playerO)
	{
		Board board;

		board = new Board();
		
		//Sets Player Symbols
		playerX.setSymbol(Board.X);
		playerO.setSymbol(Board.O);
		
		try
		{	//Play while the board is not full and there is no winner
			while(board.boardFilled() == false && board.getWinner() == -1)
			{
				playerX.makeMove(board);
				System.out.println(board.toString());
				
				//X Wins
				if(board.getWinner() == Board.X)
				{

					System.out.println(playerX.name + " (X)" + " says: " + playerX.celebrate());
					System.out.println(playerO.name + " (O)" + " says: " + playerO.mourn());
					return playerX;
				}//X wins
				
				//Game is a Draw if board is full and there is no winner
				if(board.boardFilled() == true && board.getWinner() == -1)
				{
					System.out.println("We have Draw. Play Again.");
					return null;
				}//Draw
				
				playerO.makeMove(board);
				System.out.println(board.toString());
				
				//O Wins
				if(board.getWinner() == Board.O)
				{

					System.out.println(playerO.name + " (O)" + " says: " + playerO.celebrate());
					System.out.println(playerX.name + " (X)" + " says: " + playerX.mourn());
					return playerO;
				}//O wins
				
				//Game is a Draw if board is full and there is no winner
				if(board.boardFilled() == true && board.getWinner() == -1)
				{
					System.out.println("We have Draw. Play Again.");
					return null;
				}//Draw
				
			}//while loop

		} catch(IllegalArgumentException e)
		{
			System.out.println("Board is full and a move was attempted.");
		}//catch
		
	return null;
	
	}//playGame(Player playerX, Player playerO)

}//Class Tournament


