package com.auto.fishing;

import java.awt.*;
import java.awt.event.InputEvent;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("The bot will start working in 15 seconds. Get ready");
        for (int i = 1; i <= 15; i++){
            System.out.print(i + "s ");
            Thread.sleep(1000);
        }
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        Images.CallMainAction();
    }
}