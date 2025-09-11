import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 * <p>
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
        // Create and initialize array to keep track of count
        int[] count = new int[boardsize + 1];
        // Go until no solution
        while (!queue.isEmpty()) {
            current = queue.remove();
            // If at the end return the amount of moves
            if (current == boardsize) {
                return count[current];
            } else {
                // Go through 1-6 dice rolls
                for (int i = 1; i <= MAX_MOVE; i++) {
                    int next = current + i;
                    // If you roll past the end it doesn't count
                    if (next > boardsize) {
                        continue;
                    }
                    // Change it to the actual value on the map for snakes and ladders
                    next = map[next];
                    // If we haven't visited it then we add it to the queue and update the count in that spot
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                        count[next] = count[current] + 1;
                    }
                }
            }
        }
        // Return -1 if impossible
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
