package jade;

import observers.EventSystem;
import observers.Observer;
import observers.events.Event;
import org.joml.Vector4f;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;
import org.lwjgl.opengl.GL;
import physics2d.Physics2D;
import renderer.*;
import scenes.LevelEditorSceneInitializer;
import scenes.LevelSceneInitializer;
import scenes.Scene;
import scenes.SceneInitializer;
import util.AssetPool;

import static java.lang.foreign.MemorySegment.NULL;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window
{
    private int width,height;
    private String title;
    private long glfwWindow;

    private static Window window=null;
    private Window()
    {
        this.width=1920;
        this.height=1080;
        this.title="POPOYE";

    }
    public static Window get()
    {
        if(Window.window==null)
        {
            Window.window=new Window();
        }
        return Window.window;
    }
    public void run()
    {
        System.out.println("Hello LWJGL "+Version.getVersion()+"!");

        init();
        loop();
    }
    public void init()
    {
        //setup error callback

        GLFWErrorCallBack().createPrint(System.err).set();
        // initialize glfw
        if(!glfwInit())
        {
            throw new IllegalStateException("unable to initialize glfw");
        }
        // configure glfw
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

        // create the window
        glfwWindow=glfwCreateWindow(this.width,this.height,this.title,NULL,NULL);
        if(glfwWindow==null)
        {
            throw new IllegalStateException("Failed to create the glfw window");
        }
        //make the oepn Gl context current
        glfwMakeContextCurrent(glfwWindow);
        // enable vsync
        glfwSwapInterval(1);

        //make the window visible
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();
    }


    public void loop()
    {

    }
}
