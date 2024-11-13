package net.example.consumerApplication;

import net.example.consumerApplication.entity.Wikimedia;
import net.example.consumerApplication.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "wikimedia_recent", groupId = "myGroup")
    public void consume(String message){
        logger.info("message received " + message);
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEventData(message);
        wikimediaDataRepository.save(wikimedia);
    }
}
