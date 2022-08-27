package space.eliseev.iplatformmoex.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Market {
    SUGAR("sugar"),
    INDEX("index"),
    SHARES("shares"),
    BONDS("bonds"),
    NDM("ndm"),
    OTC("otc"),
    CCP("ccp"),
    DEPOSIT("deposit"),
    REPO("repo"),
    QNV("qnv"),
    MAMC("mamc"),
    FOREIGNSHARES("foreignshares"),
    FOREIGNNDM("foreignndm"),
    MOEXBOARD("moexboard"),
    GCC("gcc"),
    CREDIT("credit"),
    SELT("selt"),
    FUTURES("futures"),
    MAIN("main"),
    FORTS("forts"),
    OPTIONS("options"),
    FORTSIQS("fortsiqs"),
    OPTIONSIQS("optionsiqs"),
    NONRESNDM("nonresndm"),
    NONRESREPO("nonresrepo"),
    NONRESCCP("nonresccp"),
    GRAIN("grain"),
    BUYAUCTIONS("buyauctions"),
    STANDARD("standard"),
    CLASSICA("classica");

    private final String name;
}
