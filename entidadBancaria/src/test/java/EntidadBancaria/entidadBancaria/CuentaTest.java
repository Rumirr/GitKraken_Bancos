package EntidadBancaria.entidadBancaria;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CuentaTest {
    private Banco b1, b2;
    private Cliente c1, c2;
    private Cuenta cuentaCliente1, cuenta2Cliente1, cuentaCliente2;

    @Before
    public void setup() {
        b1 = new Banco("BBVA");
        b2 = new Banco("Banco popular");

        // Cliente 1
        c1 = new Cliente();
        c1.setDni("11832425Y");
        c1.setNombre("José Antonio");
        c1.setApellidos("Gonzalez Esteban");
        c1.setDireccion("c/ pinos");
        c1.setTelefono(971222333);

        // Cliente 2
        c2 = new Cliente();
        c2.setDni("13736898X");
        c2.setNombre("César");
        c2.setApellidos("Blanco Nuñez");
        c2.setDireccion("c/ pins");
        c2.setTelefono(971444555);

        // Cuentas cliente 1
        cuentaCliente1 = new Cuenta();
        cuentaCliente1.setBanco(b1);
        cuentaCliente1.setCliente(c1);
        cuentaCliente1.setIdentificadorCuenta("00491111222233334444");
        cuentaCliente1.setSaldo(100.00);

        cuenta2Cliente1 = new Cuenta();
        cuenta2Cliente1.setBanco(b1);
        cuenta2Cliente1.setCliente(c1);
        cuenta2Cliente1.setIdentificadorCuenta("00492222333344445555");
        cuenta2Cliente1.setSaldo(25);

        //Cuenta cliente 2
        cuentaCliente2 = new Cuenta();
        cuentaCliente2.setBanco(b2);
        cuentaCliente2.setCliente(c2);
        cuentaCliente2.setIdentificadorCuenta("00501111222233334444");
        cuentaCliente2.setSaldo(69.6);
    }

    // Ejercicio 03
    
    @Test
    public void testMismoClienteCuentasDiferentes() {
        assertTrue(cuentaCliente1.getCliente().equals(cuenta2Cliente1.getCliente()));
    }

    @Test
    public void testDiferentesClientesCuentasDiferentes() {
        assertFalse(cuentaCliente1.getCliente().equals(cuentaCliente2.getCliente()));
    }

    // Ejercicio 04
    @Test
    public void testSaldoCuentaOrigenTransferencia() {
        cuentaCliente1.tranferencia(cuentaCliente2, 1);
        assertEquals(99, cuentaCliente1.getSaldo(), 0);
    }

    // Ejercicio 05
    @Test
    public void testSaldoCuentaDestinoTranferencia() {
        cuentaCliente1.tranferencia(cuentaCliente2, 1);
        assertEquals(70.6, cuentaCliente2.getSaldo(), 0);
    }

    // Ejercicio 06
    @Test
    public void testSaldoParaTranferenciaTrue() {
        assertTrue(cuentaCliente1.comprobarSaldoParaOperacion(50));
    }

    @Test
    public void testSaldoParaTranferenciaFalse() {
        assertFalse(cuentaCliente1.comprobarSaldoParaOperacion(200));
    }

    // Ejercicio 07
    @Test
    public void testTraspaso() {
        assertTrue(cuentaCliente1.traspaso(cuenta2Cliente1, 80));
    }

}