#include <PubSubClient.h>

class Plant {
    private:         
        int id;
        int pump;
        int sensor;

    public: 
        Plant(int id, int pump, int sensor) {
            Plant::id = id;
            Plant::pump = pump;
            Plant::sensor = sensor;
        }
    
    // private:
    //     String TOPIC_IRRIGATION_SYSTEM_EVENT_MOISTURE(){
    //         return "irrigation_system/unit/" + m_unit + "/event/moisture/" + m_id;
    //     }
    //     String TOPIC_IRRIGATION_SYSTEM_INTENT_WATER(){
    //         return "irrigation_system/unit/" + m_unit + "/intent/water/" + m_id;
    //     }
    //     String TOPIC_IRRIGATION_SYSTEM_STATUS_WATERING(){
    //         return "irrigation_system/unit/" + m_unit + "/status/watering/" + m_id;
    //     }

    public:
        void callback(String topic, String data) {
            if (topic == "irrigation_system/unit/0/intent/water/" + String(id)) {
                setPump(boolean(data));
            }
        }

        String setSensor() {
            String value = String(analogRead(sensor));
            Serial.println("Aggregate - " + String(id) + " - sensor: " + value);
            // m_mqttClient.publish(TOPIC_IRRIGATION_SYSTEM_EVENT_MOISTURE().c_str(), value.c_str()); 
            return value;
        }

        void setup() {
            pinMode(pump, OUTPUT);
        }
    
    private:
        void setPump(boolean value) {
            Serial.println("Aggregate - " + String(id) + " - pump:" + value);
            digitalWrite(pump, value);
            // mqttClient.publish(TOPIC_IRRIGATION_SYSTEM_STATUS_WATERING().c_str(), String(value).c_str()); 
        }
};
