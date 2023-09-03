package org.ptp.utils.model;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KafkaProducerService implements IProducer {

	private KafkaProducer<String, String> producer;

	private String topicName;

	public KafkaProducerService(String topicName) {
		this.topicName = topicName;
		init();
	}

	public void init() {

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<>(props);

	}

	@Override
	public boolean produce(String key, Object value) {
		if (producer == null)
			return false;

		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


		producer.send(new ProducerRecord<>(topicName, key, json));

		return true;
	}

}
