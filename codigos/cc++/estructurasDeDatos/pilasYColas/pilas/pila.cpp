#include <iostream>

using namespace std;

struct Nodo {
    Nodo* encima;
    int dato;
    Nodo* debajo;
};

Nodo* crearNodo(int dato) {
    Nodo* nodo = new Nodo();
    if (dato) {
        nodo->dato = dato;
        nodo->encima = nodo->debajo = nullptr;
    }
    return nodo;
}

void insertarNodo (Nodo* base, Nodo* nodo) {

    if (base && nodo) {
        if (base->encima) {
            insertarNodo(base->encima, nodo);
        } else {
            base->encima = nodo;
            nodo->debajo = base;
        }
    }

}

void liberarMem (Nodo* nodo) {
    if (nodo) {
        free(nodo);
    }
}

Nodo* buscarUltimo (Nodo* base) {
    if (base) {
        if (base->encima) {
            buscarUltimo(base->encima);
        } else {
            return base;
        }
    } 
}

void quitarNodo(Nodo* base) {
    if (base) {
        Nodo* ultimo = buscarUltimo(base);
        ultimo->debajo->encima = nullptr;
        liberarMem(ultimo);
    }
}

void showPilaAbajoArriba (Nodo* base) {
    if (base) {
        cout << base->dato << endl;
        if (base->encima) {
            showPilaAbajoArriba (base->encima);
        }
    }
}

void showPilaArribaAbajo (Nodo* ultimo) {
    if (ultimo) {
        cout << ultimo->dato << endl;
        if (ultimo->debajo) {
            showPilaArribaAbajo(ultimo->debajo);
        }
    }
}

int main () {

    Nodo* base = crearNodo(10);
    insertarNodo(base, crearNodo(20));
    insertarNodo(base, crearNodo(30));
    insertarNodo(base, crearNodo(40));
    insertarNodo(base, crearNodo(50));
    insertarNodo(base, crearNodo(60));

    cout << "ABJ-ARR" << endl;
    showPilaAbajoArriba(base);
    cout << "ARR-ABJ" << endl;
    showPilaArribaAbajo(buscarUltimo(base));

    cout << "QUITAR NODO" << endl;
    quitarNodo(base);
    showPilaArribaAbajo(buscarUltimo(base));

    return 0;
}