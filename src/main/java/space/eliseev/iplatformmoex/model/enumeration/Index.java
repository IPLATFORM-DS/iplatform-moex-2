package space.eliseev.iplatformmoex.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Index {

    ENGINES("engines"),
    MARKETS("markets"),
    BOARDS("boards"),
    BOARDGROUPS("boardgroups"),
    DURATIONS("durations"),
    SECURITYTYPES("securitytypes"),
    SECURITYGROUPS("securitygroups"),
    SECURITYCOLLECTIONS("securitycollections");


    private final String name;
}
