
/**
 * Created by thepnathi on 06/03/2018.
 */

public interface PackageType {
    // Attributes and the values for each packages
    // Package cost
    double bronzePackageCost = 36.00;
    double silverPackageCost = 46.00;
    double goldPackageCost = 61.00;

    // Phone day rate cost
    double bronzeDayRate = 0.12;
    double silverDayRate = 0.12;
    double goldDayRate = 0.0;

    // Evening rates cost
    double bronzeNightRate = 0.05;
    double silverNightRate = 0.00;
    double goldNightRate = 0.00;

    // Number of channels package provides
    int bronzeTVChannels = 60;
    int silverTVChannels = 130;
    int goldTVChannels = 230;

    // Broadband provided by package
    int bronzeBroadband = 500;
    int silverBroadband = 1000;
    int goldBroadband = 1520;

    // Broadband over limit rate
    double bronzeBroadbandRate = 0.02;
    double silverBroadbandRate = 0.01;
    double goldBroadbandRate = 0.01;

    // Additional features
    String spotify = "Spotify Account provided";
    String spotifyAndMusicOnDemand = "Spotify Account provided \nMusic on Demand provided";


}
