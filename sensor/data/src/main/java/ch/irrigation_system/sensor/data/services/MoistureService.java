package ch.irrigation_system.sensor.data.services;

import ch.irrigation_system.sensor.data.model.Moisture;
import ch.irrigation_system.sensor.data.repository.MoistureRepository;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class MoistureService {
    private final IMqttClient mqttClient;
    private final MoistureRepository repository;

    public MoistureService(IMqttClient mqttClient, MoistureRepository repository) {
        this.mqttClient = mqttClient;
        this.repository = repository;
    }

    @Bean
    public void subscribeToMoisture() throws MqttException, InterruptedException {
        String moistureTopic = "irrigation_system/unit/+/pot/+/event/moisture";

        mqttClient.subscribeWithResponse(moistureTopic, (topic, msg) -> {
            String[] subtopic = topic.split("/");
            int value = Integer.parseInt(new String(msg.getPayload()));

            Moisture moisture = new Moisture(new Date(System.currentTimeMillis()), subtopic[4], subtopic[2], value);
            repository.save(moisture);
        });
    }
}
