main();

//////////
// Case //
//////////
module main() {
    translate ([5, 5, 0]) {
        union()
        {
            main_positiv();
            main_negativ();
        }
    }
}

module main_negativ() {
    translate ([-1, -1, 3]) {
        cube([107, 107, 3]);
    }
}

module main_positiv() {
    minkowski() {
        cube([105, 105, 1]);
        cylinder(r=5,h=3);
    }
}