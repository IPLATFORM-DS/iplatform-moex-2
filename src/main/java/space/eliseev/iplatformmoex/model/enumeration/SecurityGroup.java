package space.eliseev.iplatformmoex.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SecurityGroup {
    STOCK_INDEX("stock_index"),
    STOCK_SHARES("stock_shares"),
    STOCK_BONDS("stock_bonds"),
    CURRENCY_SELT("currency_selt"),
    FUTURES_FORTS("futures_forts"),
    FUTURES_OPTIONS("futures_options"),
    STOCK_DR("stock_dr"),
    STOCK_FOREIGN_SHARES("stock_foreign_shares"),
    STOCK_EUROBOND("stock_eurobond"),
    STOCK_PPIF("stock_ppif"),
    STOCK_ETF("stock_etf"),
    CURRENCY_METAL("currency_metal"),
    STOCK_QNV("stock_qnv"),
    STOCK_GCC("stock_gcc"),
    STOCK_DEPOSIT("stock_deposit"),
    CURRENCY_FUTURES("currency_futures"),
    CURRENCY_INDICES("currency_indices"),
    STOCK_MORTGAGE("stock_mortgage");

    private final String name;
}
