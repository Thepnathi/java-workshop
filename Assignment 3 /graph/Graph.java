
import java.util.stream.IntStream;
/**
 * Created by thepnathi on 23/04/2018.
 */
public abstract class Graph {

    protected int vertices;
    protected int trials;
    protected int defect;
    protected double averageSteps;
    protected int steps = 0;
    protected int[] arrGraph = new int[vertices];
    protected abstract int[] oneStep(int[] arr);

    // Takes in the input and store it in this object
    public Graph(int vertices, int defect, int trials) {
        this.vertices = vertices;
        this.defect = defect;
        this.trials = trials;
    }

    // Execute and calculate number of times it takes for each
    // graph to have all 1s. Will repeat depending on trials and
    // calculate the average at the end
    public double run(int[] arr, int trials) {
        // clone the original array so it can be use again
        int[] originalArr = arr.clone();

          // repeat for each trials
         for (int i = 1; i <= trials; i++) {

            // Loop will execute if -1 exists in the loop
             while (IntStream.of(arr).anyMatch(x -> x == -1)) {
                 steps++;
                 oneStep(arr);
             }
             averageSteps += steps;
             steps = 0;
             // Put the original array backinto the main array
             arr = originalArr.clone();
         }
        return averageSteps = averageSteps / trials;
    }

    // The method takes in an array to be compared. The person interacts with the next
    // It will take an index and the next index
    // output the changed array index * next index
    public int[] comparison(int[] arr, int index, int nextIndex) {
        int[] newArr = arr;
        int tempValue = newArr[index];
        // Always compare to the right of the index
        newArr[index] = newArr[index] * newArr[nextIndex];
        newArr[nextIndex] = tempValue * newArr[nextIndex];
        return newArr;
    }

    // Create a default graph
    public int[] createGraph(int vertice, int defect) {
        int[] newGraph = new int[vertice];

        for (int i= 0; i < newGraph.length; i++) {
          // put 1 in all index
            newGraph[i] = 1;
        }
        return newGraph;
    }

    // Generate random number depedning on the vertices
    public int randomNum(int[] arr) {
        return (int) (Math.random() * arr.length);
    }

    public void printArrayGraph(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("("+ arr[i] + ") ");
        }
        System.out.println();
    }

    public int[] getArrGraph() {
        return arrGraph;
    }

    public void setArrGraph(int[] arrGraph) {
        this.arrGraph = arrGraph;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getAverageSteps() {
        return averageSteps;
    }
}
