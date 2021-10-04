package com.redhat.sa;

import com.fasterxml.jackson.annotation.JsonView;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.Multi;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

import javax.ws.rs.*;


@Path("/quote")
@Produces("application/json")
public class QuoteService {
    private static final Logger LOGGER = Logger.getLogger(QuoteService.class.getName());

    @GET
    @Path("{ticker}")
    @JsonView(Views.ShortView.class)
    public Uni<Security> getQuote(@RestPath String ticker) {
        return Security.findByTicker(ticker).onItem().ifNull().failWith(NotFoundException::new);
    }

    @GET
    @Produces("application/json")
    public Multi<String> getAllTickers() {
        return Security.getAllTickers();
    }
}

