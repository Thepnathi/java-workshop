
/**
 * Created by thepnathi on 23/04/2018.
 */
public class Path extends Graph {


    public Path(int vertices, int defect, int trials) {
        super(vertices, defect, trials);

        // Create the graph
        setArrGraph(createGraph(vertices, defect));
        run(getArrGraph(), trials);
        System.out.println("Path of size " + vertices + " (" + trials + " trials) " + "with " + defect + " starting -1 values: " + getAverageSteps());

    }

    @Override
    protected int[] oneStep(int[] arr) {
        int randomInt = randomNum(arr);
        int[] comparedArray = arr;
        // Keep generating number which is not the final index of array
        // Last person in Path graph cannot interact with the next person since theres none
        while (randomInt == (arr.length - 1)) {
            randomInt = randomNum(arr);
        }
        // Compare the array index and the next one
        comparedArray = comparison(arr, randomInt, randomInt + 1);
        return comparedArray;
    }

    @Override
    public int[] createGraph(int vertice, int defact) {
        // Create a graph for Path graph
        int[] arrGraph = super.createGraph(vertice, defact);
        arrGraph[arrGraph.length -1] = -1;

        if (defact == 2) {
            arrGraph[0] = -1;
        }
        return arrGraph;
    }

    @Override
    public int randomNum(int[] arr) {
        return super.randomNum(arr);
    }
}
