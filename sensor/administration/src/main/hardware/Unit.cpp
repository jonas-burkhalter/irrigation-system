#include "Unit.h"

Unit::Unit(int pin_fill, int pin_sca, int pin_scl) {
    Unit::interval = 60000;
    Unit::pin_fill = pin_fill;
    Unit::pin_sca = pin_sca;
    Unit::pin_scl = pin_scl;
}
    
void Unit::setFill(bool fill) {
    digitalWrite(pin_fill, fill);
}

int Unit::getInterval() {
    return interval;
}

void Unit::setInterval(int interval) {
    Unit::interval = interval;
}

void Unit::setup() {
    // pinMode Led for fill
    pinMode(pin_fill, OUTPUT);
    // pinMode dist sensor
}
