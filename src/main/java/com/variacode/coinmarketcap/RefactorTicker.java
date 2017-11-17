package com.variacode.coinmarketcap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RefactorTicker {

  public static class newTicker {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("rank")
    @Expose
    private Integer rank;

    @SerializedName("price_usd")
    @Expose
    private BigDecimal priceUsd;

    @SerializedName("price_btc")
    @Expose
    private BigDecimal priceBtc;

    @SerializedName("24h_volume_usd")
    @Expose
    private BigDecimal _24hVolumeUsd;

    @SerializedName("market_cap_usd")
    @Expose
    private BigDecimal marketCapUsd;

    @SerializedName("available_supply")
    @Expose
    private BigDecimal availableSupply;

    @SerializedName("total_supply")
    @Expose
    private BigDecimal totalSupply;

    @SerializedName("percent_change_1h")
    @Expose
    private BigDecimal percentChange1h;

    @SerializedName("percent_change_24h")
    @Expose
    private BigDecimal percentChange24h;

    @SerializedName("percent_change_7d")
    @Expose
    private BigDecimal percentChange7d;

    @SerializedName("last_updated")
    @Expose
    private Long lastUpdated;

    private BigDecimal peRatio;

    public newTicker(
        String id,
        String name,
        String symbol,
        Integer rank,
        BigDecimal priceUsd,
        BigDecimal priceBtc,
        BigDecimal _24hVolumeUsd,
        BigDecimal marketCapUsd,
        BigDecimal availableSupply,
        BigDecimal totalSupply,
        BigDecimal percentChange1h,
        BigDecimal percentChange24h,
        BigDecimal percentChange7d,
        Long lastUpdated,
        BigDecimal peRatio) {
      this.id = id;
      this.name = name;
      this.symbol = symbol;
      this.rank = rank;
      this.priceUsd = priceUsd;
      this.priceBtc = priceBtc;
      this._24hVolumeUsd = _24hVolumeUsd;
      this.marketCapUsd = marketCapUsd;
      this.availableSupply = availableSupply;
      this.totalSupply = totalSupply;
      this.percentChange1h = percentChange1h;
      this.percentChange24h = percentChange24h;
      this.percentChange7d = percentChange7d;
      this.lastUpdated = lastUpdated;
      this.peRatio = peRatio;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public Integer getRank() {
      return rank;
    }

    public void setRank(Integer rank) {
      this.rank = rank;
    }

    public BigDecimal getPriceUsd() {
      return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
      this.priceUsd = priceUsd;
    }

    public BigDecimal getPriceBtc() {
      return priceBtc;
    }

    public void setPriceBtc(BigDecimal priceBtc) {
      this.priceBtc = priceBtc;
    }

    public BigDecimal get24hVolumeUsd() {
      return _24hVolumeUsd;
    }

    public void set24hVolumeUsd(BigDecimal _24hVolumeUsd) {
      this._24hVolumeUsd = _24hVolumeUsd;
    }

    public BigDecimal getMarketCapUsd() {
      return marketCapUsd;
    }

    public void setMarketCapUsd(BigDecimal marketCapUsd) {
      this.marketCapUsd = marketCapUsd;
    }

    public BigDecimal getAvailableSupply() {
      return availableSupply;
    }

    public void setAvailableSupply(BigDecimal availableSupply) {
      this.availableSupply = availableSupply;
    }

    public BigDecimal getTotalSupply() {
      return totalSupply;
    }

    public void setTotalSupply(BigDecimal totalSupply) {
      this.totalSupply = totalSupply;
    }

    public BigDecimal getPercentChange1h() {
      return percentChange1h;
    }

    public void setPercentChange1h(BigDecimal percentChange1h) {
      this.percentChange1h = percentChange1h;
    }

    public BigDecimal getPercentChange24h() {
      return percentChange24h;
    }

    public void setPercentChange24h(BigDecimal percentChange24h) {
      this.percentChange24h = percentChange24h;
    }

    public BigDecimal getPercentChange7d() {
      return percentChange7d;
    }

    public void setPercentChange7d(BigDecimal percentChange7d) {
      this.percentChange7d = percentChange7d;
    }

    public Long getLastUpdated() {
      return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
      this.lastUpdated = lastUpdated;
    }

    public BigDecimal getPeRatio() {
      return peRatio;
    }

    public void setPeRatio(BigDecimal peRatio) {
      this.peRatio = peRatio;
    }
  }

  public List<newTicker> Refactor(int limit)
      throws CoinMarketCap.CoinMarketCapException {

    if (limit <= 0) return new ArrayList<newTicker>();

    List<CoinMarketCap.Ticker> tickerList = CoinMarketCap.getTicker(2000, null);

    System.out.println("The first try data size: " + tickerList.size());
    System.out.println();

    List<newTicker> result = new ArrayList<>();

    for (CoinMarketCap.Ticker oldTicker : tickerList) {
      BigDecimal cap = oldTicker.getMarketCapUsd();
      BigDecimal volume = oldTicker.get24hVolumeUsd();

      if (cap == null || volume == null) continue;

      BigDecimal peRatio = cap.divide(volume, 4, RoundingMode.CEILING);

      newTicker tickerWithPeRatio =
          new newTicker(
              oldTicker.getId(),
              oldTicker.getName(),
              oldTicker.getSymbol(),
              oldTicker.getRank(),
              oldTicker.getPriceUsd(),
              oldTicker.getPriceBtc(),
              oldTicker.get24hVolumeUsd(),
              oldTicker.getMarketCapUsd(),
              oldTicker.getAvailableSupply(),
              oldTicker.getTotalSupply(),
              oldTicker.getPercentChange1h(),
              oldTicker.getPercentChange24h(),
              oldTicker.getPercentChange7d(),
              oldTicker.getLastUpdated(),
              peRatio);

      result.add(tickerWithPeRatio);
    }
    Collections.sort(
        result,
        new Comparator<newTicker>() {

          @Override
          public int compare(newTicker o1, newTicker o2) {
            return o1.peRatio.compareTo(o2.peRatio);
          }
        });
    List<newTicker> res = new ArrayList<>();
    for (int i = 0; i < limit; ++i) {
      res.add(result.get(i));
    }
    return res;
  }
}
