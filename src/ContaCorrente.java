public class ContaCorrente extends Conta {

    public ContaCorrente() {
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("~~ Extrato Conta Corrente ~~");
        super.imprimirInfoComuns();
    }
}
