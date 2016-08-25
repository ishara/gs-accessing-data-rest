package hello;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
@EnableAutoConfiguration(exclude = JerseyAutoConfiguration.class)
//@EnableJpaRepositories(repositoryBaseClass = CGPagingAndSortingRepositoryImpl.class)
public class Application
{

    public static void main( String[] args )
    {
        SpringApplication.run( Application.class, args );
    }

//    @Bean
//    public Jackson2ObjectMapperBuilder jacksonBuilder()
//    {
//        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
//        FilterProvider filterProvider = new SimpleFilterProvider().addFilter( "authorityFilter", new AuthorityFilter() );
//        return b.filters( filterProvider );
//    }

}
