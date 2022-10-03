import javax.swing.JOptionPane;

public class Mian {
    public static void main(String[] args) {
        Cliente kadu = new Cliente();
        kadu.setNome("Kadu");

        Conta cc = new ContaCorrente(kadu);
        Conta cp = new ContaPoupanca(kadu);

        cc.depositar(100);
        cc.transferir(50, cp);
        cc.imprimirExtrato();

        cp.imprimirInfo();
        int opcaoConta;
        int opcao;
        double valor;

        opcaoConta = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Escolha:\n1 - Conta Corrente\n2 - Conta Poupança"));

        if (opcaoConta == 1) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - Dados\n2 - Sacar\n3 - Depositar\n4 - Transferir\n5 - Extrato"));
            switch (opcao) {
                case 1:
                    JOptionPane.showMessageDialog(null, cp.imprimirInfo());
                    break;
                case 2:
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "" + cc.imprimirExtrato() + "\nInforme o valor a ser sacado"));
                    cc.sacar(valor);
                    JOptionPane.showMessageDialog(null, cc.imprimirExtrato());
                    break;

                case 3:
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "" + cc.imprimirExtrato() + "\nInforme o valor a ser depositado"));
                    cc.depositar(valor);
                    JOptionPane.showMessageDialog(null, cc.imprimirExtrato());
                    break;
                case 4:
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "" + cc.imprimirExtrato() + "\nInforme o valor a ser transferido"));
                    cc.transferir(valor, cp);
                    JOptionPane.showMessageDialog(null, cc.imprimirExtrato());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, cc.imprimirExtrato());
                    break;
                default:
                    break;
            }
        } else if (opcaoConta == 2) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - Dados\n2 - Sacar\n3 - Depositar\n4 - Transferir\n5 - Extrato"));
            switch (opcao) {
                case 1:
                    JOptionPane.showMessageDialog(null, cp.imprimirInfo());
                    break;
                case 2:
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "" + cp.imprimirExtrato() + "\nInforme o valor a ser sacado"));
                    cp.sacar(valor);
                    JOptionPane.showMessageDialog(null, cp.imprimirExtrato());
                    break;

                case 3:
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "" + cp.imprimirExtrato() + "\nInforme o valor a ser depositado"));
                    cp.depositar(valor);
                    JOptionPane.showMessageDialog(null, cp.imprimirExtrato());
                    break;
                case 4:
                    valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                            "" + cp.imprimirExtrato() + "\nInforme o valor a ser transferido"));
                    cp.transferir(valor, cc);
                    JOptionPane.showMessageDialog(null, cp.imprimirExtrato());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, cp.imprimirExtrato());
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Opcao inválido");
        }
    }
}
