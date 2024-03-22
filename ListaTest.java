
import org.junit.jupiter.api.Test;
import java.util.List;

public class ListaTest {

    @Test
    void testInsertarLista() {
        Lista<Integer> original = new Lista<>();
        original.agregar(1);
        original.agregar(2);
        original.agregar(3);

        Lista<Integer> porAnexar = new Lista<>();
        porAnexar.agregar(4);
        porAnexar.agregar(5);

        // Imprimir la lista original antes de insertar la otra lista
        System.out.print("Lista original: ");
        original.imprimirLista();

        // Imprimir la lista porAnexar
        System.out.print("Lista por anexar: ");
        porAnexar.imprimirLista();

        original.insertarLista(porAnexar);

        // Imprimir la lista original después de insertar porAnexar
        System.out.print("Lista después de insertar porAnexar: ");
        original.imprimirLista();

    }

    @Test
    void testSubLista() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);

        // Imprimir la lista antes de obtener la sublista
        System.out.print("Lista original: ");
        lista.imprimirLista();

        List<Integer> subLista = lista.subLista(0, 4);

        // Imprimir la sublista
        System.out.print("Sublista: ");
        for (Integer num : subLista) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    @Test
    void testInvertir() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);

        // Imprimir la lista original antes de invertirla
        System.out.print("Lista original: ");
        lista.imprimirLista();

        lista.invertir();

        // Imprimir la lista después de invertirla
        System.out.print("Lista invertida: ");
        lista.imprimirLista();

    }
}
