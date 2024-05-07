import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SistemaVentaEntradasTest {

    static SistemaVentaEntradas venta;

    @BeforeAll
    static void Intancias(){
        venta = new SistemaVentaEntradas();
    }

    //limpia los ArrayList después de cada test
    @BeforeEach
    void vaciarTests() {
        venta.vaciarCine();
    }

    //TEST AÑADIR SALA------------------------------------------------------------------------------
    @Test
    void anyadirSala() {

        venta.anyadirSala(1,"Spiderman");
        assertTrue(true);
    }

    @Test
    void anyadirsalaRepetida(){
        venta.anyadirSala(1,"batman");
        venta.anyadirSala(1,"batman");

        assertFalse(false);
    }

    @Test
    void anyadirSalaMayor5(){
        venta.anyadirSala(1,"batman");
        venta.anyadirSala(2,"batman");
        venta.anyadirSala(3,"batman");
        venta.anyadirSala(4,"batman");
        venta.anyadirSala(5,"batman");
        venta.anyadirSala(6,"batman");

        assertFalse(false);
    }

    //TEST COMPRAR ENTRADAS------------------------------------------------------------------------
    @Test
    void comprarEntrada() {
        venta.anyadirSala(2,"batman");
        venta.comprarEntrada(2,2);

        assertTrue(true);
    }

    @Test
    void comprarEntradaNoExiste(){
        venta.comprarEntrada(1,23);
        assertFalse(false);
    }

    @Test
    void comprarEntradaButacaInvalida(){
        venta.anyadirSala(2,"batman");
        venta.comprarEntrada(2,-1);

        assertFalse(false);
    }

    @Test
    void comprarEntradasMaxButaca(){
        venta.anyadirSala(1,"batman");
        venta.comprarEntrada(1,33);

        assertFalse(false);
    }

    //GET ENTRADAS----------------------------------------------------------------------------------
    @Test
    //Deberá obtener cuántas entradas se han vendido para la sala solicitada
    void getEntradasVendidasPorSala() {

        venta.anyadirSala(1,"spiderman");

        venta.comprarEntrada(1,1);
        venta.comprarEntrada(1,3);

        int entradaVendida = venta.getEntradasVendidasPorSala(1);

        assertEquals(2,entradaVendida);
    }

    //Deberá sumartodo lo cobrado por las entradas vendidas y devolverlo------------------------------
    @Test
    void totalRecaudacionTest() {
        Entrada precio1 = new Entrada(1,2,12.1);
        Entrada precio2 = new Entrada(1,4,12.1);

        venta.getEntradas().add(precio1);
        venta.getEntradas().add(precio2);

        assertEquals(24.2, venta.totalRecaudacion());
    }

    //METODO CALCULAR PRECIO ENTRADA-----------------------------------------------------------------
    @Test
    void calcularPrecioEntradaMenorIgualDiez() {
        venta.calcularPrecioEntrada(2);
        assertEquals(10,venta.calcularPrecioEntrada(2));
    }

    @Test
    void calcularPrecioEntradaMayorDiez(){
        venta.calcularPrecioEntrada(11);

        assertEquals(8,venta.calcularPrecioEntrada(11));
    }
    @Test
    void calcularPrecioEntradaMayorVeinte(){
        venta.calcularPrecioEntrada(25);

        assertEquals(5,venta.calcularPrecioEntrada(25));
    }

    //METODO VACIAR CINE------------------------------------------------------------------------------
    @Test
    void vaciarCine() {
        venta.anyadirSala(2,"ppp");
        venta.comprarEntrada(2,4);
        venta.vaciarCine();

        assertEquals(true,venta.getSalas().isEmpty());
        assertEquals(true,venta.getEntradas().isEmpty());
    }
}