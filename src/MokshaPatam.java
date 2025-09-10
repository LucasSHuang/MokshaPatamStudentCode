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

    private static int[] map;
    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        // Create a "map" for all the values on the board
        map = new int[boardsize + 1];
        for (int i = 1; i < map.length; i++) {
                map[i] = i;
        }
        // Add all the snakes and ladders onto the board
        addThings(ladders);
        addThings(snakes);
        // Create and initialize queue
        Queue<Integer> queue = new LinkedList<Integer>();
        // Create boolean array to check visited spots
        boolean[] visited = new boolean[boardsize + 1];
        // Initialize variable to keep track of spot on board
        int current = START;
        queue.add(current);
        visited[START] = true;
        //
        int[] count = new int[boardsize + 1];
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current == boardsize) {
                return count[current];
            }
            else {
                for (int i = 1; i <= MAX_MOVE; i++) {
                    int next = current + i;
                    if (next > boardsize) {
                        continue;
                    }
                    next = map[next];
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                        count[next] = count[current] + 1;
                    }
                }
            }
        }
        return -1;
    }

    // Adds snakes and ladders
    public static void addThings(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            // Get the starting value of the snake or ladder
            int start = array[i][0];
            // Get the end of the snake or ladder
            int end = array[i][1];
            // Replace the start value with the end value on the map
            map[start] = end;
        }
    }
}
