package com.SistemaDeEmpleados.Controllers;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class FlaskAPI {

    private final String BASE_URL = "http://localhost:5000/api/";

    /**
     * fetch a resource from the
     *
     * @param resource the API resource to fetch like "resource/"
     */
    public JsonArray fetchJSON(String resource) throws RuntimeException {
        JsonArray json;
        
        try {
            //creamos una URL donde esta nuestro webservice
            URL url = new URI(BASE_URL + resource).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //indicamos por que verbo HTML ejecutaremos la solicitud
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                // if the server response isn't 200 throw error
                throw new RuntimeException("HTTP error code "
                        + conn.getResponseCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader((conn.getInputStream())));

            // creamos un StringBuilder para almacenar la respuesta
            StringBuilder stringBuilder = new StringBuilder();
            int characterProcessed;
            while ((characterProcessed = bufferedReader.read()) != -1) {
                stringBuilder.append((char) characterProcessed);
            }

            //en la cadena output almacenamos toda la respuesta del servidor
            String output = stringBuilder.toString();

            //convertimos la cadena a JSON a traves de la libreria GSON
            json = new Gson().fromJson(output, JsonArray.class);

            // imprimimos como Json
            // System.out.println("salida como JSON" + json);

            // imprimimos como String
            // System.out.println("salida como String : " + output);

            conn.disconnect();
            
            return json;
        
        } catch (Exception e) {
            JsonArray error = new JsonArray();
            String errorString = "[{\"error\":\"" + e.getMessage() + "\"}]";
            error.addAll(JsonParser.parseString(errorString).getAsJsonArray());

            return error;
        }

    }

}
