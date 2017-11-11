package com.variacode.coinmarketcap;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) throws CoinMarketCap.CoinMarketCapException {

        List<RefactorTicker.newTicker> tickerList = new RefactorTicker().Refactor(100);

        System.out.println(tickerList.size());
        System.out.println();

        int count = 1000;

        for (RefactorTicker.newTicker ticker : tickerList) {
            if (ticker == null) continue;
            if (count == 0) break;
            System.out.println(ticker.getSymbol() + " " + ticker.getRank() + " " + ticker.getPriceUsd() + " " +
                    ticker.get24hVolumeUsd() + " " + ticker.getMarketCapUsd() + " " + ticker.getPeRatio());
            count--;
        }
    }
}
