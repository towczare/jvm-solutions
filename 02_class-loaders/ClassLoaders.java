import com.sun.javafx.util.Logging;
import java.util.ArrayList;

public class ClassLoaders {
    public static void main(String[] args) throws ClassNotFoundException {
        printClassLoaders();
    }

    public static void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + ClassLoaders.class.getClassLoader());

        System.out.println("Classloader of Logging:"
                + Logging.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}
