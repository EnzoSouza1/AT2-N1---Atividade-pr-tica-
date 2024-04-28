import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Banco {
    private static Banco instance = new Banco();
    private Lock lock = new ReentrantLock();

    private Banco() {
    }

    public static Banco getInstance() {
        return instance;
    }

    public void transferencia(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transferência de R$" + valor + " de " + origem.getProprietario() + " para " + destino.getProprietario());
            System.out.println("Saldo final de " + origem.getProprietario() + ": R$" + origem.getSaldo());
            System.out.println("Saldo final de " + destino.getProprietario() + ": R$" + destino.getSaldo());
        } finally {
            lock.unlock();
        }
    }
}