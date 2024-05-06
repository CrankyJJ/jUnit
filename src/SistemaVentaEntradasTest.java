import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
    @AfterEach
    void vaciarTests() {
        venta.vaciarCine();
    }

    @Test
    void anyadirSala() {
        boolean resultado;

       resultado = venta.anyadirSala(1,"Spiderman");

       resultado = venta.anyadirSala(1,"Superman");


        assertTrue(resultado, ""+resultado);
    }

    @org.junit.jupiter.api.Test
    void comprarEntrada() {
        venta.anyadirSala(1,"Spiderman");
        Entrada entrada = new Entrada(1,8,10.0);
        venta.getEntradas().add(entrada);
        venta.calcularPrecioEntrada(entrada.getNumButaca());

        //todo: preguntar a chema

    }

    @org.junit.jupiter.api.Test
    //Deberá obtener cuántas entradas se han vendido para la sala solicitada
    void getEntradasVendidasPorSala() {

        venta.anyadirSala(1,"spiderman");

        venta.comprarEntrada(1,1);
        venta.comprarEntrada(1,3);

        int entradaVendida = venta.getEntradasVendidasPorSala(1);

        assertEquals(2,entradaVendida);
    }

    @org.junit.jupiter.api.Test
        //Deberá sumartodo lo cobrado por las entradas vendidas y devolverlo
    void totalRecaudacionTest() {
        Entrada precio1 = new Entrada(1,2,12.1);
        Entrada precio2 = new Entrada(1,4,12.1);

        venta.getEntradas().add(precio1);
        venta.getEntradas().add(precio2);

        assertEquals(24.2, venta.totalRecaudacion());
    }

    @org.junit.jupiter.api.Test
    void calcularPrecioEntrada() {
        venta.calcularPrecioEntrada(2);
        venta.calcularPrecioEntrada(10);
        venta.calcularPrecioEntrada(25);

        assertEquals(10,venta.calcularPrecioEntrada(2));
        System.out.println(venta.calcularPrecioEntrada(2));

        assertEquals(8,venta.calcularPrecioEntrada(15));
        System.out.println(venta.calcularPrecioEntrada(15));

        assertEquals(5,venta.calcularPrecioEntrada(25));
        System.out.println(venta.calcularPrecioEntrada(25));
    }

    @org.junit.jupiter.api.Test
    void vaciarCine() {
        venta.anyadirSala(2,"ppp");
        venta.comprarEntrada(2,4);
        venta.vaciarCine();

        assertEquals(true,venta.getSalas().isEmpty());
        assertEquals(true,venta.getEntradas().isEmpty());
    }
}