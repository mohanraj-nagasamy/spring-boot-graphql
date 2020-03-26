package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.model.Speaker;
import com.example.model.Talk;
import com.example.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkResolver implements GraphQLResolver<Talk> {

    private final SpeakerService speakerService;

    @Autowired
    public TalkResolver(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    public List<Speaker> speakers(Talk talk) {
        System.out.println("TalkResolver.speakers");
        System.out.println("talk = " + talk);
        return speakerService.findAllSpeakersForTalk(talk);
    }
    public List<Speaker> speakersByTitle(Talk talk, String title) {
        System.out.println("TalkResolver.speakersByTitle");
        System.out.println("talk = " + talk + ", title = " + title);
        return speakerService.findAll();
    }
}
