package com.project.pizza.domain.events;

import java.time.Instant;
import java.util.UUID;

public class Event {
    public final String eventVersion(){return UUID.randomUUID().toString();}

    public final Instant when(){return Instant.now();}
}
