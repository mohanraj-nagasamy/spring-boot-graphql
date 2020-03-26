package com.example;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphqlApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return args -> {

        };
    }


//    @Autowired
//    private QueryResolver queryResolver;
//    @Autowired
//    private TalkResolver talkResolver;
//    @Autowired
//    private MutationResolver mutationResolver;
//

//    @Bean
//    public ServletRegistrationBean graphQLServlet() {
//        return new ServletRegistrationBean(SimpleGraphQLHttpServlet.newBuilder(buildSchema())
//                .build(), "/graphql");
//    }
//
//    private GraphQLSchema buildSchema() {
//        return SchemaParser
//                .newParser()
//                .file("graphql/schema.graphqls")
////                .dictionary()
//                .resolvers(queryResolver, talkResolver, mutationResolver)
//                .build()
//                .makeExecutableSchema();
//    }



}
