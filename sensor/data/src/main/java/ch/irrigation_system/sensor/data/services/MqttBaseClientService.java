package ch.irrigation_system.sensor.data.services;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttBaseClientService {
    private final String willTopic = "irrigation_system/controller/status/logic";

    @Bean
    public IMqttClient mqttClient(@Value("${mqtt.clientId}") String clientId,
                                  @Value("${mqtt.hostname}") String hostname,
                                  @Value("${mqtt.password}")String password,
                                  @Value("${mqtt.port}") int port,
                                  @Value("${mqtt.username}")String username) throws MqttException {

        IMqttClient mqttClient = new MqttClient("tcp://" + hostname + ":" + port, clientId);

        mqttClient.connect(mqttConnectOptions(username, password));
        mqttClient.publish(willTopic, new MqttMessage("online".getBytes()));

        return mqttClient;
    }

    @Bean
    @ConfigurationProperties(prefix = "mqtt")
    public MqttConnectOptions mqttConnectOptions(@Value("${mqtt.password}")String password, @Value("${mqtt.username}")String username) {
        MqttConnectOptions options = new MqttConnectOptions();

        if (!username.isBlank()){
            options.setUserName(username);
            options.setPassword(password.toCharArray());
        }

        options.setWill(willTopic, "offline".getBytes(), 1, true);
        return options;
    }
}
