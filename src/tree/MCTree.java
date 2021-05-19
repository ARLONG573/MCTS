package tree;

import api.GameState;

/**
 * This class stores the tree structure and performs the tree search.
 * 
 * @author Aaron Tetens
 */
public class MCTree {

	private final MCNode root;
	private final int numIterations;

	public MCTree(final GameState initialState, final int numIterations) {
		this.root = new MCNode(initialState, null);
		this.numIterations = numIterations;
	}

	/**
	 * Perform MCTS from the root node. The number of iterations that are executed
	 * depends on the value given when this MCTree was created.
	 * 
	 * @return The GameState that is the result of performing the move suggested by
	 *         the search.
	 */
	public GameState search() {
		return null;
	}
}
