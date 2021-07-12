package com.auto.fishing;

import javax.imageio.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Images {
    private static int[] arrayOfPixels = new int[5625];
    private static Color[] colors = new Color[5625];

    private static boolean ColorHere(Color color) {
        if (color.getRed() > 190 & color.getGreen() > 220 & color.getBlue() < 210) {
            return true;
        }
        return false;
    }

    private static boolean ColorNotExist(Color color) {
        if (color.getRed() < 190 & color.getGreen() > 180 & color.getBlue() < 250) {
            return true;
        }
        return false;
    }

    private static File TookScreenshot() throws Exception {
        while (true) {
            Robot robot = new Robot();
            BufferedImage screenshot = robot.createScreenCapture(new Rectangle(MouseInfo.getPointerInfo().getLocation().x - 32, MouseInfo.getPointerInfo().getLocation().y - 32, 75, 75));
            File ss = new File("Screenshots\\ss.png");
            ImageIO.write(screenshot, "PNG", ss);
            Thread.sleep(50);
            return ss;
        }
    }

    public static void CallMainAction() throws Exception {
        AnaliseImage(TookScreenshot());
    }

    private static void AnaliseImage(File image) throws Exception {
        Robot bot = new Robot();
        BufferedImage img = ImageIO.read(image);
        for (int l = 0; l < img.getWidth(); l++) {
            for (int j = 0; j < img.getHeight(); j++) {
                for (int k = 0; k < arrayOfPixels.length; k++) {
                    arrayOfPixels[k] = img.getRGB(l, j);
                    colors[k] = new Color(arrayOfPixels[k]);

                    if (ColorHere(colors[k])) {
                        System.out.println("Yellow is here");
                        CallMainAction();
                    }

                    if (ColorNotExist(colors[k])) {
                        Thread.sleep(250);
                        System.out.println("Catching!");
                        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        Thread.sleep(20);
                        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        Thread.sleep(500);
                        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        Thread.sleep(20);
                        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        Thread.sleep(2000);
                        CallMainAction();
                    }
                }
            }
        }
    }
}

