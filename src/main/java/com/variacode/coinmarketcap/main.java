package com.variacode.coinmarketcap;

import java.util.List;

public class main {

  public static void main(String[] args) throws CoinMarketCap.CoinMarketCapException {

    //        List<CoinMarketCap.Ticker> tickerList = CoinMarketCap.getTicker(2000, null);

    List<RefactorTicker.newTicker> tickerList = new RefactorTicker().Refactor(945);

    int count = 50;

    for (RefactorTicker.newTicker ticker : tickerList) {
      if (count == 0) break;
      if (ticker.getRank() > 150) continue;
      //            if (ticker == null) continue;
      System.out.println(
          ticker.getSymbol()
              + " "
              + ticker.getRank()
              + " "
              + ticker.getPriceUsd()
              + " "
              + ticker.get24hVolumeUsd()
              + " "
              + ticker.getMarketCapUsd()
              + " "
              + ticker.getPeRatio());
      if (ticker.getSymbol().equals("GAS")) System.out.println();
      count--;
    }
  }
}
