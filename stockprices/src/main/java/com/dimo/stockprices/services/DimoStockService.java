package com.dimo.stockprices.services;

import com.dimo.stockprices.yahoofinanceapi.TrendingTickerResult;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author jpdho
 * <p>
 * This class is used to fetch the Yahoo Finance "get-trending-tickers" API.
 * It tests the result and, for simplicity's sake, returns the body of the HttpResult if the status code == 200.
 * It throws an exception if the status code != 200.
 */
public class DimoStockService {

    public TrendingTickerResult ApiResult;

    public String GetTrendingTickers(String key, String host) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-trending-tickers?region=US"))
                .header("x-rapidapi-key", key)
                .header("x-rapidapi-host", host)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            System.out.println("Status Code: " + response.statusCode());
            throw new Exception("There was an error contacting the Yahoo Finance API");
        }
    }
}
