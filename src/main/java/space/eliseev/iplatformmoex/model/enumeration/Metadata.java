package space.eliseev.iplatformmoex.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Metadata {

    /*
    This enum uses in CheckMetadataService for best readable etc.
     */

    ENGINES ("engines"),
    MARKETS ("markets"),
    BOARDS  ("boards"),
    BOARD_GROUPS ("boardgroups"),
    DURATIONS ("durations"),
    SECURITY_TYPES ("securitytypes"),
    SECURITY_GROUPS ("securitygroups"),
    SECURITY_COLLECTIONS ("securitycollections");

    private final String name;

}
