package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.model.Attendee;
import com.example.model.Speaker;
import com.example.model.Talk;
import com.example.service.AttendeeService;
import com.example.service.SpeakerService;
import com.example.service.TalkService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QueryResolver implements GraphQLQueryResolver {
    private final TalkService talkService;
    private final AttendeeService attendeeService;
    private final SpeakerService speakerService;

    @Autowired
    public QueryResolver(TalkService talkService, AttendeeService attendeeService, SpeakerService speakerService) {
        this.talkService = talkService;
        this.attendeeService = attendeeService;
        this.speakerService = speakerService;
    }

    public List<Talk> allTalks(DataFetchingEnvironment dfe) {
//        SecurityContextHolder.getContext().getAuthentication()
        System.out.println("Query.allTalks dfe:" + dfe);
        return talkService.findAll();
    }

    public List<Attendee> allAttendees() {
        System.out.println("Query.allAttendees");
        return attendeeService.findAll();
    }

    public List<Speaker> allSpeakers() {
        System.out.println("Query.allSpeakers");
        return speakerService.findAll();
    }

    public List<Object> allOfAll() {
        List speakers = speakerService.findAll();
        List talks = talkService.findAll();


        speakers.addAll(talks);

        return speakers;
    }

}
