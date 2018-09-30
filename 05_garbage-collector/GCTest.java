import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GCTest {
    public static final int UNLUCKY_LEVEL = 1_000_000;
    // to store object name
        String name;
        private static List<GCTest> CHILDREN = new ArrayList<>();
        private static Random RANDOM = new Random();

        public GCTest(String name) {
            this.name = name;
        }

        // Driver method
        public static void main(String args[]) {
            int i = 0;
            while (true) {
                GCTest t1 = new GCTest("t1");
                GCTest t2 = new GCTest("t2");
                CHILDREN.add(t1);
                CHILDREN.add(t2);
                if(RANDOM.nextInt(UNLUCKY_LEVEL) == 42) {
                    System.out.println("Clearing CHILDREN containing " + CHILDREN.size() + " element. Bye bye!");
                    CHILDREN = new ArrayList<>();
                }
                //System.out.println(CHILDREN.size());
            }
        }
}