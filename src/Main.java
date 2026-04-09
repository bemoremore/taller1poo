import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        StdDraw.setCanvasSize(800,600);
        StdDraw.setTitle("PONG");
        StdDraw.setXscale(0.0,1.0);
        StdDraw.setYscale(0.0,1.0);
        StdDraw.enableDoubleBuffering();

        while (true) {

            int opcion = showMenu();

            if (opcion == 1) {
                System.out.println("Empieza el juego");
                juego();
            }
        }

    }

    static int showMenu(){
        StdDraw.pause(200);

        while (true) {
            StdDraw.clear(StdDraw.BLACK);
            StdDraw.setFont(new Font("Monospaced", Font.BOLD, 33));
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.text(0.5,0.75,"Mini PONG");

            StdDraw.show();
            StdDraw.pause(20);

            if (StdDraw.isKeyPressed('1')) {
                return 1;
            }

        }
    }

    public static void juego() {
        double pelotaX = 0.5;
        double pelotaY = 0.5;
        double radio = 0.02;

        double velocidadX = 0.016;
        double velocidadY = 0.01;

        double romboY = 0.5;
        double romboX = 0.03;
        int rebotes = 0;

        //Pasue

        while (true) {

            if (StdDraw.isKeyPressed('Q')) {
                break;
            }

            if (StdDraw.isKeyPressed('W') && romboY < 0.9) {
                romboY += 0.02;
            }
            if (StdDraw.isKeyPressed('S') && romboY > 0.1) {
                romboY -= 0.02;
            }
            if (pelotaY >= 1.0 || pelotaY <= 0.0)
            {
                velocidadY *= -1;
            }

            if (pelotaX >= 1.0) {
                velocidadX *= -1;
            }

            if (pelotaX <= 0.05 && pelotaY >= romboY - 0.1 && pelotaY <= romboY + 0.1) {
                velocidadX = Math.abs(velocidadX);
                rebotes++;
            }

            if (pelotaX < 0.0) {
                pelotaX = 0.5;
                pelotaY = 0.5;
                rebotes = 0;
            }

            pelotaY += velocidadY;
            pelotaX += velocidadX;
            StdDraw.clear();
            StdDraw.picture(0.5,0.5,"fondo.jpeg",1.0,1.0);


            StdDraw.setPenColor(StdDraw.MAGENTA);
            StdDraw.filledCircle(pelotaX,pelotaY,radio);

            StdDraw.setPenColor(StdDraw.CYAN);
            StdDraw.filledRectangle(romboX,romboY,0.02,0.1);

            StdDraw.text(0.5,0.05,"Rebotes: " + rebotes);
            StdDraw.show();
            StdDraw.pause(20);
        }


    }
    }