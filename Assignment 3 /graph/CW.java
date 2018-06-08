

public class CW {
    private double averageFloor1 = 0, averageFloor2 = 0;
    private double donAverageSteps = 0, bellaAverageSteps = 0;



    public static void main(String[] args) {


        Don don = new Don();
        Bella bella = new Bella();
        CW firstExperiment = new CW(don, bella);

    }

    public CW(Don a, Bella b) {
        averageExperiment(a, b, 2000);
        System.out.println();
        averageStepsToReachTopFloor(a, b,  2000);
        System.out.println();
        calcCoOccurences(a, b, 2000, 2000);
    }

    // NOTE: For Testing
    public void hundredSteps(Don don, Bella bella, int steps) {
            for (int i = 0; i <= steps; i++) {
                don.takeStep();
                bella.takeStep();
            }
            System.out.println(don.name() + " 100 steps: " + don.getFloor());
            System.out.println(bella.name() + " 100 steps: " + bella.getFloor());

    }


    // This method calculates the average step it takes to reach the top floor for
    // each cockroach. It can be repeated multiple times
    public void averageStepsToReachTopFloor(Don don, Bella bella, int numOfExperiments) {
        boolean donReachedTopFloor = false;
        boolean bellaReachedTopFloor = false;


        for (int exp = 1; exp <= numOfExperiments; exp++) {
            // Walk until they reached the top floor
            while (true) {
                don.takeStep();
                bella.takeStep();

                if (donReachedTopFloor == false) {
                    if (don.reachTopFloor()) {
                        donAverageSteps += don.getSteps();
                        donReachedTopFloor = true;
                    }
                }

                if (bellaReachedTopFloor == false) {
                    if (bella.reachTopFloor()) {
                        bellaAverageSteps += bella.getSteps();
                        bellaReachedTopFloor = true;
                    }
                }
                // If they both reached the top floor, the infinite loop will exit
                if (donReachedTopFloor && bellaReachedTopFloor) {
                    break;
                }

            }
            // Resets for next experiments
            don = new Don();
            bella = new Bella();
            donReachedTopFloor = false;
            bellaReachedTopFloor = false;
        }
        // average the score for both cockroaches
        donAverageSteps = donAverageSteps / numOfExperiments;
        bellaAverageSteps = bellaAverageSteps / numOfExperiments;
        System.out.println("Don: 2000 experiments, the average to reach top floor is: " + donAverageSteps);
        System.out.println("Bella: 2000 experiment, the average to reach top floor is: " + bellaAverageSteps);
    }

    // Calculates both cockroaches taking 100 steps and the average floor
    // they managed to reached
    public void averageExperiment(Don don, Bella bella, int numOfExperiments) {

        for (int i = 0; i < numOfExperiments; i++) {
            for (int j = 0; j <= 100; j++) {
                don.takeStep();
                bella.takeStep();
            }
            // Incre total sum for average
            // reset
            averageFloor1 += don.getFloor();
            averageFloor2 += bella.getFloor();
            don = new Don();
            bella = new Bella();
        }
        averageFloor1 =  (averageFloor1 / numOfExperiments);
        averageFloor2 = (averageFloor2 / numOfExperiments);

        System.out.println("Don: 2000 experiments, walking 100 steps, the maximum height achieved has average value: " + averageFloor1);
        System.out.println("Bella: 2000 experiments, walking 100 steps, the maximum height achieved has average value: " + averageFloor2);
    }

    // Calculate how many times both cockroach reached the same floor during the same step.
    // Average the score of this
    public double calcCoOccurences(Don don, Bella bella, int steps, int numOfExperiments) {
        int coOccurences = 1;
        double totalCoOccurences = 0;

        for (int i = 1; i <= numOfExperiments; i++) {
            for (int j = 1; j <= steps; j++) {
                don.takeStep();
                bella.takeStep();

                if (don.getFloor() == bella.getFloor()) {
                    coOccurences++;
                }
            }
            // reset for the next experiment
            totalCoOccurences += coOccurences;
            coOccurences = 1;
            don = new Don();
            bella = new Bella();
        }
        totalCoOccurences = totalCoOccurences / numOfExperiments;
        System.out.println("2000 experiments, and walking 2000 steps. The average co-occurence for when Don and Bella reached the same floor is " + totalCoOccurences);
        return totalCoOccurences;
    }


}
