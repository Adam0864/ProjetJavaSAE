public class ClientGrapheOriente {
    public static void main(String[] args) {
        int[][] tabVoisins={
                {1,2},
                {},
                {5},
                {2,4},
                {5},
                {}
        };
        GrapheOriente g = new GrapheOriente(tabVoisins);
        System.out.println(g.triTopologique());
    }
}
