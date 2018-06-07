
/**
 * Created by thepnathi on 06/03/2018.
 */
public class GoldAccount extends StandardAccount implements PackageType {

    public GoldAccount(int dayMin, int nightMin, int Mb) {
        accountInfo(dayMin, nightMin, Mb);
    }

    // Getters for retrieving the values for each package
    @Override
    protected String accountType() {
        return "Gold";
    }

    @Override
    protected double getPackageCost() {
        return goldPackageCost;
    }

    @Override
    protected double getDayRate() {
        return goldDayRate;
    }

    @Override
    protected double getNightRate() {
        return goldNightRate;
    }

    @Override
    protected int getNumTVChannels() {
        return goldTVChannels;
    }

    @Override
    protected int getBroadband() {
        return goldBroadband;
    }

    @Override
    protected double getBroadbandRate() {
        return goldBroadbandRate;
    }

    @Override
    protected String getExtraFeatures() {
        return spotifyAndMusicOnDemand;
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
