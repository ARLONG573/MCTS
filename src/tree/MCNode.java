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
}
