package com.SistemaDeEmpleados.Controllers;

import com.SistemaDeEmpleados.Models.User;
import com.google.gson.*;

/**
 * @author katto
 */
public class Auth {

    public boolean authUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        JsonArray response = new FlaskAPI().fetchJSON("users/");

        for (JsonElement entry : response) {

            JsonObject userEntry = entry.getAsJsonObject();

            if (userEntry.has("error")) {
                return false;
            }

            if ((email).equals(userEntry.get("email").getAsString())
                    && (password).equals(userEntry.get("password").getAsString())) {
                user.setId(Integer.parseInt(userEntry.get("id").getAsString()));
                return true;
            }
        }

        return false;
    }
}
