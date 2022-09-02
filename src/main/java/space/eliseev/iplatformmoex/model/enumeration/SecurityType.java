package space.eliseev.iplatformmoex.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SecurityType {
    COMMON_SHARE("common_share"),
    PREFERRED_SHARE("preferred_share"),
    DEPOSITARY_RECEIPT("depositary_receipt"),
    OFZ_BOND("ofz_bond"),
    CB_BOND("cb_bond"),
    SUBFEDERAL_BOND("subfederal_bond"),
    MUNICIPAL_BOND("municipal_bond"),
    CORPORATE_BOND("corporate_bond"),
    EXCHANGE_BOND("exchange_bond"),
    IFI_BOND("ifi_bond"),
    EURO_BOND("euro_bond"),
    PUBLIC_PPIF("public_ppif"),
    INTERVAL_PPIF("interval_ppif"),
    RTS_INDEX("rts_index"),
    PRIVATE_PPIF("private_ppif"),
    STOCK_MORTGAGE("stock_mortgage"),
    ETF_PPIF("etf_ppif"),
    STOCK_INDEX("stock_index"),
    EXCHANGE_PPIF("exchange_ppif"),
    STOCK_INDEX_CI("stock_index_ci"),
    STOCK_INDEX_EQ("stock_index_eq"),
    STOCK_INDEX_IM("stock_index_im"),
    STOCK_INDEX_FI("stock_index_fi"),
    STOCK_INDEX_IE("stock_index_ie"),
    STOCK_INDEX_MX("stock_index_mx"),
    STOCK_INDEX_IF("stock_index_if"),
    STOCK_INDEX_NAMEX("stock_index_namex"),
    STOCK_DEPOSIT("stock_deposit"),
    NON_EXCHANGE_BOND("non_exchange_bond"),
    STATE_BOND("state_bond"),
    CURRENCY_INDEX("currency_index"),
    CURRENCY("currency"),
    GOLD_METAL("gold_metal"),
    SILVER_METAL("silver_metal"),
    CURRENCY_FUTURES("currency_futures"),
    CURRENCY_FIXING("currency_fixing"),
    CURRENCY_WAP("currency_wap"),
    FUTURES("futures"),
    OPTION("option"),
    OPTION_ON_SHARES("option_on_shares");

    private final String name;
}
