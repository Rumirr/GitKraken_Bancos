package EntidadBancaria.entidadBancaria;

import java.util.regex.Pattern;

public class Cuenta {
    private Banco banco;
    private Cliente cliente;
    private String identificadorCuenta;
    private double saldo;


    public boolean comprobarSaldoParaOperacion(double cantidad) {
        return (!(cantidad > this.saldo) && !(this.saldo <= 0));
    }

    public boolean tranferencia(Cuenta destino, double cantidad) {
        if (comprobarSaldoParaOperacion(cantidad)) {
            if (!this.cliente.equals(destino.cliente) || !this.banco.equals(destino.banco)) {
                destino.saldo += cantidad;
                this.saldo -= cantidad;
                return true;
            }
        }
        return false;
    }

    public boolean traspaso(Cuenta destino, double cantidad) {
        if (comprobarSaldoParaOperacion(cantidad)) {
            if (this.banco.equals(destino.banco) && this.cliente.equals(destino.cliente)) {
                destino.saldo += cantidad;
                this.saldo -= cantidad;
                return true;
            }
        }
        return false;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getIdentificadorCuenta() {
        return identificadorCuenta;
    }

    public void setIdentificadorCuenta(String identificadorCuenta) {
        if (Pattern.matches("\\d{20}", identificadorCuenta)) {
            this.identificadorCuenta = identificadorCuenta;
            this.banco.setIdentificador(this.identificadorCuenta.substring(0, 4));
            return;
        }
        System.out.println("No es un número de cuenta válido.");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
