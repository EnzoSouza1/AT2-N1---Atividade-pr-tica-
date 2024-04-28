class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario(String nome, Conta contaSalario, Conta contaInvestimento) {
        super(nome);
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    @Override
    public void run() {
        Banco banco = Banco.getInstance();
        while (true) {
            double salario = 1400.0;
            banco.transferencia(Loja.getRandomConta(), contaSalario, salario);
            double valorInvestimento = salario * 0.2;
            contaInvestimento.creditar(valorInvestimento);
            System.out.println(getName() + " recebeu salário de R$" + salario + ", investiu R$" + valorInvestimento +
                    " e o saldo atual da conta de investimento é R$" + contaInvestimento.getSaldo());
        }
    }
}
