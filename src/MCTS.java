import api.GameState;
import tree.MCTree;

/**
 * This is the class that drives the tree search. Classes that wish to use this
 * project's tree search will simply call {@link MCTS#search(GameState, int)} to
 * find the suggested move.
 * 
 * @author Aaron Tetens
 */
public class MCTS {

	/**
	 * This method drives the tree search operation by initializing a search tree
	 * with the given GameState and telling the tree to execute MCTS for the given
	 * number of iterations.
	 * 
	 * @param initialState
	 *            The state from which to start the search
	 * @param numIterations
	 *            The number of iterations that the search should perform
	 * @return The GameState that is the result of performing the move suggested by
	 *         the search
	 */
	public static GameState search(final GameState initialState, final int numIterations) {
		final MCTree tree = new MCTree(initialState, numIterations);
		return tree.search();
	}
}
