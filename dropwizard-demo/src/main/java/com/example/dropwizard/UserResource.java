package com.example.dropwizard;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import io.dropwizard.jersey.caching.CacheControl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public UserResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed(name = "get-requests")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public UserRepresentation show(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new UserRepresentation(counter.incrementAndGet(), value);
    }
}
