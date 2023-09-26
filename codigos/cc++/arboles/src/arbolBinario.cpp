#include <iostream>

using namespace std;

struct Nodo {
    Nodo* izq;
    int dato;
    Nodo* der;
    Nodo* padre;
};

Nodo* crearNodo(int dato) {
    Nodo* nodo = new Nodo();
    if ( dato != NULL ) {
        nodo->dato = dato;
        nodo->izq = nodo->der = nullptr;
        nodo->padre = nullptr;
    } else {
        nodo = nullptr;
    }
    return nodo;
}

void insertarNodo(Nodo* raiz, Nodo* nodo, Nodo* padre = nullptr) {
    if (nodo->dato == raiz->dato) {
        cout << "El árbol ya contiene el elemento indicado" << endl;
        return;
    }
    if (nodo->dato < raiz->dato) {
        if ( raiz->izq != nullptr ) {
            insertarNodo(raiz->izq, nodo, raiz);
        } else {
            raiz->izq = nodo;
            raiz->padre = padre;
        }
    } else {
        if ( raiz->der != nullptr ) {
            insertarNodo(raiz->der, nodo, raiz);
        } else {
            raiz->der = nodo;
            raiz->padre = padre;

        }
    }
}

// Sobrecargar para buscar pasando el propio nodo
Nodo* buscarNodo (Nodo* raiz, int dato) {
    if (raiz == NULL) {
        cout << "Nodo no encontrado" << endl;
        return NULL;
    }
    if (raiz->dato == dato) {
        cout << "Nodo encontrado" << endl;
        return raiz;
    } else if (dato < raiz->dato) {
        buscarNodo(raiz->izq, dato);
    } else {
        buscarNodo(raiz->der, dato);
    }
}

Nodo* minimo (Nodo* raiz) {
    if (raiz == NULL) {
        cout << "Nodo no encontrado" << endl;
        return NULL;
    }
    if ( raiz->izq ) {
        minimo(raiz->izq);
    }
    return raiz;
}

void liberarMem (Nodo* nodo) {
    if (nodo) {
        free(nodo);
        cout << "Memoria liberada" << endl;    
    }
}

// Sobrecargar para eliminar pasando el propio nodo
int eliminarNodo (Nodo* raiz, int dato) {

    if (raiz == NULL) {
        cout << "Nodo no encontrado" << endl;
        return -1;
    }

    Nodo* objetivo = buscarNodo(raiz, dato);

    if (objetivo->izq) {
        objetivo->padre->izq = objetivo->izq;
    }
    if (objetivo->der) {
        objetivo->padre->der = objetivo->der;
    }

    liberarMem(objetivo);

}

int compararNodos(Nodo* raiz, int dato1, int dato2) {
    // -1: error
    // 0: mayor izq
    // 1: mayor der
    Nodo* nodo1 = buscarNodo(raiz, dato1);
    Nodo* nodo2 = buscarNodo(raiz, dato2);

    if(!nodo1 || !nodo2) {
        cout << "Datos insuficientes para comparar" << endl;
        return -1;
    }

    if ( nodo1->dato > nodo2->dato ) {
        return 0;
    } else if ( nodo1->dato < nodo2->dato ) {
        return 1;
    } else {
        return -1;
    }
}

Nodo* recorrerArbol (Nodo* raiz) {
    if (raiz==NULL) {
        return NULL;
    }
    if (raiz->izq) {
        recorrerArbol(raiz->izq);
        return raiz;
    }
    if (raiz->der) {
        recorrerArbol(raiz->der);
        return raiz;
    }

}

void eliminarArbol (Nodo* raiz) {
    Nodo* objetivo = recorrerArbol(raiz);
    eliminarNodo(raiz, objetivo->dato);
}

void copiarArbol (Nodo* arbol1, Nodo* arbol2) {
    arbol2 = arbol1;
}

// R I D
void showPreOrder (Nodo* actual) {
    if ( actual != nullptr ) {
        cout << actual->dato << endl;
        showPreOrder(actual->izq);
        showPreOrder(actual->der);
    }
}

// I R D
void showInOrder (Nodo* actual) {
    if ( actual != nullptr ) {
        showInOrder(actual->izq);
        cout << actual->dato << endl;
        showInOrder(actual->der);
    }
}

// I D R
void showPostOrder (Nodo* actual) {
    if ( actual != nullptr ) {
        showPostOrder(actual->izq);
        showPostOrder(actual->der);
        cout << actual->dato << endl;
    }
}

int main () {
    Nodo* raiz = crearNodo(10);
    insertarNodo(raiz, crearNodo(23));
    insertarNodo(raiz, crearNodo(56));
    insertarNodo(raiz, crearNodo(7));
    insertarNodo(raiz, crearNodo(1));
    insertarNodo(raiz, crearNodo(3));
    insertarNodo(raiz, crearNodo(89));
    insertarNodo(raiz, crearNodo(89));
    insertarNodo(raiz, crearNodo(41));
    insertarNodo(raiz, crearNodo(52));
    insertarNodo(raiz, crearNodo(100));

    
    cout << "\nMostrar nodos" << endl;
    cout << "PreOrder" << endl;
    showPreOrder(raiz);
    cout << "InOrder" << endl;
    showInOrder(raiz);
    cout << "PostOrder" << endl;
    showPostOrder(raiz);

    
    cout << "\nBuscar nodo" << endl;
    buscarNodo(raiz, 20);

    
    cout << "\nEliminar nodo" << endl;
    eliminarNodo(raiz, 89);
    showInOrder(raiz);

    
    cout << "\nComparar nodos" << endl;
    cout << "Mayor: " << endl << compararNodos(raiz, 23, 3) << endl;
    // El arbol2 estará desordenado porque se sustituye el 10 por otro valor cualquiera
    
    cout << "\nCopiar arbol" << endl;
    copiarArbol(raiz, crearNodo(20));

    cout << "\nEliminar arbol" << endl;
    eliminarArbol(raiz);
}