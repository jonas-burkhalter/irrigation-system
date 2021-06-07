difference()
{
    main();
    split();
}

// main
width = 200;
radius = 5;
// addon   
border = 12;

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


module split() {                    
    translate([100, 0, 0]) {
        cube([110, 210, 10]);  
    }            
    translate([0, 100, 0]) {
        cube([210, 110, 10]);  
    }   
           
    translate([93, 30, 0]) {
       cylinder(r=3, h=10, $fa=0.5, $fs=0.5);  
    }
                 
    translate([93, 90, 0]) {
       cylinder(r=3, h=10, $fa=0.5, $fs=0.5); 
    }
}



