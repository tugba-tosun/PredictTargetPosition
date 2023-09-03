package org.ptp.utils.test;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerExample {

	public KafkaProducerExample() {
		// TODO Auto-generated constructor stub
	}
	
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
        	
            producer.send(
                  new ProducerRecord<>("test",
                       Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
    }

}
