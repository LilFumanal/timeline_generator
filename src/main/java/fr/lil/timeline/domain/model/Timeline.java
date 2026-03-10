package fr.lil.timeline.domain.model;

import java.time.LocalDate;
import java.util.*;

public class Timeline {
    private final UUID id;
    private final String title;
    private final LocalDate start;
    private final LocalDate end;
    private final Map<UUID, Event> events = new HashMap<>();

    public Timeline(LocalDate start, LocalDate end) {
        if (start == null) {
            throw new IllegalArgumentException("start cannot be null");
        }
        this.start = start;
        if (end == null ) {
            throw new IllegalArgumentException("end cannot be null");
        }
        if ( end.isBefore(start) || end.equals(start)) {
            throw new IllegalArgumentException("end cannot be before or equal to start");
        }
        this.end = end;
        this.title = start.toString() + end.toString();
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getTitle() {
        return title;
    }

    public void addEvent(Event... events){
        for (Event event : events){
            if(event == null) {
                throw new IllegalArgumentException("Event can't be null");
            }
            if(this.events.containsKey(event.getId())) {
                throw new IllegalArgumentException("Event already exists in timeline");
            }
            LocalDate effectiveEventEnd = event.getEnd() != null
                    ? event.getEnd()
                    : end;
            if (effectiveEventEnd.isBefore(start) || event.getStart().isAfter(end)) {
                throw new IllegalArgumentException("Event is outside timeline bounds");
            }
            this.events.put(event.getId(), event);
        }
    }

    public void removeEvent(Event event){
        events.remove(event.getId());
    }
    public Collection<Event> getEvents() {
        return Collections.unmodifiableCollection(events.values());
    }

    public List<Event> sortedEvents(){
        List<Event> list = new ArrayList<>(events.values());
        list.sort(Comparator.comparing(Event::getStart));
        return list;
    }
}
