#include <iostream>

using namespace std;

struct Nodo {
    int dato;
    Nodo* sig;
};

Nodo* crearNodo (int dato, Nodo* siguiente = nullptr) {
    Nodo* nodo = new Nodo();
    nodo->dato = dato;
    nodo->sig = siguiente;
    return nodo;
}

void insertarNodo (Nodo* raiz, Nodo* nodo) {
    if (!raiz->sig) {
        raiz->sig = nodo;
    } else {
        insertarNodo(raiz->sig, nodo);
    }
}

Nodo* buscarNodo (Nodo* raiz, int dato) {
    if (raiz) {
        if (raiz->dato == dato) {
            cout << "Nodo encontrado" << endl;
            return raiz;
        }
        buscarNodo(raiz->sig, dato);
    }
}

void liberarMem (Nodo* nodo) {
    free(nodo);
}

Nodo* eliminarNodo (Nodo* raizAbs, Nodo* raiz, int dato, Nodo* anterior = nullptr) {
    if (raiz) {
        if(raiz->dato == dato) {
            if (anterior) {
                anterior->sig = raiz->sig;
                liberarMem(raiz);
                return raizAbs;
            } else {
                cout << "Se ha actualizado la raiz principal" << endl;
                return raiz->sig;
            }
            cout << "Nodo eliminado" << endl;  
        }
        eliminarNodo(raizAbs, raiz->sig, dato, raiz);
    }
}

void eliminarLista (Nodo* raiz) {
    if (raiz) {
        eliminarLista(raiz->sig);
        raiz->dato = 0;
        raiz = raiz->sig = nullptr;
        liberarMem(raiz);
    }
}

void showLista (Nodo* raiz) {
    if (raiz) {
        cout << raiz->dato << endl;
        showLista(raiz->sig);
    }
}

int main () {

    Nodo* raiz = crearNodo(10);
    insertarNodo(raiz, crearNodo(20));
    insertarNodo(raiz, crearNodo(30));
    insertarNodo(raiz, crearNodo(40));
    insertarNodo(raiz, crearNodo(50));
    insertarNodo(raiz, crearNodo(60));

    showLista(raiz);

    buscarNodo(raiz, 40);

    raiz = eliminarNodo(raiz, raiz, 40);

    showLista(raiz);

    eliminarLista(raiz);
    raiz = nullptr;

    showLista(raiz);

    return 0;
}