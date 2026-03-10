package fr.lil.timeline;

import fr.lil.timeline.domain.model.Event;
import fr.lil.timeline.domain.model.Timeline;
import fr.lil.timeline.domain.service.TimelineService;

import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TimelineService service = new TimelineService();

        Timeline t = service.createTimeline(
                LocalDate.of(2000,1,1),
                LocalDate.of(2020,1,1)
        );

        System.out.println(service.getAllTimelines());
    }
}