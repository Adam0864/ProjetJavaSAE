package modele;

public class ClientScenario {
    public static void main(String[] args) throws Exception {
        Scenario s0 = new Scenario("s0");
        System.out.println(s0.getTransactions().get(new Membre("Psykokwak")).getChVille().toString());

    }
}
