difference() {
    difference() {
        main();
        translate ([0, 0, 5]) {
            plant_adapters();
        }
    }
    translate([14, 110, 18]) {
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
    max_width = 115;
    
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
    height = 7;
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
    translate ([-1, -1, 5]) {
        cube([107, 107, 40]);
    }
}

module main_positiv() {
    minkowski() {
        cube([105, 105, 40]);
        cylinder(r=5,h=5);
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
            cylinder(h = 10, r=2, $fa=0.5, $fs=0.5);
            translate([0,0,3]) {
                cylinder(h = 2, r=5, $fa=0.5, $fs=0.5);
            }
        }
    }
}