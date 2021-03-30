package com.dimo.stockprices.yahoofinanceapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author jpdho
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "quotes",
        "jobTimestamp",
        "startInterval"
})
public class Result {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("quotes")
    private List<Quote> quotes = null;
    @JsonProperty("jobTimestamp")
    private Long jobTimestamp;
    @JsonProperty("startInterval")
    private Long startInterval;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("quotes")
    public List<Quote> getQuotes() {
        return quotes;
    }

    @JsonProperty("quotes")
    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @JsonProperty("jobTimestamp")
    public Long getJobTimestamp() {
        return jobTimestamp;
    }

    @JsonProperty("jobTimestamp")
    public void setJobTimestamp(Long jobTimestamp) {
        this.jobTimestamp = jobTimestamp;
    }

    @JsonProperty("startInterval")
    public Long getStartInterval() {
        return startInterval;
    }

    @JsonProperty("startInterval")
    public void setStartInterval(Long startInterval) {
        this.startInterval = startInterval;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}