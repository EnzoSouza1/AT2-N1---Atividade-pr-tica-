class Loja {
    private Conta conta;

    public Loja() {
        this.conta = new Conta("Loja", 100000); // Saldo inicial para a loja
    }

    public Conta getConta() {
        return conta;
    }

    public void pagarSalarios() {
        Banco banco = Banco.getInstance();
        Funcionario[] funcionarios = new Funcionario[2];
        for (int i = 0; i < funcionarios.length; i++) {
            Conta contaSalario = new Conta("Funcionário " + i, 0);
            Conta contaInvestimento = new Conta("Investimento " + i, 0);
            funcionarios[i] = new Funcionario("Funcionário " + i, contaSalario, contaInvestimento);
        }
        for (Funcionario funcionario : funcionarios) {
            funcionario.start();
        }

        double totalSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios += 1400.0;
        }

        synchronized (conta) {
            while (true) {
                if (conta.getSaldo() >= totalSalarios) {
                    for (Funcionario funcionario : funcionarios) {
                        banco.transferencia(conta, funcionario.getContaSalario(), 1400.0);
                    }
                    System.out.println("Pagamento de salário de R$" + totalSalarios + " realizado para os funcionários da loja");
                    break;
                }
            }
        }
    }

    public static Conta getRandomConta() {
        return new Conta("Cliente", 0);
    }
}
