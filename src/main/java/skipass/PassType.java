package skipass;

import lombok.Getter;

import java.util.*;

@Getter
public enum PassType {
    // WORKDAYS
    WORKDAYS_1(1, "workdays"),
    WORKDAYS_2(2, "workdayS"),
    WORKDAYS_5(5, "workdays"),

    // WEEKEND
    WEEKEND_1(1, "weekend"),
    WEEKEND_2(2, "weekend"),

    // SEASON
    SEASON(90, "always"),

    // NUM OF LIFTS
    WORKDAY_LIFTS(5, "workdays"),
    WEEKEND_LIFTS(2, "weekend");

    private Date startDate;
    private Date endDate;
    private LinkedList<Integer> availableDays;

    PassType(int numOfDays, String available){
        // Add available workdays based on the SkiPass type
        if (available.equals("workdays")) {
                availableDays = new LinkedList<>(Arrays.asList(2, 3, 4, 5, 6));
        } else if (available.equals("weekend")) {
                availableDays = new LinkedList<>(Arrays.asList(1, 7));
        } else {
            availableDays = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }

        // Assume SkiPass starts when it is bought
        Calendar calendar = new GregorianCalendar();
        this.startDate = calendar.getTime();

        // Increment days by numOfDays and set endDate
        calendar.add(Calendar.DATE, numOfDays);
        this.endDate = calendar.getTime();
    }
}
