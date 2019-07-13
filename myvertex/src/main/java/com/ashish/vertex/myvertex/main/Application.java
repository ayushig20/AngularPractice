package com.ashish.vertex.myvertex.main;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class Application {
    public static void main(String[] args){
        System.out.println("Hello");

        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route hander1 = router
                .route("/hello/:name")
                .handler(routingContext ->{
                    System.out.println("Hello1 ");
                    String name = routingContext.request().getParam("name");
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.end("HELLLLOO 1 "+name  +"\n");

                });

        Route hander2 = router
                .get("/hello1")
                .handler(routingContext ->{
                    System.out.println("Hello2 ");
                    HttpServerResponse response = routingContext.response();
                    response.end("HELLLLOO 2\n");

                });

        httpServer.requestHandler(router::accept)
                .listen(8091);
    }
}