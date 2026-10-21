# Proyecto de Listas Ligadas en Java

Proyecto escolar que implementa una lista simplemente ligada sin utilizar `LinkedList` de Java.

## Cómo ejecutar
1. Abre el proyecto o crea una clase llamada `Main`.
2. Copia `Main.java`.
3. Ejecuta el método `main`.

## Métodos incluidos
- `append(int value)`: agrega al final.
- `prepend(int value)`: agrega al inicio.
- `removeLast()`: elimina y retorna el último nodo.
- `removeFirst()`: elimina y retorna el primer nodo.
- `get(int index)`: retorna el nodo de un índice.
- `set(int index, int value)`: modifica el valor de un nodo.
- `insert(int index, int value)`: inserta en una posición.
- `remove(int index)`: elimina y retorna un nodo por índice.
- `reverse()`: invierte la lista.
- `findMiddleNode()`: encuentra el nodo medio con dos punteros.
- `hasLoop()`: detecta ciclos con el algoritmo de Floyd.

También incluye `mostrar()`, `size()` y validación de índices.

## Nota
`findMiddleNode()` y `hasLoop()` usan tiempo O(n) y espacio adicional O(1).
