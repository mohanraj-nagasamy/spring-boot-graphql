package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.model.Speaker;
import com.example.model.Talk;
import com.example.service.TalkService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerResolver implements GraphQLResolver<Speaker> {
    private final TalkService talkService;

    @Autowired
    public SpeakerResolver(TalkService talkService) {
        this.talkService = talkService;
    }

    public List<Talk> talks(Speaker speaker, DataFetchingEnvironment dfe){
        System.out.println("SpeakerResolver.talks dfe:" + dfe);
        Object context = dfe.getContext();
        System.out.println("speaker = " + speaker);
        return talkService.findAllTalksBySpeaker(speaker);

    }
}
