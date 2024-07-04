public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected Double saldo;
    

    public Conta(){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0.0;
    }

    @Override
    public void sacar(double valor) {
        if(valor < saldo){
            saldo -= valor;        
        }else{
            System.out.println("Você não tem saldo suficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;                
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor < saldo){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("Você não tem saldo suficiente.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfoComuns(){
        System.out.println(String.format("Agencia %d",this.agencia));
        System.out.println(String.format("Numero %d",this.numero));
        System.out.println(String.format("Saldo %.2f",this.saldo));

    }
}
