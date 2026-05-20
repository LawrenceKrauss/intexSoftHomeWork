public interface IntegerMatrix {
    int[][] getMatrix();
    
    default String getName() {
        return this.getClass().getSimpleName().replace("Matrix", "");
    }
}
