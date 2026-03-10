package fr.lil.timeline.domain.model;

import java.util.UUID;
import java.time.LocalDate;

public class Event {

    private final UUID id;
    private final String title;
    private final String description;
    private final LocalDate start;
    private final LocalDate end; // nullable

    public Event(String title, String description, LocalDate start, LocalDate end) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        this.title = title;
        this.description = description;
        if (start == null) {
            throw new IllegalArgumentException("start cannot be null");
        }
        this.start = start;
        if (end != null && end.isBefore(start)) {
            throw new IllegalArgumentException("end cannot be before start");
        }
        this.end = end;
        this.id = UUID.randomUUID();
    }
    public UUID getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public LocalDate getStart(){
        return start;
    }
    public LocalDate getEnd(){
        return end;
    }
    public boolean isOngoing() {
        return end == null;
    }
    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }

}