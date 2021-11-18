package skipass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;
import java.util.LinkedList;

@Getter @AllArgsConstructor
public class SkiPass {
    private int id;
    private PassType type;
    private Date startDate;
    private Date endDate;
    private LinkedList<Integer> availableDays;
    private boolean blocked;

    public SkiPass(int id, PassType type) {
        this.id = id;
        this.type = type;
        this.startDate = type.getStartDate();
        this.endDate = type.getEndDate();
        this.availableDays = type.getAvailableDays();
    }

    public boolean pass() {
        return true;
    }

    public boolean block() {
        if (!blocked) {
            blocked = true;
            System.out.println(type + " " + id + " was blocked!");
            return true;
        }
        System.out.println(type + " " + id + " is already blocked!");
        return false;
    }

    @Override
    public String toString() {
        return "SkiPass{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
