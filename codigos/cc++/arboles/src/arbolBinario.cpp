#include <iostream>

using namespace std;

struct Nodo {
    Nodo* izq;
    int dato;
    Nodo* der;
};

Nodo* insertarNodo(Nodo* raiz, int dato) {
    Nodo* nodo = new Nodo();
    if ( dato != NULL ) {
        nodo->dato = dato;
        nodo->izq = nodo->der = nullptr;
    } else {
        nodo = nullptr;
    }
    if ( dato < raiz->dato ) {
        if (raiz->izq == nullptr) {
            raiz->izq = nodo;
        } else {
            insertarNodo(raiz->izq, dato);
        }
    } else {
        if (raiz->der == nullptr) {
            raiz->der = nodo;
        } else {
            insertarNodo(raiz->der, dato);
        }
    }
    return nodo;
}

Nodo* insertarNodo(int dato) {
    Nodo* nodo = new Nodo();
    nodo->dato = dato;
    nodo->izq = nodo->der = nullptr;
    return nodo;
}

int main () {
    Nodo* actual = new Nodo();
    Nodo* raiz = insertarNodo(10);
    actual = insertarNodo(raiz, 5);
    actual = insertarNodo(raiz, 20);

}