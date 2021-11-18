package skipass;

import lombok.Getter;

import java.util.Date;

@Getter
public enum NumOfLifts {
    FULL_PASS(0),
    LIFTS_10(10),
    LIFTS_20(20),
    LIFTS_50(50),
    LIFTS_100(100);

    private int num;

    NumOfLifts(int num){
        this.num = num;
    }
}
