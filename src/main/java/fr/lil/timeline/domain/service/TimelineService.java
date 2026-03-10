package fr.lil.timeline.domain.service;
import fr.lil.timeline.domain.model.Timeline;

import java.time.LocalDate;
import java.util.*;

public class TimelineService {

    private final Map<UUID, Timeline> timelines = new HashMap<>();

    public Timeline createTimeline(LocalDate start, LocalDate end){
        Timeline timeline = new Timeline(start, end);
        timelines.put(timeline.getId(), timeline);
        return timeline;
    }

    public Timeline getTimeline(UUID id){
        return timelines.get(id);
    }

    public Collection<Timeline> getAllTimelines(){
        return Collections.unmodifiableCollection(timelines.values());
    }
}