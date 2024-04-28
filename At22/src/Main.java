public class Main {
    public static void main(String[] args) {
        Conta contaBanco = new Conta("Banco", 100000);
        Banco banco = Banco.getInstance();
        Loja[] lojas = new Loja[2];
        for (int i = 0; i < lojas.length; i++) {
            lojas[i] = new Loja();
        }
        for (Loja loja : lojas) {
            loja.pagarSalarios();
        }
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            Conta contaCliente = new Conta("Cliente " + i, 1000);
            clientes[i] = new Cliente("Cliente " + i, contaCliente);
            clientes[i].start();
        }
    }
}