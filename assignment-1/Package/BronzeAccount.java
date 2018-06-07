
/**
 * Created by thepnathi on 06/03/2018.
 */
public class BronzeAccount extends StandardAccount implements PackageType {

    public BronzeAccount(int dayMin, int nightMin, int Mb) {
        accountInfo(dayMin, nightMin, Mb);
    }

    // Getters for retrieving the values for each package
    @Override
    protected String accountType() {
        return "Bronze";
    }

    @Override
    protected double getPackageCost() {
        return bronzePackageCost;
    }

    @Override
    protected double getDayRate() {
        return bronzeDayRate;
    }

    @Override
    protected double getNightRate() {
        return bronzeNightRate;
    }

    @Override
    protected int getNumTVChannels() {
        return bronzeTVChannels;
    }

    @Override
    protected int getBroadband() {
        return bronzeBroadband;
    }

    @Override
    protected double getBroadbandRate() {
        return bronzeBroadbandRate;
    }

    @Override
    protected String getExtraFeatures() {
        return null;
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
