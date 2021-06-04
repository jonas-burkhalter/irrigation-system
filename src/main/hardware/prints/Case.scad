difference() {
    difference() {
        main();
        translate ([0, 0, 5]) {
            plant_adapters();
        }
    }
    translate([20, 95, 18]) {
        solar_power_in();
    }
}

power_adapter = 5;

///////////////////
// Plant Adapter //
///////////////////
module plant_adapters() {
    adapter_width = 10;
    count = 5;
    space = 5;
    max_width = 100;
    
    width = (space * (count - 1)) + (adapter_width * 5);
    offset = (max_width - width) / 2;
    
    union() {
        for ( i = [0:4] ) {
            translate([((adapter_width + space) * i) + offset, 0, 0]) {
                plant_adapter();
            }
        }
    }
    
}

module plant_adapter() {
    height = 5;
    length = 10;
    width = 24;
    
    cube([length, width, height]);  
}

//////////
// Case //
//////////
module main() {
    translate ([5, 5, 0]) {
        difference()
        {
            main_positiv();
            main_negativ();
        }
    }
}

module main_negativ() {
    translate ([0, 0, 5]) {
        cube([90, 90, 40]);
    }
}

module main_positiv() {
    minkowski() {
        cube([90, 90, 45]);
        cylinder(r=5,h=5);
    }
}

/////////
// ESP //
/////////
module esp() {
    height = 8;
    length = 58 + power_adapter;
    width = 29;
    
    translate ([-power_adapter, 0, 0]) {
        cube([length, width, height]);  
    }
}

///////////
// SOLAR //
///////////
module solar_power_in() {
    r = 2;
    y = 10;
    
    translate ([0, 0, 0]) {
        rotate ([270,0,0]) {
            cylinder(h = y, r=r, $fa=0.5, $fs=0.5);
        }
    }
}
//module solar() {
//    difference()
//    {
//        solar_cube();
//        solar_power_in();
//    }
//}
//
//module solar_cube() {
//    height = 25;
//    length = 65 + power_adapter;
//    width = 56;
//    
//    translate ([-power_adapter, 0, 0]) {
//        cube([length, width, height]);  
//    }
//}
//
//module solar_power_in() {
//    r = 2;
//    y = 8;
//    
//    // offset to the middle
//    offset_z = 13;
//    offset_y = -(y / 2);
//    offset_x = 55;
//    
//    translate ([offset_x, offset_y, offset_z]) {
//        rotate ([270,0,0]) {
//            cylinder(h = y, r=r, $fa=0.5, $fs=0.5);
//        }
//    }
//}