package org.ptp.utils.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerService implements IConsumer {
	
	private KafkaConsumer<String, String> consumer ;
	
	public KafkaConsumerService() {
		init();
	}
	
	
	private void init() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", AppConstants.TOPIC_NAME);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "latest");
 
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(AppConstants.TOPIC_NAME));

	}

	@Override
	public ArrayList<Object> consume() {
		
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
        
        
        ArrayList<Object> list = new ArrayList<Object>();
        
        for (ConsumerRecord<String, String> record : records) {
        	
        	list.add(record.value());
        }
        
        
		return list;
	}

}
