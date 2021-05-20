package tree;

import java.util.ArrayList;
import java.util.List;

import api.GameState;

/**
 * This class represents a node within the MCTree. A node stores the game state
 * that it represents, as well as the number of wins found on it (for
 * exploitation), the number of iterations run on it (for exploration), and its
 * parent (for backpropogation).
 * 
 * @author Aaron Tetens
 */
class MCNode {

	private final GameState gameState;
	private final MCNode parent;
	private final List<MCNode> children;

	private int numWins;
	private int numIterations;

	MCNode(final GameState gameState, final MCNode parent) {
		this.gameState = gameState;
		this.parent = parent;
		this.children = new ArrayList<>();
		this.numWins = 0;
		this.numIterations = 0;
	}

	/**
	 * This method adds a child node for each possible next game state.
	 */
	void expand() {
		// TODO
	}

	/**
	 * @return A random child node
	 */
	MCNode getRandomChild() {
		final int randomIndex = (int) (Math.random() * this.children.size());
		return this.children.get(randomIndex);
	}

	/**
	 * @return An integer representing the player who won the random playout
	 */
	int simulate() {
		// TODO
		return 0;
	}

	/**
	 * Adds the result of the simulation to this node. The result represents the
	 * winner of the simulation, so numWins is incremented if the result is equal to
	 * the player who made the move to achieve the game state that this node
	 * represents.
	 * 
	 * @param result
	 *            The result of the simulation.
	 */
	void addResult(final int result) {
		if (result == this.gameState.getLastPlayer()) {
			this.numWins++;
		}

		this.numIterations++;
	}

	/**
	 * @return The parent of this node
	 */
	MCNode getParent() {
		return this.parent;
	}

	/**
	 * @return A list of the child nodes of this node
	 */
	List<MCNode> getChildren() {
		return this.children;
	}

	/**
	 * @return The number of wins that have passed through this node
	 */
	int getNumWins() {
		return this.numWins;
	}

	/**
	 * @return The number of iterations that have passed through this node
	 */
	int getNumIterations() {
		return this.numIterations;
	}

	/**
	 * @return The game state that this node represents
	 */
	GameState getGameState() {
		return this.gameState;
	}
}
