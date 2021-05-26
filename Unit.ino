/*******************************************************************************************
 **                                                                                       **
 ** Author:     Jonas Burkhalter                                                          **
 ** Date:       21. Mai 2021                                                              **
 ** Github:     https://github.com/jonas-burkhalter/irrigation-system                     **
 ** Version:    0.1                                                                       **
 **                                                                                       **
 ** Libraries:  WiFi                                                                      **
 **             PubSubClient: https://github.com/knolleary/pubsubclient/                  **
 ******************************************************************************************/


// Wifi //
#include <WiFi.h>
const char* SSID = ""; // TODO
const char* PASSWORD = ""; // TODO
WiFiClient wiFiClient;

// MQTT //
#include <PubSubClient.h>
PubSubClient mqttClient(wiFiClient);
const char* MASTER = ""; // TODO

unsigned long heartbeat_previous;
const int HEARTBEAT = 10000; // TODO

const String unit = "0"; // TODO
const char* CLIENT = "irrigation-system-0";// + unit;

const String TOPIC_IRRIGATION_SYSTEM = "irrigation_system/unit/" + unit;
const String TOPIC_IRRIGATION_SYSTEM_INTENT = TOPIC_IRRIGATION_SYSTEM + "/intent";
const String TOPIC_IRRIGATION_SYSTEM_STATUS = TOPIC_IRRIGATION_SYSTEM + "/status";

// #include "Plant.cpp";
const int count = 4;
Plant plants[count] = {
  Plant(0, D2, A0),
  Plant(1, D3, A1),
  Plant(2, D4, A2),
  Plant(3, D5, A3)
};

///////////
// Setup //
///////////
void setup() {
  Serial.begin(115200);

  // Wifi //
  WiFi.mode(WIFI_STA);
  WiFi.begin(SSID, PASSWORD);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
  }

  // MQTT //
  mqttClient.setServer(MASTER, 1883);
  mqttClient.setCallback(callback);

  // Aggregates //
  for (int i = 0; i < count; i++) {
    plants[i].setup();
  }
}

//////////
// Loop //
//////////
void loop() {
  if (!mqttClient.connected()) {
    reconnect();
  }
  mqttClient.loop();

  heartbeat();
}

//////////
// MQTT //
//////////
void callback(char* topic, byte* payload, unsigned int length) {
  char data[length+1];
  memcpy(data, payload, length);
  data[length] = '\0';

  Serial.println("MQTT - callback topic: " + String(topic) + " data: " + String(data));

  for (int i = 0; i < count; i++) {
    plants[i].callback(String(topic), String(data));
  }
}

// TODO
// boolean connect() {
//   if (!mqttClient.connected()) {
//     Serial.println(client.c_str());
//     return mqttClient.connect(
//       client.c_str()
//       // ,
//       // NULL, 
//       // NULL,
//       // TOPIC_IRRIGATION_SYSTEM_STATUS.c_str(),
//       // 1,
//       // false,
//       // "offline"
//     );
//   }

//   return mqttClient.connected();
// }

void heartbeat() {
  unsigned long now = millis();
  if ((now - heartbeat_previous) >= HEARTBEAT) {

    for (int i = 0; i < count; i++) {
      String value = plants[i].setSensor();
      mqttClient.publish(("irrigation_system/unit/" + unit + "/event/moisture/" + i).c_str(), value.c_str()); 
    }

    heartbeat_previous = now;
  }
}


void reconnect() {
  while (!mqttClient.connected()) {
    Serial.println("MQTT - reconnect");
    if (mqttClient.connect(CLIENT)) {
      Serial.println("MQTT - connected");
      mqttClient.subscribe(TOPIC_IRRIGATION_SYSTEM_INTENT.c_str());
    } else {
      delay(1000);
    }
  }
}
