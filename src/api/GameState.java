package api;

/**
 * Any game that wishes to use this MCTS implementation must implement its game
 * state in this way so that the operations necessary for the search may be
 * carried out.
 * 
 * @author Aaron Tetens
 */
public interface GameState {

	/**
	 * @return The id of the player who made the move to achieve this game state
	 */
	public int getLastPlayer();
}
