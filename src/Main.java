import java.util.Scanner;

public class Main {
    Conta corrente = new ContaCorrente();
    Conta poupanca = new ContaCorrente();

    public int selecionarConta(){                  
            Scanner input = new Scanner(System.in);

            System.out.println("Selecione a opção desejada: \n 1. Conta Corrente \n 2. Conta Poupança \n 0. Sair");
            int contaSelecionada = 0;

            int conta = input.nextInt();
            switch(conta){
                case 1:{
                    contaSelecionada = 1;
                    break;  
                }
                case 2:{
                    contaSelecionada = 2;                        
                    break;
                }
                case 0: {
                    System.out.println("Programa encerrado");
                    break;
                }
                default:
                System.out.println("Opção inválida. Tente novamente.");
            }
            return contaSelecionada;
        }
        public void sacar(int conta, double valor){
            if(conta == 1){
                corrente.sacar(valor);               
                corrente.imprimirExtrato();              
              
            }else{
                poupanca.depositar(valor);            
                poupanca.imprimirExtrato();                            
            }
        }

        public void depositar(int conta, double valor){
            if(conta == 1){
                corrente.depositar(valor);            
                extrato(conta);
    
            }else{
                poupanca.depositar(valor);              
            }
        }

        public void transferir(int conta, double valor){
            if(conta == 1){
                corrente.transferir(valor, corrente);                
                System.out.println("Seu saldo atual é: " + valor);                
            }else{
                poupanca.transferir(valor, poupanca);               
                System.out.println("Seu saldo atual é: " + valor);                
            }
            extrato(conta);
        }

        public void extrato(int conta){
            if (conta == 1)
            corrente.imprimirExtrato();
            else 
            poupanca.imprimirExtrato();   
        }

    public static void main(String[] args) {        
        System.out.println("Bem vindo ao banco");
        Scanner input = new Scanner(System.in);
        
        Main main = new Main();

        int conta = main.selecionarConta();
        boolean condicao = true;
        while (condicao){
        System.out.println("Digite o número: \n 1. Saque \n 2. Depósito \n 3. Transferência \n 4. Imprimir o extrato \n 0. Sair.");        
        int opcao = input.nextInt();
        switch(opcao){
            case 1: {
                System.out.println("Digite o valor para sacar: ");
                main.sacar(conta,input.nextDouble());
                break;
            }
            case 2: {
                System.out.println("Digite o valor para depositar: ");
                main.depositar(conta,input.nextDouble());
                break;
            }
            case 3: {
                System.out.println("Digite o valor para transferir: ");
                main.transferir(conta,input.nextDouble());
                break;            
            }
            case 4: {
                main.extrato(conta);
                break;            
            }
            case 0: {
                System.out.println("Programa encerrado.");
                condicao = false;
                break;            
            }
            default:
            System.out.println("Opção inválida. Tente novamente.");
            }
        }
        input.close();
    }
}
