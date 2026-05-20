import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MatrixFactory {
    public abstract IntegerMatrix create(int rows, int columns);
    public abstract String getTypeName();
    
    public static class Registry {
        private static final List<MatrixFactory> factories = new ArrayList<>();
        private static boolean initialized = false;
        
        public static void register(MatrixFactory factory) {
            factories.add(factory);
        }
        
        public static List<MatrixFactory> getAll() {
            if (!initialized) {
                // Force class loading to trigger static initializers
                try {
                    Class.forName("SnakeMatrix$Factory");
                    Class.forName("PyramidMatrix$Factory");
                } catch (ClassNotFoundException e) {
                    // Ignore
                }
                initialized = true;
            }
            return Collections.unmodifiableList(factories);
        }
    }
}
