/*******************************************************************************************
 **                                                                                       **
 ** Author:     Jonas Burkhalter                                                          **
 ** Date:       21. Mai 2021                                                              **
 ** Github:     https://github.com/jonas-burkhalter/irrigation-system                     **
 ** Version:    0.1                                                                       **
 **                                                                                       **
 ** Libraries:  PubSubClient                                                              **
 ******************************************************************************************/
// Config //
#include "secrets_mqtt.h"
#include "secrets_unit.h"
#include "secrets_wifi.h"

#include "Pot.h"
#include "Unit.h"

// Wifi //
#include "WiFi.h"
WiFiClient wifi_client;

// MQTT //
#include <PubSubClient.h>
PubSubClient mqtt_client(wifi_client);

// Unit //
// TODO: read distance
// Unit unit(D9, SCA, SCL);
Unit unit(D9, 1, 2);

// Pots //
const int count = 5;
Pot pots[count] = {
  Pot("alpha", D2, A0),
  Pot("beta", D3, A1),
  Pot("gamma", D4, A2),
  Pot("delta", D7, A3),
  Pot("epsilon", D8, A4)
};

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
  mqtt_client.setServer(MQTT_SERVER, MQTT_PORT);
  mqtt_client.setCallback(callback);

  // Unit //
  unit.setup();

  // Pots //
  for (int i = 0; i < count; i++) {
    pots[i].setup();
  }
}

//////////
// Loop //
//////////
void loop() {
  // MQTT
  if (!mqtt_client.connected()) {
    reconnect();
  }
  mqtt_client.loop();

  // INTERVAL
  interval();
}

//////////
// MQTT //
//////////
void callback(char* topic, byte* payload, unsigned int length) {
  char data[length+1];
  memcpy(data, payload, length);
  data[length] = '\0';

  Serial.println("MQTT - callback topic: " + String(topic) + " data: " + String(data));
  
  callback_action(String(topic), String(data));
}

void callback_action(String topic, String data) {
  if (String(topic) == "irrigation_system/unit/" + String(UNIT_ID) + "/intent/fill") {
    unit.setFill(bool(data));
  }
  
  if (String(topic) == "irrigation_system/unit/" + String(UNIT_ID) + "/intent/interval") {
    unit.setInterval(data.toInt());
  }

  for (int i = 0; i < count; i++) {
    if (String(topic) == "irrigation_system/unit/" + String(UNIT_ID) + "/pot/" + pots[i].getName() + "/intent/pump") {
      pots[i].pump(data.toInt());
    }
  }
}

bool connect() {
  return mqtt_client.connect(
      String("irrigation-system-" + String(UNIT_ID)).c_str(),
      MQTT_USERNAME,
      MQTT_PASSWORD
    );
}

void reconnect() {
  while (!mqtt_client.connected()) {
    Serial.println("MQTT.reconnect");
    if (connect()) {
      Serial.println("MQTT.connected");
      mqtt_client.subscribe(("irrigation_system/unit/" + String(UNIT_ID) + "/#").c_str());
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
  if ((now - previous) >= unit.getInterval()) {
    Serial.println("interval: " + (String)now);
    interval_action();
    previous = now;
  }
}

void interval_action() {
  // water dist
  String topic_unit = "irrigation_system/unit/" + String(UNIT_ID) + "/event/water";
  // mqtt_client.publish(topic_unit.c_str(), (String)analogRead(unit.pin_dist)); 

  // moistures
  for (int i = 0; i < count; i++) {
    String topic_pot = "irrigation_system/unit/" + String(UNIT_ID) + "/pot/" + pots[i].getName() + "/event/moisture";
    mqtt_client.publish(topic_pot.c_str(), String(pots[i].getMoisture()).c_str()); 
  }
}
