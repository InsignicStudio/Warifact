package fr.catsuri33.warifact.engineTester;

import fr.catsuri33.warifact.renderEngine.DisplayManager;
import org.lwjgl.opengl.Display;

public class MainGameLoop {

    public static void main(String[] args) {

        DisplayManager.createDisplay();

        while(!Display.isCloseRequested()){

            DisplayManager.updateDisplay();

        }

        DisplayManager.closeDisplay();

    }

}
