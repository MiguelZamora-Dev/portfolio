#include <iostream>

using namespace std;

struct Nodo {
    Nodo* ant;
    int dato;
    Nodo* sig;
};

Nodo* crearNodo (int dato) {
    if (dato) {
        Nodo* nodo = new Nodo();
        nodo->dato = dato;
        nodo->ant = nodo->sig = nullptr;
        return nodo;
    }
}

Nodo* buscarUltimo (Nodo* base) {
    if (base) {
        if (base->sig) {
            buscarUltimo(base->sig);
        } else {
            return base;
        }
    }
}

void insertar (Nodo* ultimo, Nodo* nodo) {
    if (ultimo && nodo) {
        ultimo->sig = nodo;
        nodo->ant = ultimo;
    }
}

void liberarMem (Nodo* nodo) {
    if (nodo) {
        free(nodo);
    }
}

Nodo* buscarPrimero (Nodo* nodo) {
    if (nodo) {
        if (nodo->ant) {
            buscarPrimero(nodo->ant);
        } else {
            return nodo;
        }
    }
}

Nodo* quitar (Nodo* primero) {
    if (primero && primero->sig) {
        primero->sig->ant = nullptr;
        liberarMem(primero);
        return primero->sig;
    } else {
        return primero;
    }
}

void showCola (Nodo* primero) {
    if (primero) {
        cout << primero->dato << endl;
        if (primero->sig) {
            showCola(primero->sig);
        } 
    }
}

int main () {

    Nodo* primero = crearNodo(10);
    insertar(buscarUltimo(primero), crearNodo(20));
    insertar(buscarUltimo(primero), crearNodo(30));
    insertar(buscarUltimo(primero), crearNodo(40));
    insertar(buscarUltimo(primero), crearNodo(50));
    insertar(buscarUltimo(primero), crearNodo(60));

    cout << "MOSTRAR COLA" << endl; 
    showCola(primero);

    cout << "SACAR PRIMERO" << endl;
    primero = quitar(buscarPrimero(primero));
    showCola(primero);

    return 0;
}