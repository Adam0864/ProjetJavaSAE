package modele;

public class ClientGrapheOriente {
    public static void main(String[] args) throws Exception {
        int[][] tabVoisins={
                {1,2},
                {},
                {5},
                {2,4},
                {5},
                {}
        };
        GrapheOriente g = new GrapheOriente(new Scenario("s0"));

        System.out.println(g.triTopologique());
    }
}
