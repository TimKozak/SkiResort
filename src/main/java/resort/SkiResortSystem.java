package resort;

import lombok.Getter;
import lombok.Setter;
import skipass.*;

import java.util.LinkedList;

@Getter
public class SkiResortSystem {
    // Connected turnstile
    @Setter
    private Turnstile turnstile;

    // Ski resort IDs
    private int idCounter = 1;
    private LinkedList<SkiPass> skipasses = new LinkedList<>();

    // Counters for allow and reject
    private int allowCounter = 0;
    private int rejectCounter = 0;

    public SkiResortSystem() {}

    // LIFT PASS ISSUER
    public SkiPass issueSkiPass (PassType type, NumOfLifts num) {
        if (type.equals(PassType.WEEKEND_LIFTS) || type.equals(PassType.WORKDAY_LIFTS)) {
            return createSkiPass(type, num);
        }
        System.out.println("ERR: Num of lifts is not needed");
        return null;
    }

    // FULL PASS ISSUER
    public SkiPass issueSkiPass (PassType type) {
        if (!type.equals(PassType.WEEKEND_LIFTS) && !type.equals(PassType.WORKDAY_LIFTS)) {
            return createSkiPass(type, NumOfLifts.FULL_PASS);
        }
        System.out.println("ERR: Specify num of lifts");
        return null;
    }

    // INTERNAL SKI PASS CREATOR
    private SkiPass createSkiPass (PassType type, NumOfLifts num) {
        SkiPass skipass;

        // If it is full pass
        if (num == NumOfLifts.FULL_PASS) {
            skipass = new FullPass(idCounter++, type);

        // If it is lift pass
        } else {
            skipass = new LiftPass(idCounter++, type, num);
        }

        skipasses.add(skipass);
        return skipass;
    }

    // SKI PASS BLOCKER
    public boolean blockSkiPass(SkiPass skipass) {
        if (skipasses.contains(skipass)) {
            return skipass.block();
        }
        System.out.println("SkiPass is not in the system");
        return false;
    }

    // Allow increment
    public void incrementAllowCounter() {
        allowCounter++;
    }

    // Reject increment
    public void incrementRejectCounter() {
        rejectCounter++;
    }
}
