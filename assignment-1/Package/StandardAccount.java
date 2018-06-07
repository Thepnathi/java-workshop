
/**
 * Created by thepnathi on 06/03/2018.
 */
public abstract class StandardAccount {

    // Blueprints to retrieve the information for package type
    // getter for grabbing the values from the interface class - PackageType
    // Assign the values to the correct package type
    protected abstract String accountType();
    protected abstract double getPackageCost();
    protected abstract double getDayRate();
    protected abstract double getNightRate();
    protected abstract int getNumTVChannels();
    protected abstract int getBroadband();
    protected abstract double getBroadbandRate();
    protected abstract String getExtraFeatures();

    // Display individual package info to user + their rate with that package
    public void accountInfo(int userDayMin, int userNightMin, int userMb) {

        System.out.println("");
        System.out.println("Account Summary for " + accountType()  + " Accounts");
        System.out.println("Package Cost: " + getPackageCost());
        System.out.println("Cost of daytime calls: " + getDayRate() + "/min");
        System.out.println("Cost of evening and weekend calls: " + getNightRate() + "/min");
        System.out.println("Number of Channels: " + getNumTVChannels());
        System.out.println("Broadband included: " + getBroadband() + "Mb");
        System.out.println("Broadband Cost (above inlcuded limit): " + getBroadbandRate() + "/Mb");
        System.out.println("Total daytime calls cost: " + getDayRate() * userDayMin);
        System.out.println("Total evening calls cost: " + getNightRate() * userNightMin);

        // Determine if the user uses all the Broadband, otherwise no extra charge
        if (userMb < getBroadband()) {
            System.out.println("Total (extra) broadband cost: " + 0.00);
            System.out.println("Total cost: " + totalCost(getPackageCost(), getDayRate() * userDayMin, getNightRate() * userNightMin, 0.00));
        } else {
            System.out.println("Total (extra) broadband cost: " + (userMb - getBroadband()) * getBroadbandRate());
            System.out.println("Total cost: " + totalCost(getPackageCost(), getDayRate() * userDayMin, getNightRate() * userNightMin, (userMb - getBroadband()) * getBroadbandRate()));
        }

        // Display extra features if exist
        if (getExtraFeatures() != null) {
            System.out.println(getExtraFeatures());
        }
        System.out.println("");
    }

    // Calculate totalCost - sum of the
    public double totalCost(double packageCost, double dayRate, double nigthRate, double broadRate) {
        double total = packageCost + dayRate + nigthRate + broadRate;
        return total;
//        System.out.println("Total cost: " + total);
    }



}
