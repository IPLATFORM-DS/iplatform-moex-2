package space.eliseev.iplatformmoex.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Engine {
    STOCK("stock"),
    STATE("state"),
    CURRENCY("currency"),
    FUTURES("futures"),
    COMMODITY("commodity"),
    INTERVENTIONS("interventions"),
    OFFBOARD("offboard"),
    AGRO("agro"),
    OTC("otc");

    private final String name;
}
