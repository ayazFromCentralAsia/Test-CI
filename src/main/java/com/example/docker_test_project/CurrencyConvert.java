package com.example.docker_test_project;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConvert {
    private static final String API_KEY = "your_api_key";
    private static final String API_URL = "https://api.exchangeratesapi.io/v1/latest";


    public static double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        String json = getRates(fromCurrency);
        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        JsonObject ratesNode = jsonObject.getAsJsonObject("rates");

        JsonElement rateElement = ratesNode.get(toCurrency);
        if (rateElement == null) {
            throw new Exception("Currency not found: " + toCurrency);
        }

        double rate = rateElement.getAsDouble();
        return amount * rate;
    }

    public static String getRates(String fromCurrency) {
        return "{ \"rates\": { \"EUR\": 0.85, \"GBP\": 0.75, \"JPY\": 110.0 } }";
    }
}
