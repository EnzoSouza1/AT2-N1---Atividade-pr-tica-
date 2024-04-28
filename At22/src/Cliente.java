class Cliente extends Thread {
    private Conta conta;

    public Cliente(String nome, Conta conta) {
        super(nome);
        this.conta = conta;
    }

    @Override
    public void run() {
        while (true) {
            double valorCompra = Math.random() < 0.5 ? 100.0 : 200.0;
            Banco banco = Banco.getInstance();
            banco.transferencia(conta, Loja.getRandomConta(), valorCompra);
            if (conta.getSaldo() <= 0) {
                break;
            }
        }
    }
}
