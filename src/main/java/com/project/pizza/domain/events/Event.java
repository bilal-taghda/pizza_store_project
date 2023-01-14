package com.project.pizza.domain.events;

import org.threeten.bp.LocalDateTime;

import java.util.UUID;

public class Event {
    public final String eventVersion(){return UUID.randomUUID().toString();}

    public final LocalDateTime when(){return LocalDateTime.now();}
}
