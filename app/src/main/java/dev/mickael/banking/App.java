package dev.mickael.banking;

import dev.mickael.banking.controllers.AccountsController;
import dev.mickael.banking.controllers.CatalogController;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import org.jboss.resteasy.plugins.server.vertx.VertxRegistry;
import org.jboss.resteasy.plugins.server.vertx.VertxRequestHandler;
import org.jboss.resteasy.plugins.server.vertx.VertxResteasyDeployment;

public class App {
  public static void main(String[] args) {
    VertxResteasyDeployment deployment = new VertxResteasyDeployment();
    deployment.start();

    // Create an event of resource per Event Loop
    VertxRegistry registry = deployment.getRegistry();
    registry.addPerInstanceResource(CatalogController.class);
    registry.addPerInstanceResource(AccountsController.class);

    Vertx vertx = Vertx.vertx();
    HttpServer server = vertx.createHttpServer();

    // Set a handler calling RESTEasy
    server.requestHandler(new VertxRequestHandler(vertx, deployment));

    // Start the server
    server.listen(8080, ar -> {
      System.out.println("Server started on port "+ ar.result().actualPort());
    });
  }
}
