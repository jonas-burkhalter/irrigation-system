difference()
{
    main();
    pipes();
    adapter();
    split();
}

// main
width = 200;
radius = 5;
// addon   
border = 14;

//////////
// Case //
//////////
module main() {
    translate ([5, 5, 0]) {
        union()
        {
            main_positiv();
            main_addon();
        }
    }
}

module main_addon() {
    difference()
    {
        main_addon_positiv();
        main_addon_negative();
    }
}

module main_addon_positiv() {
    t = (border-radius) / 2;
    w = width - border;
    
    translate ([t, t, 5]) {
        cube([w, w, 5]);
    }
}

module main_addon_negative() {
    l = 10;
    
    t = ((border-radius) / 2) + l;
    w = width - border - 2*l;
    
    translate ([t, t, 5]) {
        color("red"){
            cube([w, w, 5]);
        }
    }
}

module main_positiv() {
    w = width - radius;
    
    minkowski() {
        cube([w, w, 1]);
        cylinder(r=radius,h=4);
    }
}


// Pipe //
module pipes() {
    count = 5;
    pipe_width = 8;
    space = 5;
    
    translate([125,25,0]) {
        union() {
            for (i = [0:4]) {
                translate([((pipe_width + space) * i), 0, 0]) {
                    pipe();
                }
            }
        }
    }
}

module pipe() {
    cylinder(r=4, h=10, $fa=0.5, $fs=0.5);
}

// Adapter //
module adapter() {
    height = 10;
    length = 10;
    width = 7;
                    
    translate([170, 175, 0]) {
        cube([length, width, height]);  
    }
}

module split() {          
    cube([100, 100, 10]);  
           
    translate([107, 30, 0]) {
       cylinder(r=3, h=10, $fa=0.5, $fs=0.5);  
    }
                 
    translate([107, 90, 0]) {
       cylinder(r=3, h=10, $fa=0.5, $fs=0.5); 
    }
}


