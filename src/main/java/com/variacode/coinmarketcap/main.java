package com.variacode.coinmarketcap;

import java.util.List;

public class main {

    public static void main(String[] args) throws CoinMarketCap.CoinMarketCapException {

//        List<CoinMarketCap.Ticker> tickerList = CoinMarketCap.getTicker(2000, null);


        List<RefactorTicker.newTicker> tickerList = new RefactorTicker().Refactor(200);

        System.out.println(tickerList.size());
        System.out.println();

        for (RefactorTicker.newTicker ticker : tickerList) {
            if (ticker.getRank() > 200) continue;
//            if (ticker == null) continue;
            System.out.println(ticker.getSymbol() + " " + ticker.getRank() + " " + ticker.getPriceUsd() + " " +
                    ticker.get24hVolumeUsd() + " " + ticker.getMarketCapUsd() + " " + ticker.getPeRatio());
        }

//        for (CoinMarketCap.Ticker ticker : tickerList) {
////            if (ticker == null) continue;
////            if (count == 0) break;
//            System.out.println(ticker.getSymbol() + " " + ticker.getRank() + " " + ticker.getPriceUsd() + " " +
//                    ticker.get24hVolumeUsd() + " " + ticker.getMarketCapUsd());
////            count--;
//        }
    }
}
