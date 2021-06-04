/*******************************************************************************************
 **                                                                                       **
 ** Author:     Jonas Burkhalter                                                          **
 ** Date:       21. Mai 2021                                                              **
 ** Github:     https://github.com/jonas-burkhalter/irrigation-system                     **
 ** Version:    0.1                                                                       **
 **                                                                                       **
 ** Libraries:  PubSubClient                                                              **
 ******************************************************************************************/

// Wifi //
#include "WiFi.h"

// MQTT //
#include <PubSubClient.h>
PubSubClient mqtt_client(wiFiClient);

// Unit //
// TODO: read distance
const unit =  {
  bool fill: false, 
  int interval: 60000, 
  // int pin_: SCL,
  // int pin_: SCA, 
  int pin_fill: D9
};

// Pots //
const int count = 5;
const pots = [
  { String name: "alpha", int pin_pump: D2, int pin_sensor: A0, bool pump: false },
  { String name: "beta", int pin_pump: D3, int pin_sensor: A1, bool pump: false },
  { String name: "gamma", int pin_pump: D4, int pin_sensor: A2, bool pump: false },
  { String name: "delta", int pin_pump: D7, int pin_sensor: A3, bool pump: false },
  { String name: "epsilon",int pin_pump: D8, int pin_sensor: A4, bool pump: false },
];

///////////
// Setup //
///////////
void setup() {
  Serial.begin(115200);

  // Wifi //
  WiFi.mode(WIFI_STA);
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
  }

  // MQTT //
  client.setServer(MQTT_SERVER, MQTT_PORT);
  client.setCallback(callback);

  // Unit //
  // pinMode dist sensor
  // pinMode Led for fill

  // Pots //
  for (int i = 0; i < count; i++) {
    pinMode(pots[i].pin_pump, OUTPUT);
  }
}

//////////
// Loop //
//////////
void loop() {
  // MQTT
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  // INTERVAL
  interval();
}

//////////
// MQTT //
//////////
void callback(char* topic, byte* payload, unsigned int length) {
  char data[length+1];
  os_memcpy(data, payload, length);
  data[length] = '\0';

  Serial.println("MQTT - callback topic: " + String(topic) + " data: " + String(data));
  
  callback_action(String(topic), String(data));
}

void callback_action(String topic, String data) {
  if (String(topic) == "irrigation_system/unit/" + UNIT_ID + "/intent/fill") {
    unit.fill = bool(data);
  }
  
  if (String(topic) == "irrigation_system/unit/" + UNIT_ID + "/intent/interval") {
    unit.interval = int(data);
  }

  for (int i = 0; i < count; i++) {
    if (String(topic) == "irrigation_system/unit/" + UNIT_ID + "/pot/" + pots[i].name + "/intent/pump") {
      pump(i, int(data));
    }
  }
}

void reconnect() {
  while (!client.connected()) {
    Serial.println("MQTT.reconnect");
    if (client.connect("irrigation-system-" + UNIT_ID)) {
      Serial.println("MQTT.connected");
      client.subscribe("irrigation_system/unit/" + UNIT_ID + "/#");
    } else {
      delay(1000);
    }
  }
}

///////////
// LOGIC //
///////////
unsigned long previous;

void interval() {
  unsigned long now = millis();
  if ((now - previous) >= unit.interval) {
    Serial.println("heartbeat: " + (String)now);
    interval_action();
    previous = now;
  }
}

void interval_action() {
  // water dist
  String topic_unit = "irrigation_system/unit/" + UNIT_ID + "/event/water"
  // broker.publish(topic_unit, (String)analogRead(unit.pin_dist)); 

  // moistures
  for (int i = 0; i < count; i++) {
    String topic_pot = "irrigation_system/unit/" + UNIT_ID + "/pot/" + pots[i].name + "/event/moisture";
    broker.publish(topic_pot, (String)analogRead(pots[i].pin_sensor)); 
  }
}

void pump(int pin, int ms) {
  digitalWrite(pin, HIGH);
  delay(ms);
  digitalWrite(pin, LOW);
}