import java.util.Scanner;

/**
 * Created by thepnathi on 06/03/2018.
 */
public class AccountUser {
    private int dayTimeMinutes, nightAndWeekendMinutes, broadbandUsage, userInput;
    private double bronzeTotal, silverTotal, goldTotal;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        AccountUser first = new AccountUser();
        BronzeAccount bronzeFirst = new BronzeAccount(first.getDayTimeMinutes(), first.getNightAndWeekendMinutes(), first.getBroadbandUsage());
        SilverAccount silverFirst = new SilverAccount(first.getDayTimeMinutes(), first.getNightAndWeekendMinutes(), first.getBroadbandUsage());
        GoldAccount goldFirst = new GoldAccount(first.getDayTimeMinutes(), first.getNightAndWeekendMinutes(), first.getBroadbandUsage());

    }

    public AccountUser() {
        userInputDay();
        userInputNight();
        userInputBroadband();
        System.out.println("");
        bestPackage(getDayTimeMinutes(), getNightAndWeekendMinutes(), getBroadbandUsage());

    }

    // Find out the best package by pick the one with the cheapest total value
    public void bestPackage(double userDayMin, double userNightMin, double userMbUsage) {

        if (userMbUsage < BronzeAccount.bronzeBroadband) {
            bronzeTotal = BronzeAccount.bronzePackageCost + (BronzeAccount.bronzeDayRate * userDayMin)
                    + (BronzeAccount.bronzeNightRate * userNightMin);
        } else {
            bronzeTotal = BronzeAccount.bronzePackageCost + (BronzeAccount.bronzeDayRate * userDayMin)
                    + (BronzeAccount.bronzeNightRate * userNightMin)
                    + ((userMbUsage - BronzeAccount.bronzeBroadband) * BronzeAccount.bronzeBroadbandRate);

        }

        if (userMbUsage < SilverAccount.silverBroadband) {
            silverTotal = SilverAccount.silverPackageCost + (SilverAccount.silverDayRate * userDayMin)
                    + (SilverAccount.silverNightRate * userNightMin);
        } else {
            silverTotal = SilverAccount.silverPackageCost + (SilverAccount.silverDayRate * userDayMin)
                    + (SilverAccount.silverNightRate * userNightMin)
                    + ((userMbUsage - SilverAccount.silverBroadband) * SilverAccount.silverBroadbandRate);

        }

        if (userMbUsage < GoldAccount.goldBroadband) {
            goldTotal = GoldAccount.goldPackageCost + (GoldAccount.goldDayRate * userDayMin)
                    + (GoldAccount.goldNightRate * userNightMin);
        } else {
            goldTotal = GoldAccount.goldPackageCost + (GoldAccount.goldDayRate * userDayMin)
                    + (GoldAccount.goldNightRate * userNightMin)
                    + ((userMbUsage - GoldAccount.goldBroadband) * GoldAccount.goldBroadbandRate);
        }

        System.out.println("Bronze total: " + bronzeTotal + " Silver total: " + silverTotal + " Gold total: " + goldTotal);
        System.out.println("");

        if (bronzeTotal == silverTotal) {
            System.out.println("Bronze and Silver Account are the cheapest cost.");
        } else if (bronzeTotal == goldTotal) {
            System.out.println("Bronze and Gold Account are the cheapest cost.");
        } else if (silverTotal == goldTotal) {
            System.out.println("Silver and Gold Account are the cheapest cost.");
        } else if ((bronzeTotal < silverTotal) && (bronzeTotal < goldTotal)) {
            System.out.println("Bronze Account is the cheapest cost.");
        } else if ((silverTotal < bronzeTotal) && (silverTotal < goldTotal)) {
            System.out.println("Silver Account is the cheapest cost.");
        } else if ((goldTotal < bronzeTotal) && (goldTotal < silverTotal)) {
            System.out.println("Gold Account is the cheapest cost.");
        } else {
            System.out.println("All packages costs the same.");
        }
    }

    // User input data for how much day time minutes they use
    public void userInputDay() {
        System.out.print("Please enter the number minutes used per month: ");
        userInput = input.nextInt();
        if (userInput < 0) {
            userInputDay();
        } else {
            setDayTimeMinutes(userInput);
        }
    }

    public void userInputNight() {
        System.out.print("Please enter the number of nighttime minutes used per month: ");
        userInput = input.nextInt();
        if (userInput < 0) {
            userInputNight();
        } else {
            setNightAndWeekendMinutes(userInput);
        }
    }

    public void userInputBroadband() {
        System.out.print("Please enter the number of Megabytes used per month: ");
        userInput = input.nextInt();
        if (userInput < 0) {
            userInputBroadband();
        } else {
            setBroadbandUsage(userInput);
        }
    }


    public void setDayTimeMinutes(int dayTimeMinutes) {
        this.dayTimeMinutes = dayTimeMinutes;
    }

    public void setNightAndWeekendMinutes(int nightAndWeekendMinutes) {
        this.nightAndWeekendMinutes = nightAndWeekendMinutes;
    }

    public void setBroadbandUsage(int broadbandUsage) {
        this.broadbandUsage = broadbandUsage;
    }

    public int getDayTimeMinutes() {
        return dayTimeMinutes;
    }

    public int getNightAndWeekendMinutes() {
        return nightAndWeekendMinutes;
    }

    public int getBroadbandUsage() {
        return broadbandUsage;
    }
}
