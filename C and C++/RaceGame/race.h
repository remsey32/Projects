#pragma once

// Screen wird gecleared
void screen_setup();

// Startscreen wird generiert
void startscreen();

// Helpscreen -> erklärt das Spiel & die Steuerung
void helpscreen();

// Game Loop wird generiert
void game_loop();

// Game Over wird generiert
void game_over();

// Farben werden generiert
void colors();

// Startanimation wird generiert
void start_animation();

// Spielfigur -> Car
// AussehenG und Eigenschaften des Cars
void draw_car();

// Aussehen und Eigenschaften der Bullet -> Enemie
void draw_bullet();

// Aussehen und Eigenschaften des Tracks
void draw_track();

// Aussehen und Eigenschaften der Kakteen
void draw_cactus();

// Healthanzeige wird generiert
void draw_health();

// Pointsanzeige wird generiert
void draw_points();
