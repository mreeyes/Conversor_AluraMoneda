package com.aluracursos.conversormonedas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    private String apiKey;

    public double getConversionRate(String fromCurrency, String toCurrency){
        double rate = -1;
        try{
            String urlString = "https://open.er-api.com/v6/latest/" + fromCurrency + "?symbols=" + toCurrency;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", apiKey);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.has("rates")){
                JSONObject rates = jsonResponse.getJSONObject("rates");
                rate = rates.getDouble(toCurrency);
            }
        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return rate;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
