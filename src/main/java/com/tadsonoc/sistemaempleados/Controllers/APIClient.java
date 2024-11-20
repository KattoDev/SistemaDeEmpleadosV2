package com.tadsonoc.sistemaempleados.Controllers;

import DebugHandler.Debug;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.tadsonoc.sistemaempleados.Models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class APIClient {

    private final String BASE_URL = "http://localhost:5000/api/";

    /**
     * fetch a resource from the API
     *
     * @param resource the API resource to fetch
     */
    public JsonArray fetch(String resource) {
        JsonArray json;

        try {
            // API URL
            URL url = new URI(BASE_URL + resource).toURL();

            // make connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // HTTP method
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // change the response (String -> JSON) with GSON
            json = new Gson().fromJson(getString(conn), JsonArray.class);

            // print as JSON
            // new Debug("output as JSON: " + json);
            conn.disconnect();

            return json;

        } catch (Exception e) {
            new Debug("RE | " + e);
            JsonArray error = new JsonArray();
            String errorString = "[{\"error\":\"" + e.getMessage() + "\"}]";
            error.addAll(JsonParser.parseString(errorString).getAsJsonArray());
            return error;
        }

    }

    /**
     * Upload a JSON with PATCH method
     *
     * @param <Type>   {@link User}
     * @param resource the URL to patch
     * @param patch    the JSONArray Object to patch
     * @return true if patched successfully
     * @throws RuntimeException if an error happens
     */
    public <Type> boolean patch(String resource, Type patch) throws RuntimeException {

        return true;
    }

    /**
     * Gets the API response
     *
     * @param conn the connection HTTP with the API
     * @return the API response
     * @throws IOException      when an error ocurss while reading the response
     * @throws RuntimeException if the response isn't HTTP 200
     */
    private static String getString(HttpURLConnection conn) throws IOException, RuntimeException {
        if (conn.getResponseCode() != 200) {
            // throw error if the server response isn't 200
            throw new RuntimeException("HTTP error code " + conn.getResponseCode());
        }

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader((conn.getInputStream())));

        // StringBuilder to store response
        StringBuilder stringBuilder = new StringBuilder();
        int characterProcessed;
        while ((characterProcessed = bufferedReader.read()) != -1) {
            stringBuilder.append((char) characterProcessed);
        }

        // returns the server response
        return stringBuilder.toString();
    }
}
