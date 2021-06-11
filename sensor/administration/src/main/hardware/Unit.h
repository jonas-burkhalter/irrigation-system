#ifndef UNIT_H
#define UNIT_H

#include <Arduino.h>

class Unit {
    private:
        int interval;
        int pin_fill;
        int pin_sca; 
        int pin_scl;
    
    public:
        Unit(int pin_fill, int pin_sca, int pin_scl);
        void setFill(bool fill);
        int getInterval();
        void setInterval(int interval);
        void setup();
};
#endif