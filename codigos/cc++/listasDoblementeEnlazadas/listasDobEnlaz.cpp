#include <iostream>

using namespace std;

struct Nodo {
    Nodo* ant;
    int dato;
    Nodo* sig;
};

Nodo* crearNodo (int dato) {
    Nodo* nodo = new Nodo();
    nodo->dato = dato;
    nodo->ant = nodo->sig = nullptr;
    return nodo;
}

void insertarNodo (Nodo* raiz, Nodo* nodo) {
    if (raiz && nodo) {
        if (raiz->sig) {
            insertarNodo(raiz->sig, nodo);
        } else {
            raiz->sig = nodo;
            nodo->ant = raiz;
        }
    }
}

Nodo* buscarNodo (Nodo* raiz, int dato) {
    if (raiz) {
        if (raiz->dato == dato) {
            cout << "Nodo encontrado" << endl;
            return raiz;
        } else {
            buscarNodo(raiz->sig, dato);
        }
    }
}

void liberarMem (Nodo* nodo) {
    free(nodo);
}

Nodo* eliminarNodo (Nodo* raiz, int dato) {
    Nodo* eliminable = buscarNodo(raiz, dato);
    if (eliminable) {
        if(eliminable->ant && eliminable->sig) {
            eliminable->ant->sig = eliminable->sig;
            eliminable->sig->ant = eliminable->ant;
        } else if (eliminable->ant && !eliminable->sig) {
            eliminable->ant->sig = nullptr;
        } else if (eliminable->sig && !eliminable->ant) {
            eliminable->sig->ant = nullptr;
            raiz = raiz->sig;
        } else {
            cout << "Lista eliminada" << endl;
        }
        liberarMem(eliminable);
        cout << "Nodo eliminado" << endl;
    } else {
        cout << "Nodo no encontrado" << endl;
    }
    return raiz;
}

void eliminarLista (Nodo* raiz) {
    if(raiz) {
        eliminarLista(raiz->sig);
        liberarMem(raiz);
    } 
}

void showListaF (Nodo* raiz) {
    if (raiz) {
        cout << raiz->dato << endl;
        showListaF(raiz->sig);
    }
}

void showListaR (Nodo* ultimo) {
    if (ultimo) {
        showListaR(ultimo->sig);
        cout << ultimo->dato << endl;
    }
}

int main () {

    Nodo* raiz = crearNodo(10);
    insertarNodo(raiz, crearNodo(20));
    insertarNodo(raiz, crearNodo(30));
    insertarNodo(raiz, crearNodo(40));
    insertarNodo(raiz, crearNodo(50));
    insertarNodo(raiz, crearNodo(60));

    cout << "LISTA EN REVERSA: " << endl;
    showListaR(raiz);
    cout << "LISTA: " << endl;
    showListaF(raiz);
    cout << "BUSCAR NODO: " << endl;
    buscarNodo(raiz, 40);
    cout << "ELIMINAR NODO: " << endl;
    raiz = eliminarNodo(raiz, 40);
    cout << "LISTA: " << endl;
    showListaF(raiz);

    cout << "ELIMINAR LISTA: " << endl;
    eliminarLista(raiz);
    cout << "LISTA: " << endl;
    cout << raiz->dato << endl;

    return 0;
}