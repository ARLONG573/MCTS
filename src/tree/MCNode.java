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

	private double numWins; // numWins is a double to keep track of winning ties with other players
	private int numIterations;

	MCNode(final GameState gameState, final MCNode parent) {
		this.gameState = gameState;
		this.parent = parent;
		this.children = new ArrayList<>();
		this.numWins = 0.0;
		this.numIterations = 0;
	}

	/**
	 * This method adds a child node for each possible next game state.
	 */
	void expand() throws IllegalStateException {
		if (!this.children.isEmpty()) {
			throw new IllegalStateException("Tried to expand a non-leaf node!");
		}

		final List<GameState> nextStates = this.gameState.getNextStates();

		for (final GameState nextState : nextStates) {
			this.children.add(new MCNode(nextState, this));
		}
	}

	/**
	 * @return A random child node
	 */
	MCNode getRandomChild() {
		final int randomIndex = (int) (Math.random() * this.children.size());
		return this.children.get(randomIndex);
	}

	/**
	 * @return A list of integers representing the players who won the random
	 *         playout
	 */
	List<Integer> simulate() {
		GameState curr = this.gameState;

		// while no one has won, pick a random next possible state
		while (curr.getWinningPlayers().isEmpty()) {
			final List<GameState> nextStates = curr.getNextStates();

			final int randomIndex = (int) (Math.random() * nextStates.size());
			curr = nextStates.get(randomIndex);
		}

		return curr.getWinningPlayers();
	}

	/**
	 * Adds the result of the simulation to this node. The result represents the
	 * winners of the simulation, so numWins is incremented if the result contains
	 * the player who made the move to achieve the game state that this node
	 * represents. The point for a win is split evenly among any tying winners.
	 * 
	 * @param result
	 *            The result of the simulation.
	 */
	void addResult(final List<Integer> result) {
		if (result.contains(this.gameState.getLastPlayer())) {
			this.numWins += (1.0 / result.size());
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
	double getNumWins() {
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
