/*The N-Queens problem is a classic puzzle in which the goal is to place N queens on an N x N chessboard such that no two queens threaten each other. A queen can attack another queen if they are in the same row, column, or diagonal.

The task is to find one valid solution (or determine that no solution exists) where N queens are placed on the chessboard in such a way that none of them can attack each other. The program should explore potential solutions efficiently using an A algorithm*, which prioritizes states (configurations) with fewer conflicts (attacks between queens). */
import java.util.*;

public class AStar4Queens {

    static class State {
        int[] positions;  // Array to store the positions of the queens
        int conflicts;    // Number of conflicts (where queens can attack each other)

        State(int[] positions) {
            this.positions = positions;  // Initialize the positions array
            this.conflicts = calculateConflicts(positions);  // Calculate the number of conflicts
        }

        // Method to calculate the number of conflicts between queens
        public int calculateConflicts(int[] positions) {
            int conflicts = 0;
            for (int i = 0; i < positions.length; i++) {
                for (int j = i + 1; j < positions.length; j++) {
                    // Check if two queens are on the same column or in diagonal conflict
                    if (positions[i] == positions[j] || Math.abs(positions[i] - positions[j]) == Math.abs(i - j)) {
                        conflicts++;
                    }
                }
            }
            return conflicts;  // Return the number of conflicts
        }

        // Method to check if the current state is a solution (i.e., no conflicts)
        public boolean isSolution() {
            return conflicts == 0;  // A solution is found when there are no conflicts
        }

        // Override toString() to represent the state as a string
        @Override
        public String toString() {
            return Arrays.toString(positions);
        }
    }

    // Method to solve the 4-Queens problem using the A* algorithm
    public static State solve4Queens(int n) {
        int[] initialPositions = new int[n];  // Array to store the initial positions of the queens
        for (int i = 0; i < n; i++) {
            initialPositions[i] = i;  // Initial positions place queens in each row, one per column
        }

        State initialState = new State(initialPositions);  // Create the initial state
        PriorityQueue<State> openSet = new PriorityQueue<>(Comparator.comparingInt(state -> state.conflicts));  // Priority queue for states, ordered by the number of conflicts
        Set<String> exploredSet = new HashSet<>();  // Set to keep track of explored states

        openSet.add(initialState);  // Add the initial state to the open set

        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();  // Get the state with the least conflicts

            if (currentState.isSolution()) {
                return currentState;  // If we found a solution, return the current state
            }

            // Generate neighbors (states that differ by one queen's position)
            for (State neighbor : generateNeighbors(currentState)) {
                if (!exploredSet.contains(Arrays.toString(neighbor.positions))) {
                    openSet.add(neighbor);  // Add the neighbor to the open set
                    exploredSet.add(Arrays.toString(neighbor.positions));  // Mark the neighbor as explored
                }
            }
        }

        return null;  // If no solution is found, return null
    }

    // Method to generate neighbors (states) by moving each queen to another position in its column
    public static List<State> generateNeighbors(State state) {
        List<State> neighbors = new ArrayList<>();  // List to store the neighboring states
        int n = state.positions.length;

        // For each column (i.e., each queen), generate a new state where the queen is placed in a different row
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                if (row != state.positions[col]) {  // Skip the current position of the queen
                    int[] newPosition = state.positions.clone();  // Create a copy of the current positions array
                    newPosition[col] = row;  // Move the queen to the new row in the same column
                    neighbors.add(new State(newPosition));  // Add the new state to the list of neighbors
                }
            }
        }

        return neighbors;  // Return the list of generated neighbors
    }

    // Main method to execute the solution
    public static void main(String[] args) {
        int n = 4;  // Number of queens (and the size of the board)
        State solution = solve4Queens(n);  // Call the method to solve the problem

        if (solution != null) {
            System.out.println("Solution found:");
            System.out.println(solution);  // Print the solution (positions of the queens)

            System.out.println("\nInterpreting the solution:");
            System.out.println("Each number in the solution represents the position of a queen on the board.");
            System.out.println("The board consists of " + n + " columns and " + n + " rows.");
            System.out.println("Example:");
            // Print the detailed position of each queen on the board
            for (int i = 0; i < solution.positions.length; i++) {
                System.out.println("Queen " + (i + 1) + " is placed on row " + (solution.positions[i] + 1) + ", column " + (i + 1));
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
