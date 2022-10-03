
public interface Servicos {
    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    String imprimirInfo();

    String imprimirExtrato();
}
