#include <iostream>
#include <ctime>

using namespace std;

int *burbuja (int valores[], int n) {
    int aux;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (valores[j] > valores[j+1]) {
                aux = valores[j];
                valores[j] = valores[j+1];
                valores[j+1] = aux;
            }
        }
    }
    return valores;
}

void mostrar (int valores[], int n) {
    cout << endl << endl;
    for (int i = 0; i < n; i++) {
        cout << valores[i] << " ";
    }
}

int main () {
    int n = 1000;
    int valores[n];
    unsigned t0, t1;

    for (int i = 0; i < n; i++) {
        valores[i] = n - i;
    }

    mostrar(valores, n);
    t0 = clock();
    mostrar(burbuja(valores, n), n);
    t1 = clock();

    cout << "\nTiempo de ejecución: " << (double(t1 - t0)/CLOCKS_PER_SEC) << "s" << endl;

    return 0;
}