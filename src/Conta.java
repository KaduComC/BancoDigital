public abstract class Conta implements Servicos {
    private static final int AGENCIA_PADRAO = 0;

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
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

    @Override
    public void sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Valor de saque maior que valor de saldo");
        } else if (valor <= this.saldo) {
            this.saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public String imprimirExtrato() {
        return "Saldo: " + this.saldo;
    }

    @Override
    public String imprimirInfo() {
        return String.format("Titular: %s\nAgencia: %d\nNumero: %d\nSaldo: %.2f", this.cliente.getNome(), this.agencia,
                this.numero, this.saldo);
    }
}
