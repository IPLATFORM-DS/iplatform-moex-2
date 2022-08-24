package space.eliseev.iplatformmoex.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Duration {
    MINUTE("minute"),
    TEN_MINUTES("ten_minutes"),
    HOUR("hour"),
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    QUARTER("quarter");

    private final String name;
}
