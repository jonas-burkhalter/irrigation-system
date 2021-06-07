sensor();

// Sensor //
module sensor() {
    difference()
    {
        sensor_positiv();
        sensor_negative();
        holes();
        cable();
    }
}

length = 24;
width = 55;
height = 7;

padding = 5;
spacing = 2;

length_p = length + padding * 2;
width_p = width + padding * 2;
height_p = height + padding;

length_n = length + spacing * 2;
width_n = width + spacing * 2;
height_n = height + spacing;
    

module sensor_positiv() {
    x = length + padding * 2;
    y = width + padding * 2;
    z = height + padding;
    cube([length_p, width_p, height_p]);
}

module sensor_negative() {
    xt = (length_p - length_n) / 2;
    yt = (width_p - width_n) / 2;
    zt = height_p - height_n;
    
    translate ([xt, yt, zt]) {
        cube([length_n, width_n, height_n]);
    }
}

module holes() {
    count = 2;
    hole_width = 16;
    space = 8;
    
    translate([(length_p)/2,25,0]) {
        union() {
            for (i = [0:count-1]) {
                translate([0, ((hole_width + space) * i), 0]) {
                    hole();
                }
            }
        }
    }
}
    
module hole() {
    cylinder(r=8, h=5, $fa=0.5, $fs=0.5);
}

module cable() {
    xt = 12; //(length_p - length) + 5;
    yt = 0;
    zt = height_p - height_n;
    
    translate ([xt, yt, zt]) {
        cube([10, 5, 7]);
    }
}

