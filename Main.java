public class Main {

    // Clase que representa un nodo de la lista
    static class Node {
        int value;   // Valor que guarda el nodo
        Node next;   // Referencia al siguiente nodo

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Clase que representa la lista ligada
    static class ListaLigada {
        Node head;  // Primer nodo
        Node tail;  // Ultimo nodo
        int size;   // Cantidad de elementos

        ListaLigada() {
            head = null;
            tail = null;
            size = 0;
        }

        // Agrega un elemento al final
        public void append(int value) {
            Node nuevo = new Node(value);
            if (head == null) {
                head = nuevo;
                tail = nuevo;
            } else {
                tail.next = nuevo;
                tail = nuevo;
            }
            size++;
        }

        // Agrega un elemento al inicio
        public void prepend(int value) {
            Node nuevo = new Node(value);
            nuevo.next = head;
            head = nuevo;
            if (tail == null) {
                tail = nuevo;
            }
            size++;
        }

        // Elimina y retorna el ultimo nodo
        public Node removeLast() {
            if (head == null) {
                throw new java.util.NoSuchElementException("La lista esta vacia");
            }

            Node eliminado = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node actual = head;
                while (actual.next != tail) {
                    actual = actual.next;
                }
                actual.next = null;
                tail = actual;
            }
            size--;
            eliminado.next = null;
            return eliminado;
        }

        // Elimina y retorna el primer nodo
        public Node removeFirst() {
            if (head == null) {
                throw new java.util.NoSuchElementException("La lista esta vacia");
            }

            Node eliminado = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            eliminado.next = null;
            size--;
            return eliminado;
        }

        // Retorna el nodo ubicado en el indice indicado
        public Node get(int index) {
            validarIndice(index);
            Node actual = head;
            for (int i = 0; i < index; i++) {
                actual = actual.next;
            }
            return actual;
        }

        // Cambia el valor del nodo ubicado en el indice indicado
        public void set(int index, int value) {
            Node actual = get(index);
            actual.value = value;
        }

        // Inserta un nodo en la posicion indicada
        public void insert(int index, int value) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Indice fuera de rango");
            }
            if (index == 0) {
                prepend(value);
                return;
            }
            if (index == size) {
                append(value);
                return;
            }

            Node anterior = get(index - 1);
            Node nuevo = new Node(value);
            nuevo.next = anterior.next;
            anterior.next = nuevo;
            size++;
        }

        // Elimina y retorna el nodo ubicado en el indice indicado
        public Node remove(int index) {
            validarIndice(index);
            if (index == 0) {
                return removeFirst();
            }
            if (index == size - 1) {
                return removeLast();
            }

            Node anterior = get(index - 1);
            Node eliminado = anterior.next;
            anterior.next = eliminado.next;
            eliminado.next = null;
            size--;
            return eliminado;
        }

        // Invierte las conexiones de los nodos
        public void reverse() {
            Node anterior = null;
            Node actual = head;
            Node siguiente;
            tail = head;

            while (actual != null) {
                siguiente = actual.next;
                actual.next = anterior;
                anterior = actual;
                actual = siguiente;
            }
            head = anterior;
        }

        // Encuentra el nodo medio con dos punteros
        public Node findMiddleNode() {
            if (head == null) {
                return null;
            }

            Node lento = head;
            Node rapido = head;

            while (rapido != null && rapido.next != null) {
                lento = lento.next;
                rapido = rapido.next.next;
            }
            return lento;
        }

        // Detecta un ciclo con el algoritmo de Floyd
        public boolean hasLoop() {
            Node lento = head;
            Node rapido = head;

            while (rapido != null && rapido.next != null) {
                lento = lento.next;
                rapido = rapido.next.next;

                if (lento == rapido) {
                    return true;
                }
            }
            return false;
        }

        // Verifica que el indice sea valido
        private void validarIndice(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Indice fuera de rango");
            }
        }

        // Imprime los valores de la lista
        public void mostrar() {
            Node actual = head;
            while (actual != null) {
                System.out.print(actual.value + " -> ");
                actual = actual.next;
            }
            System.out.println("null");
        }

        // Retorna la cantidad de nodos
        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        System.out.println("AGREGAR ELEMENTOS");
        lista.append(10);
        lista.append(20);
        lista.append(30);
        lista.prepend(5);
        lista.mostrar();

        System.out.println("\\nOBTENER UN NODO");
        System.out.println("Indice 2: " + lista.get(2).value);

        System.out.println("\\nMODIFICAR UN VALOR");
        lista.set(1, 15);
        lista.mostrar();

        System.out.println("\\nINSERTAR UN NODO");
        lista.insert(2, 17);
        lista.mostrar();

        System.out.println("\\nELIMINAR POR INDICE");
        System.out.println("Eliminado: " + lista.remove(2).value);
        lista.mostrar();

        System.out.println("\\nELIMINAR EL PRIMERO");
        System.out.println("Eliminado: " + lista.removeFirst().value);
        lista.mostrar();

        System.out.println("\\nELIMINAR EL ULTIMO");
        System.out.println("Eliminado: " + lista.removeLast().value);
        lista.mostrar();

        System.out.println("\\nINVERTIR LA LISTA");
        lista.reverse();
        lista.mostrar();

        System.out.println("\\nNODO MEDIO");
        Node medio = lista.findMiddleNode();
        if (medio != null) {
            System.out.println("Valor medio: " + medio.value);
        } else {
            System.out.println("La lista esta vacia");
        }

        System.out.println("\\nDETECTAR CICLOS");
        System.out.println("Tiene ciclo: " + lista.hasLoop());

        System.out.println("\\nTAMANO DE LA LISTA");
        System.out.println(lista.size());
    }
}
