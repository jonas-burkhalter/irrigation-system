#include "Pot.h"

Pot::Pot(String name, int pin_pump, int pin_sensor) {
    Pot::name = name;
    Pot::pin_pump = pin_pump;
    Pot::pin_sensor = pin_sensor;
}

int Pot::getMoisture() {
    return analogRead(pin_sensor);
}

String Pot::getName() {
    return name;
} 

void Pot::pump(int ms) {
    digitalWrite(pin_pump, HIGH);
    delay(ms);
    digitalWrite(pin_pump, LOW);
}

void Pot::setup() {
    pinMode(pin_pump, OUTPUT);
}
