
/**
 * Created by thepnathi on 06/03/2018.
 */
public class SilverAccount extends StandardAccount implements PackageType {

    public SilverAccount(int dayMin, int nightMin, int Mb) {
        accountInfo(dayMin, nightMin, Mb);
    }

    // Getters for retrieving the values for each package
    @Override
    protected String accountType() {
        return "Silver";
    }

    @Override
    protected double getPackageCost() {
        return silverPackageCost;
    }

    @Override
    protected double getDayRate() {
        return silverDayRate;
    }

    @Override
    protected double getNightRate() {
        return silverNightRate;
    }

    @Override
    protected int getNumTVChannels() {
        return silverTVChannels;
    }

    @Override
    protected int getBroadband() {
        return silverBroadband;
    }

    @Override
    protected double getBroadbandRate() {
        return silverBroadbandRate;
    }

    @Override
    protected String getExtraFeatures() {
        return spotify;
    }

    @Override
    public void accountInfo(int userDayMin, int userNightMin, int userMb) {
        super.accountInfo(userDayMin, userNightMin, userMb);
    }

    @Override
    public double totalCost(double packageCost, double dayRate, double nigthRate, double broadRate) {
        return super.totalCost(packageCost, dayRate, nigthRate, broadRate);
    }
}
