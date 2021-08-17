package processing.sketches;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet sketch;
    public PImage castleImage;
    public PImage starImage;
    public PImage mapImage;

    public Castle castle1;
    public Castle castle2;

    public void settings() {
        castleImage = loadImage("castle.png");
        starImage = loadImage("CapitolStar.png");
        mapImage = loadImage("map.png");
        sketch = this;
        size(600, 600);
    }

    public void setup() {
        background(0);
        imageMode(CENTER);
        textAlign(CENTER);
        castle1 = new Castle("Towna", 3000, 123456, 1545.54f,
                "Taj Mahal", true, 150, 350);
        castle2 = new Castle("Townbi", 200, 123457, 2045.54f,
                "Statue of Liberty", false, 300, 50);
    }

    public void draw() {
        image(mapImage, width/2,height/2, width, height);
        drawCity(castle1);
        drawCity(castle2);
    }

    public void drawCity(Castle castle) {
        float w = sqrt(castle.getArea());
        image(castleImage, castle.getLatitude(), castle.getLongitude(), w, w);
        if (castle.isCapitol()) {
            image(starImage, castle.getLatitude() + w/2, castle.getLongitude() - w/2, 15, 15);
        }

        if (dist(castle.getLatitude(), castle.getLongitude(), mouseX, mouseY) < w/2) {
            textSize(14);
            fill(0);
            text(castle.getName(), castle.getLatitude(), castle.getLongitude() - w/2 - 30);
            text("Population: " + castle.getPopulation(), castle.getLatitude(), castle.getLongitude() - w/2 - 10);
        }
    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
