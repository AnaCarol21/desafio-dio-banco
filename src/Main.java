public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.setNome("Banco DX");

        Cliente cliente = new Cliente();

        cliente.setNome("José");

        Conta cc = new ContaCorrente(cliente);
        cc.depositar(100);

        Conta poupanca = new ContaPoupanca(cliente);
        
        cc.transferir(100, poupanca);
        
        System.out.println(banco.getNome());
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
