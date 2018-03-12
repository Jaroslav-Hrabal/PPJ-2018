package app.assignments.Configuration;

import app.assignments.message.CustomMessage;
import app.assignments.message.PingMessage;
import app.assignments.message.ReplyMessage;
import app.assignments.writer.ListWriter;
import app.assignments.writer.StdoutWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config {
    @Bean
    public PingMessage pingMessage(){
        return new PingMessage();
    }

    @Bean(name = "helloMessage")
    public CustomMessage customMessage(){

        return new CustomMessage("Prvni cast", "Druha cast", "Treti cast");
    }

    @Bean(name = "pingMessageReply")
    public ReplyMessage replyMessage(){
        return new ReplyMessage();
    }
    @Bean
    @PostConstruct
    public StdoutWriter stdoutWriter(){
        return new StdoutWriter();
    }
    @Bean
    @PostConstruct
    public ListWriter listWriter(){
        return new ListWriter();
    }
}
