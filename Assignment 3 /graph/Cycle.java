
/**
 * Created by thepnathi on 23/04/2018.
 */
public class Cycle extends Graph {

    public Cycle(int vertices, int defect, int trials) {
        super(vertices, defect, trials);

        setArrGraph(createGraph(vertices, defect));
        run(getArrGraph(), trials);
        System.out.println("Cycle of size " + vertices + " (" + trials + " trials) " + "with " + defect + " starting -1 values: " + getAverageSteps());
    }

    @Override
    protected int[] oneStep(int[] arr) {
        int randomInt = randomNum(arr);
        int nextIndex;
        int[] comparedArray = arr;

        // Keep generating number which is not the final index of array
        if (randomInt == (arr.length - 1)) {
            nextIndex = 0;
        } else {
            nextIndex = randomInt + 1;
        }
        // Compare the array index and the next one
        comparedArray = comparison(arr, randomInt, nextIndex);
        return comparedArray;
    }

    @Override
    public int[] createGraph(int vertice, int defact) {
        // Create an array for Cycle graph
        int[] arrGraph = super.createGraph(vertice, defact);
        arrGraph[0] = -1;

        if (defact == 2) {
            arrGraph[arrGraph.length / 2] = -1;
        }
        return arrGraph;
    }


}
