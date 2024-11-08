package com.SistemaDeEmpleados.Controllers;

import com.SistemaDeEmpleados.Models.User;
import DEBUGING.Debug;
import com.SistemaDeEmpleados.Models.ActualSession;
import com.google.gson.*;

/**
 * @author katto
 */
public class Auth {

    public boolean authUser(User user) {
        final String URL = "users/" + user.getEmail() + "-" + user.getPassword();

        JsonArray response = new FlaskAPI()
                .fetchJSON(URL);

        new Debug("URL is" + URL);
        
        for (JsonElement entry : response) {

            JsonObject userEntry = entry.getAsJsonObject();

            if (userEntry.has("error")) {
                return false;
            } else {

                int dept;

                if (userEntry.get("department").isJsonNull()) {
                    dept = 0;
                } else {
                    dept = userEntry.get("department").getAsInt();
                }

                User authorizedUser = new User(
                        userEntry.get("id").getAsInt(),
                        userEntry.get("name").getAsString(),
                        userEntry.get("address").getAsString(),
                        userEntry.get("birthday").getAsString(),
                        userEntry.get("phoneNumber").getAsLong(),
                        userEntry.get("email").getAsString(),
                        userEntry.get("position").getAsString(),
                        userEntry.get("salary").getAsLong(),
                        userEntry.get("password").getAsString(),
                        dept,
                        userEntry.get("isAdmin").getAsBoolean()
                );
                
                ActualSession.getInstance().setUser(authorizedUser);
                return true;
            }
        }

        return false;
    }
}
