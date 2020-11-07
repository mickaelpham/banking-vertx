package dev.mickael.banking.controllers;

import io.vertx.core.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/accounts")
public class AccountsController {

  @Path("/{accountId}")
  @GET
  @Produces("application/json")
  public String showAccount(@PathParam("accountId") String accountId) {
    JsonObject accountJson = new JsonObject().put("type", "account").put("id", accountId);
    return accountJson.toString();
  }
}
