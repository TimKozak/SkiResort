package resort;

import skipass.*;

import java.util.Scanner;

// CLASS FOR SIMULATING BEHAVIOUR OF A PROGRAMME
public class SkiResort {
    private Turnstile turnstile;
    private SkiResortSystem resort;
    private SkiPass skipass;

    public void test() {
        // Create ski resort system and turnstile
        resort = new SkiResortSystem();
        turnstile = new Turnstile();

        // Connect turnstile to system
        turnstile.connect(resort);

        // Create some SkiPasses
        SkiPass weekend2 = resort.issueSkiPass(PassType.WEEKEND_2);
        SkiPass workdays5 = resort.issueSkiPass(PassType.WORKDAYS_5);
        SkiPass workdays10 = resort.issueSkiPass(PassType.WORKDAY_LIFTS, NumOfLifts.LIFTS_10);
        SkiPass weekend10 = resort.issueSkiPass(PassType.WEEKEND_LIFTS, NumOfLifts.LIFTS_10);
        SkiPass season = resort.issueSkiPass(PassType.SEASON);

        System.out.println(resort.getSkipasses() + "\n");

        // Try to use different SkiPasses
        System.out.println("WEEKEND_2:");
        System.out.println(turnstile.allowToEnter(weekend2) + "\n");

        System.out.println("WORKDAYS_5:");
        System.out.println(turnstile.allowToEnter(workdays5) + "\n");

        // Block SkiPass and try to use it
        System.out.println("SEASON:");
        resort.blockSkiPass(season);
        System.out.println(turnstile.allowToEnter(season) + "\n");

        // Try to use SkiPass until it reaches above max of lifts
        System.out.println("WORKDAYS_10:");
        for (int i = 0; i < 1; i++) {
            turnstile.allowToEnter(workdays10);
        }
        System.out.println(turnstile.allowToEnter(workdays10) + "\n");

        System.out.println("___TEST IS OVER___");
    }

    public void skiPassShop(Scanner sc) {
        skipass = null;
        int option = 0;

        System.out.println("\n1 - Full Days SkiPass");
        System.out.println("2 - Lift Times SkiPass");
        System.out.println("3 - Season SkiPass\n");

        option = sc.nextInt();

        switch(option) {
            case 1:
                System.out.println("\n1 - Workdays 1");
                System.out.println("2 - Workdays 2");
                System.out.println("3 - Workdays 5");
                System.out.println("4 - Weekend 1");
                System.out.println("5 - Weekend 2\n");

                int choice = sc.nextInt();

                switch(choice) {
                    case 1:
                        skipass = resort.issueSkiPass(PassType.WORKDAYS_1);
                        break;
                    case 2:
                        skipass = resort.issueSkiPass(PassType.WORKDAYS_2);
                        break;
                    case 3:
                        skipass = resort.issueSkiPass(PassType.WORKDAYS_5);
                        break;
                    case 4:
                        skipass = resort.issueSkiPass(PassType.WEEKEND_1);
                        break;
                    case 5:
                        skipass = resort.issueSkiPass(PassType.WEEKEND_2);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                break;
            case 2:
                System.out.println("\n1 - Workdays 10");
                System.out.println("2 - Workdays 20");
                System.out.println("3 - Workdays 50");
                System.out.println("4 - Workdays 100");
                System.out.println("5 - Weekend 10");
                System.out.println("6 - Weekend 20");
                System.out.println("7 - Weekend 50");
                System.out.println("8 - Weekend 100\n");

                int select = sc.nextInt();

                switch(select) {
                    case 1:
                        skipass = resort.issueSkiPass(PassType.WORKDAY_LIFTS, NumOfLifts.LIFTS_10);
                        break;
                    case 2:
                        skipass = resort.issueSkiPass(PassType.WEEKEND_LIFTS, NumOfLifts.LIFTS_20);
                        break;
                    case 3:
                        skipass = resort.issueSkiPass(PassType.WORKDAY_LIFTS, NumOfLifts.LIFTS_50);
                        break;
                    case 4:
                        skipass = resort.issueSkiPass(PassType.WORKDAY_LIFTS, NumOfLifts.LIFTS_100);
                        break;
                    case 5:
                        skipass = resort.issueSkiPass(PassType.WEEKEND_LIFTS, NumOfLifts.LIFTS_10);
                        break;
                    case 6:
                        skipass = resort.issueSkiPass(PassType.WEEKEND_LIFTS, NumOfLifts.LIFTS_20);
                        break;
                    case 7:
                        skipass = resort.issueSkiPass(PassType.WEEKEND_LIFTS, NumOfLifts.LIFTS_50);
                        break;
                    case 8:
                        skipass = resort.issueSkiPass(PassType.WEEKEND_LIFTS, NumOfLifts.LIFTS_100);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                break;
            case 3:
                skipass = resort.issueSkiPass(PassType.SEASON);
                break;
        }
    }

    public void demo(Scanner sc) {
        // Create ski resort system and turnstile
        resort = new SkiResortSystem();
        turnstile = new Turnstile();

        // Connect turnstile to system
        turnstile.connect(resort);

        skipass = null;
        int option = 0;

        while (option != 3) {

            System.out.println("\n1 - Buy SkiPass");
            System.out.println("2 - Enter turnstile");
            System.out.println("3 - Exit\n");

            option = sc.nextInt();

            switch(option) {
                case 1:
                    skiPassShop(sc);
                    break;
                case 2:
                    if (skipass == null) {
                        System.out.println("You have no SkiPass");
                    } else {
                        System.out.println(turnstile.allowToEnter(skipass));
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Enter options among: 1, 2, 3");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SkiResort resort = new SkiResort();
        // resort.test();
        resort.demo(sc);

    }
}


