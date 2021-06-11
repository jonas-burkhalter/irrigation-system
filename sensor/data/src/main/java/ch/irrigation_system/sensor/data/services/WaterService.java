package ch.irrigation_system.sensor.data.services;

import ch.irrigation_system.sensor.data.model.Water;
import ch.irrigation_system.sensor.data.repository.WaterRepository;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class WaterService {
    private final IMqttClient mqttClient;
    private final WaterRepository repository;

    public WaterService(IMqttClient mqttClient, WaterRepository repository) {
        this.mqttClient = mqttClient;
        this.repository = repository;
    }

    @Bean
    public void subscribeToWater() throws MqttException, InterruptedException {
        String waterTopic = "irrigation_system/unit/+/event/water";

        mqttClient.subscribeWithResponse(waterTopic, (topic, msg) -> {
            String[] subtopic = topic.split("/");
            int value = Integer.parseInt(new String(msg.getPayload()));

            Water water = new Water(new Date(System.currentTimeMillis()), subtopic[2], value);
            repository.save(water);
        });
    }
}
