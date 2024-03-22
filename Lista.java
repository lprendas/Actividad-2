import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lista<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamaño;

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public Lista() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void insertarLista(Lista<T> porAnexar) {
        if (porAnexar == null)
            return;

        Nodo<T> nodoActual = porAnexar.cabeza;
        while (nodoActual != null) {
            agregar(nodoActual.valor);
            nodoActual = nodoActual.siguiente;
        }
    }

    public List<T> subLista(int inicio, int tamaño) {
        if (inicio < 0 || inicio >= this.tamaño || tamaño <= 0) {
            throw new IllegalArgumentException("Parámetros de sublista no válidos.");
        }

        List<T> subLista = new ArrayList<>();
        Nodo<T> nodoActual = this.cabeza;
        for (int i = 0; i < inicio; i++) {
            nodoActual = nodoActual.siguiente;
        }
        for (int i = 0; i < tamaño; i++) {
            subLista.add(nodoActual.valor);
            nodoActual = nodoActual.siguiente;
        }
        return subLista;
    }

    public void invertir() {
        Nodo<T> nodoActual = cabeza;
        Nodo<T> previo = null;
        Nodo<T> siguiente = null;
        while (nodoActual != null) {
            siguiente = nodoActual.siguiente;
            nodoActual.siguiente = previo;
            previo = nodoActual;
            nodoActual = siguiente;
        }
        cabeza = previo;
    }

    public void agregar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        tamaño++;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void imprimirLista() {
        Nodo<T> nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.print(nodoActual.valor + " ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println();
    }

    public Iterator<T> iterator() {
        return new Iterador();
    }

    private class Iterador implements Iterator<T> {
        private Nodo<T> nodoActual = cabeza;

        @Override
        public boolean hasNext() {
            return nodoActual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No hay más elementos en la lista");
            }
            T valor = nodoActual.valor;
            nodoActual = nodoActual.siguiente;
            return valor;
        }
    }
}