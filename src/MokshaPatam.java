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

    private static int[] board;
    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        board = new int[boardsize + 1];
        for (int i = 1; i < board.length; i++) {
                board[i] = i;
        }
        addThings(ladders);
        addThings(snakes);
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[boardsize + 1];
        int current = START;
        queue.add(current);
        visited[START] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current == boardsize) {
                return count;
            }
            else {
                for (int i = 1; i <= MAX_MOVE; i++) {
                    int next = current + i;
                    if (next > boardsize) {
                        continue;
                    }
                    next = board[next];
                    if (!visited[next]) {
                        queue.add(board[current + i]);
                        visited[next] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public static void addThings(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int start = array[i][0];
            int end = array[i][1];
            board[start] = end;
        }
    }
}
