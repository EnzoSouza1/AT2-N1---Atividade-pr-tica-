class Conta {
    private String proprietario;
    private double saldo;
    private final Object lock = new Object();

    public Conta(String proprietario, double saldo) {
        this.proprietario = proprietario;
        this.saldo = saldo;
    }

    public void creditar(double valor) {
        synchronized (lock) {
            saldo += valor;
        }
    }

    public void debitar(double valor) {
        synchronized (lock) {
            saldo -= valor;
        }
    }

    public String getProprietario() {
        return proprietario;
    }

    public double getSaldo() {
        synchronized (lock) {
            return saldo;
        }
    }
}
