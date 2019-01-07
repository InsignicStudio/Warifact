package fr.catsuri33.warifact.engineTester;

import fr.catsuri33.warifact.renderEngine.DisplayManager;
import fr.catsuri33.warifact.renderEngine.Loader;
import fr.catsuri33.warifact.renderEngine.RawModel;
import fr.catsuri33.warifact.renderEngine.Renderer;
import fr.catsuri33.warifact.shaders.StaticShader;
import org.lwjgl.opengl.Display;

public class MainGameLoop {

    public static void main(String[] args) {

        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f
        };

        int[] indices = {
                0,1,3,
                3,1,2
        };

        RawModel model = loader.loadToVAO(vertices, indices);

        while(!Display.isCloseRequested()){

            // game logic
            renderer.prepare();
            shader.start();
            renderer.render(model);
            shader.stop();
            DisplayManager.updateDisplay();

        }

        shader.cleanUP();
        loader.cleanUP();
        DisplayManager.closeDisplay();

    }

}
