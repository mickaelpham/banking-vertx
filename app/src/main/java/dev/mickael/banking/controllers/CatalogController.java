package dev.mickael.banking.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/catalog")
public class CatalogController {

  @GET
  @Produces("text/plain")
  public String showCatalog() {
    return "the catalog";
  }
}
