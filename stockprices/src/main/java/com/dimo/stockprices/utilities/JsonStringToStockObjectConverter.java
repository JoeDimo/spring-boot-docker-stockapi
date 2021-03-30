package com.dimo.stockprices.utilities;

import com.dimo.stockprices.yahoofinanceapi.TrendingTickerResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jpdho
 * This class takes in a JSON string and converts it to a TrendingTickerResult object.
 */
public class JsonStringToStockObjectConverter {
    public static TrendingTickerResult Convert(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TrendingTickerResult res = mapper.readValue(json, TrendingTickerResult.class);
        return res;
    }
}
