Programmdokumentation
12.08.2020

Vorname: Sven 
Nachname: Remy
Entwicklungssystem & Version: Programmiert wurde auf einem MacBook Pro 2019 mit macOS 10.15.4, in einer Virtual Box mit Lubuntu 16.04.6

Titel: Race
Kurzbeschreibung: 
Bei der kleinen ASCII Art Software Race handelt es sich um ein grafisch Animiertes Arcade Game. Weit weg von jeglicher Zivilisation, im südlichen von Nevada liegt die Mythenumwobene Area 51. Doch was ist dran an den zahlreichen Legenden über dieses Militärgebiet? Spiele jetzt Race und finde es heraus!
"Eines stillen Nachmittags gibt es eine große Explosion. Du wachst erschrocken von deinem Mittagsschlaf auf und siehst lachende Aliens mit einem Auto und der Multigun an dir vorbei rasen. Sofort fliegt der Sound der Sirenen über die trockene Wüstenlandschaft. Du weißt den Aliens zu folgen wird ein gefährliches Unterfangen. Sie könnten mit der neusten Innovation der Multigun auf dich schießen. Doch ohne zu zögern steigst du in dein Auto und nimmst die Verfolgung auf."

Während des Spiels wird man mit der von Aliens gestohlenen Multigun beschossen. Die Bullet der Multigun wird während der Zeit immer größer. Am Anfang bleibt sie noch auf dem Track aber je länger das Spiel geht desto größer wird der Bereich in der sich die Bullet aufhalten kann. Mit der Spielfigur (dem Auto) muss man der Bullet ausweichen und versuchen so lange wie möglich am Leben zu bleiben. Je länger man überlebt desto höher wird die Punktzahl. Wird man drei mal von der Bullet getroffen heißt es aber Game Over.

Programmierkategorien:
Kategorie 1: Menü bzw. Untermenü
Startet man das Spiel, leitet es einen direkt zum Startbildschirm (Menü). Dort hat man mit drücken der ‚q‘ Taste die Möglichkeit das Spiel auch wieder sofort zu verlassen. Mit drücken der ‚h‘ Taste auf der Tastatur gelangt man zum Helpscreen bei dem das Spiel und die Steuerung kurz erklärt werden. Zum starten des Spieles muss die ‚s‘ Taste gedrückt werden. Auch vom Spiel aus hat man die Möglichkeit per drücken der ‚q‘ Taste wieder zum Startbildschirm zu kommen und das Spiel zu pausieren. Mit erneutem drücken der 's' Taste wird das Spiel fortgesetzt.

Kategorie 2: Interaktive Tastatureingabe
Ob beim Navigieren des Menüs oder beim Spielen selbst, muss interaktiv die Tastatur benutzt werden.

Kategorie 3: ASCII Art
Im ganzen Spiel befinden sich Objekte die mit dem ASCII Zeichensatz kreiert wurden. Manche dieser kleinen Kunstwerke befinden sich in einer Animation und andere wurden hinzugefügt um die Welt und Spielsituation besser nachvollziehen zu können.
Es kommen das Logo, ein Auto mit den flüchtenden Aliens, die Spielfigur, und das Spielfeld, bestehend aus dem Track und mehreren Kakteen vor.

Kategorie 4: Einfache Grafische Animation
Direkt beim Starten der Software kommt aus der oberen linken Ecke das Spiele Logo und unten rechts ein Auto mit den zum Spiel passenden Aliens herein gefahren.

Kategorie 5: Grafisch animierte und bewegte Objekte mit Kollisionserkennung
Während des Spiels gibt es die größer werdende Bullet, die zuerst mit dem Straßenrand kollidiert und im Bereich des Tracks bleibt. Ab einem Punktestand von 250 verlässt die Bullet den Trackbereich. Kollidiert sie danach mit den Rand des Bildschirms ändert sie wie im Track die Richtung. Kollidiert sie mit der Spielfigur verliert der Spieler eins von drei Leben.

Tastaturbelegung:
Im Menü:
Mit 's' für start, startet man das Spiel.
Mit 'h' für help, gelangt man zum Helpscreen.
Mit 'q' für Quit, kann das Spiel verlassen werden. Befindet man sich im Helpscreen kommt man mit drücken der Taste zurück zum Startbildschirm.

Im Spiel:
Mit 'w' bewegt sich die Spielfigur nach oben
Mit 'a' bewegt sich die Spielfigur nach links.
Mit 's' bewegt sich die Spielfigur nach unten.
Mit 'd' bewegt sich die Spielfigur nach rechts.
Mit 'q' pausiert man das Spiel und man gelangt zum Startbildschirm

Benutzte Literatur & Links:
Vorlesungen (online), Verfügbar unter: http://schorsch.efi.fh-nuernberg.de/roettger/index.php/Online/C Zugriff am 12.08.2020 12:00

NCurses Video-Tutorial (online), Verfügbar unter: http://schorsch.efi.fh-nuernberg.de/roettger/index.php/NCurses/NCurses Zugriff am 12.08.2020 12:01
Hilfsprogramme: graphics.cpp, graphics.h, gridfont.cpp, gridfont.h

ASCII Art Generator (online), Verfügbar unter: http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20 Zugriff am 28.07.2020 13:15

ASCII Art Archive (online), Verfügbar unter: https://www.asciiart.eu/vehicles/cars
Zugriff am 03.08.2020 15:34

ASCII Art Archive (online), Verfügbar unter: https://www.asciiart.eu/plants/cactus
Zugriff am 06.08.2020 19:57