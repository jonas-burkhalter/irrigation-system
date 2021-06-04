# [Bewässerungssystem](https://github.com/jonas-burkhalter/irrigation-system)

## Projektidee

Das Ziel dieses Projektes ist es ein Bewässerungssystem zu erstellen. Dazu soll die Bodenfeuchtigkeit gemessen werden
und gegebenenfalls eine Pumpe aktiviert werden.

## Projektabgrenzung

In einem ersten Schritt* wird die Bodenfeuchtigkeit einer Pflanze ermittelt und über das Internet angezeigt. Die Planung
geht jedoch vermehrt auch auf die Weiterentwicklungsmöglichkeiten dieses Projektes ein.

*während den Arbeiten in diesem Semester

### Systemoverview

![Systemoverview](https://user-images.githubusercontent.com/17141580/118129103-0e6bac00-b3fc-11eb-81e8-42eacb44ae79.png)

[Systemoverview.zip](https://github.com/jonas-burkhalter/irrigation-system/files/6472585/Systemoverview.zip)

## Studium

### Energie

Da die zu bewässernden Pflanzen vor dem Fenster stehen, muss das System ohne zusätzlichen Strom auskommen.

* Solar
    * :+1: Einfach zu installieren
    * :+1: Günstig in der Anschaffung
    * :-1: Gibt nur am Tag Strom
* Wind
    * :-1: Kein Platz zum befestigen
    * :-1: Ungleichmässiger Strombezug
* Akku
    * :-1: Muss aufgeladen werden

Um eine dauerhafte Stromversorgung zu garantieren wird eine Kombination der Solarzelle und eines Akkus verwendet.

### Wasser

Das Wasser muss vor dem Fenster in einem Becken aufbewahrt werden. Jede Pflanze hat eine unterschiedliches Bedürfnis an
Wasser, deshalb muss jede Pflanze einzeln Bewässert werden können.

### Sensoren/Aktoren

Während den Recherchen für geeignete Sensoren fand sich folgender Bodenfeuchtigkeitssensor,
der [M5Stack Bewässerungs Unit mit Bodenfeuchtesensor und Pumpe](https://www.bastelgarage.ch/bauteile/bewasserung-pumpen-ventile/m5stack-bewasserungs-unit-mit-bodenfeuchtesensor-und-pumpe)
. Dieser bot in einem vergleichsweise günstigen Angebot sowohl Sensor wie Aktor.

## Planung

### Material

* [ESP32](https://www.bastelgarage.ch/firebeetle-esp32-iot-mikrocontroller-mit-wifi?search=firebeetle)
* [Bodenfeuchtesensor](https://www.bastelgarage.ch/bauteile/bewasserung-pumpen-ventile/m5stack-bewasserungs-unit-mit-bodenfeuchtesensor-und-pumpe)
* [Solar Panel mit Laderegler](https://www.bastelgarage.ch/6v-0-83a-monokristallines-solar-panel-5w)
* [Akku](https://www.bastelgarage.ch/li-ion-akku-3-7v-3200ma-ncr18650b-18650)
* [Adapter](https://www.bastelgarage.ch/m5stack-adapter-grove-auf-grove-5-stuck?search=M5Stack)
* [Kabel](https://www.bastelgarage.ch/50cm-m5stack-grove-kabel-2-stuck)

### Etappierung

* Auslesen der Bodenfeuchtigkeit
* Ausgabe übers Internet
* Sicherstellung der dauerhaften Stromversorgung
* Bewässern*
* Einbinden mehrerer Pflanzen*

*nicht während den Arbeiten in diesem Semester

### Zeitplan

Datum | Beschreibung
------------ | -------------
14.05.2021 | Abgabe Konzept
21.05.2021 | Vorstellen/Besprechen des Konzeps und Bestellen des Material
28.05.2021 | Auslesen der Bodenfeuchtigkeit und Ausgabe ins Internet
04.06.2021 | Zusammenstellen der Stromversorgung
11.06.2021 | Vorstellen des Projekts
