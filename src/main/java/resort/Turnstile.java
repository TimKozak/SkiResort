package resort;

import skipass.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Turnstile {

    private SkiResortSystem system;

    public void connect(SkiResortSystem system) {
        this.system = system;
        system.setTurnstile(this);
    }

    public boolean hasValidDate(SkiPass skipass) {
        Calendar calendar = new GregorianCalendar();
        Date today = calendar.getTime();

        if (today.before(skipass.getStartDate())) {
            System.out.println("Your SkiPass is not available yet");
            return false;
        } else if (today.after(skipass.getEndDate())) {
            System.out.println("Your SkiPass has expired");
            return false;
        } else if (!skipass.getAvailableDays().contains(calendar.get(Calendar.DAY_OF_WEEK))) {
            System.out.println("Your SkiPass is not valid during this time of the week");
            return false;
        }
        return true;
    }

    public boolean isInSystem(SkiPass skipass) {
        if (system.getSkipasses().contains(skipass)) {
            return true;
        }
        System.out.println("Your SkiPass is not in our system");
        return false;
    }

    public boolean allowToEnter(SkiPass skipass) {
        // Check if it is in the system
        if (isInSystem(skipass)) {
            // Check if not blocked
            if (!skipass.isBlocked()) {
                // Check if it has valid date
                if (hasValidDate(skipass)) {
                    // Check if it has enough lifts left
                    if (skipass.pass()) {
                        system.incrementAllowCounter();
                        System.out.println("Happy skiing!");
                        return true;
                    }
                }
            }
        }
        system.incrementRejectCounter();
        System.out.println("Lift enter rejected");
        return false;
    }
}
