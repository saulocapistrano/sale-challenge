package com.sale.gateway.controller;

import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.ext.web.client.WebClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/gateway/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerProxyController {

    @Inject
    WebClient client;

    private static final String CUSTOMER_SERVICE_URL = "http://localhost:8081/customers";

    @GET
    public Uni<Response> getCustomers() {
        return client.getAbs(CUSTOMER_SERVICE_URL)
                .send()
                .onItem().transform(resp -> Response.ok(resp.bodyAsJsonArray().encode()).build());
    }

    @POST
    public Uni<Response> createCustomer(JsonObject customer) {
        return client.postAbs(CUSTOMER_SERVICE_URL)
                .sendJsonObject(customer)
                .onItem().transform(resp -> {
                    if (resp.statusCode() >= 400) {
                        return Response.status(resp.statusCode()).entity(resp.bodyAsString()).build();
                    }
                    return Response.ok(resp.bodyAsJsonObject().encode()).build();
                });
    }
}
