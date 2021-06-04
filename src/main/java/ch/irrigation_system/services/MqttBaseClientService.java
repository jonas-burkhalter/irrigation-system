package ch.irrigation_system.services;

import org.eclipse.paho.client.mqttv3.*;

import java.util.UUID;

public class MqttBaseClientService {
    // Topic Brewery
    public static final String TOPIC_BREWERY_INTENT = "tiny_distillery/brewery/intent";
    public static final String TOPIC_BREWERY_EVENT = "tiny_distillery/brewery/event/#";
    public static final String TOPIC_BREWERY_EVENT_CURRENT_TEMPERATURE = "tiny_distillery/brewery/event/current_temperature";
    public static final String TOPIC_BREWERY_EVENT_HEATING = "tiny_distillery/brewery/event/heating";
    public static final String TOPIC_BREWERY_STATUS = "tiny_distillery/brewery/status/#";
    public static final String TOPIC_BREWERY_STATUS_HEATER = "tiny_distillery/brewery/status/heater";
    public static final String TOPIC_BREWERY_STATUS_MEASURING = "tiny_distillery/brewery/status/measuring";

    // Topic Controller
    public static final String TOPIC_CONTROLLER_STATUS = "tiny_distillery/controller/status";

    // Topic Display
    public static final String TOPIC_DISPLAY_EVENT = "tiny_distillery/display/event/#";
    public static final String TOPIC_DISPLAY_EVENT_BREW_OPTIONS = "tiny_distillery/display/event/brew_options";
    public static final String TOPIC_DISPLAY_EVENT_CANCEL_BREWING = "tiny_distillery/display/event/cancel_brewing";
    public static final String TOPIC_DISPLAY_INTENT_ALERT = "tiny_distillery/display/intent/alert";
    public static final String TOPIC_DISPLAY_INTENT_BREW_PROGRESS = "tiny_distillery/display/intent/brew_progress";

    // MQTT Broker
    private final String HOST = "tcp://192.168.1.125:1883";
    private final String USERNAME = "";
    private final String PASSWORD = "";
    private IMqttClient mqttClient;

    public MqttBaseClientService(String topic, String payload) {
        try {
            mqttClient = new MqttClient(HOST, UUID.randomUUID().toString());

            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            if (!USERNAME.isBlank()) {
                connectOptions.setUserName(USERNAME);
                connectOptions.setPassword(PASSWORD.toCharArray());
            }

            connectOptions.setWill(topic, payload.getBytes(), 1, true);

            mqttClient.connect(connectOptions);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public MqttBaseClientService() {
        try {
            mqttClient = new MqttClient(HOST, UUID.randomUUID().toString());

            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            if (!USERNAME.isBlank()) {
                connectOptions.setUserName(USERNAME);
                connectOptions.setPassword(PASSWORD.toCharArray());
            }

            mqttClient.connect(connectOptions);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void publish(String topic, String content) {
        try {
            MqttMessage message = new MqttMessage(content.getBytes());
            mqttClient.publish(topic, message);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    protected void subscribe(String topic, MqttCallback callback) {
        try {
            mqttClient.subscribe(topic);
            mqttClient.setCallback(callback);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    protected void unsubscribe(String topic) {
        try {
            mqttClient.unsubscribe(topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
