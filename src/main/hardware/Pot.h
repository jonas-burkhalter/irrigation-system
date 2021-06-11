#ifndef POT_H
#define POT_H

#include <Arduino.h>

class Pot {
    private:
        String name;    
        int pin_pump;
        int pin_sensor;
    
    public:
        Pot(String name, int pin_pump, int pin_sensor);
        int getMoisture() ;
        String getName() ;
        void pump(int ms);
        void setup();
};
#endif