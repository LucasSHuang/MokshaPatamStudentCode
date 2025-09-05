import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Lucas Huang
 *
 */

public class MokshaPatam {

    final static int MAX_MOVE = 6;
    final static int START = 1;
    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        int[] board = new int[boardsize + 1];
        for (int i = 1; i < board.length; i++) {
            if (ladders[i] != null) {
                board[i] = ladders[i][0];
            }
            else if (snakes[i] != null) {
                board[i] = snakes[i][0];
            }
            else {
                board[i] = i;
            }
        }
        Queue<Integer> solution = new LinkedList<Integer>();
        int current = START;

        int playerPostition = boardsize;
        int count = 0;
        while (playerPostition != START) {
            if (playerPostition <= MAX_MOVE) {
                return count + 1;
            }
            else {
                playerPostition -= MAX_MOVE;
            }
        }
        return 0;
    }
}
