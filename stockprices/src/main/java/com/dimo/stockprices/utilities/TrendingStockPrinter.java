package com.dimo.stockprices.utilities;

import com.dimo.stockprices.yahoofinanceapi.Finance;
import com.dimo.stockprices.yahoofinanceapi.Quote;
import com.dimo.stockprices.yahoofinanceapi.Result;
import com.dimo.stockprices.yahoofinanceapi.TrendingTickerResult;

import java.util.List;

/**
 * @author jpdho
 * This class accepts the most trending TrendingTickerResult object and prints it formatted for the application.
 */
public class TrendingStockPrinter {
    public static void PrintMessage(TrendingTickerResult apiResult) {
        Finance finance = apiResult.getFinance();
        List<Result> res = finance.getResult();
        Result firstResult = res.get(0);
        Quote quote = firstResult.getQuotes().get(0);
        String symbol = quote.getSymbol();
        String name = quote.getLongName();
        String exchange = quote.getFullExchangeName();
        Double price = quote.getRegularMarketPrice();
        Double change = quote.getRegularMarketChangePercent();

        System.out.println("Today's stock to watch:");
        System.out.println("\tName: " + name + " (" + symbol + ")");
        System.out.println("\tTraded on: " + exchange);
        System.out.println("\tPrice: " + price);
        System.out.println("\tChange percent: " + change + "%");
    }
}
