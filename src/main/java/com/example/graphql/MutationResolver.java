package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.model.Speaker;
import com.example.model.http.SpeakerInput;
import com.example.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutationResolver implements GraphQLMutationResolver {
    private final SpeakerService speakerService;

    @Autowired
    public MutationResolver(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    public Speaker addSpeakerSimple(String name) {
        System.out.println("MutationResolver.addSpeakerSimple");
        System.out.println("name = " + name);
        Speaker speaker = new Speaker();
        speaker.setName(name);
        return speakerService.save(speaker);
    }
    public Speaker addSpeakerObject(SpeakerInput speakerInput) {
        System.out.println("MutationResolver.addSpeakerSimple");
        System.out.println("speakerInput = " + speakerInput);
        Speaker speaker = new Speaker();
        speaker.setName(speakerInput.getName());
        speaker.setTwitter(speakerInput.getTwitter());
        return speakerService.save(speaker);
    }
}
