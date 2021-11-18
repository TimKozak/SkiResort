package skipass;

import lombok.Getter;

@Getter
public class LiftPass extends SkiPass {
    private int numOfLifts;

    public LiftPass(int id, PassType type, NumOfLifts num) {
        super(id, type);
        this.numOfLifts = num.getNum();
    }

    @Override
    public boolean pass() {
        if (numOfLifts > 0) {
            numOfLifts--;
            return true;
        }
        System.out.println("No more lifts left");
        return false;
    }

}
