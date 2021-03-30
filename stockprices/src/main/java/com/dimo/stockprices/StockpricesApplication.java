package com.dimo.stockprices;

import com.dimo.stockprices.services.DimoStockService;
import com.dimo.stockprices.utilities.TrendingStockPrinter;
import com.dimo.stockprices.utilities.JsonStringToStockObjectConverter;
import com.dimo.stockprices.yahoofinanceapi.TrendingTickerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jpdho
 * This application calls the Yahoo Finance ""get-trending-tickers" API and prints the most trending API to the CLI.
 */
@SpringBootApplication
public class StockpricesApplication implements CommandLineRunner {

    @Value("${apikey}")
    private String key;

    @Value("${apihost}")
    private String host;

    public static void main(String[] args) {
        SpringApplication.run(StockpricesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            DimoStockService stockService = new DimoStockService();
            String json = stockService.GetTrendingTickers(key, host);
            TrendingTickerResult result = JsonStringToStockObjectConverter.Convert(json);
            TrendingStockPrinter.PrintMessage(result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
