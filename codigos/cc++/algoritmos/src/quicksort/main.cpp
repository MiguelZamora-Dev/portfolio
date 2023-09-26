#include <iostream>
#include <ctime>

using namespace std;

void mostrar (int valores[], int n) {
    cout << endl << endl;
    for (int i = 0; i < n; i++) {
        cout << valores[i] << " ";
    }
}

void quicksort(int a[], int start, int end)
{
    if (start >= end) {
        return;
    }
 
    int pivot = a[end];
    int pIndex = start;
 
    for (int i = start; i < end; i++)
    {
        if (a[i] <= pivot)
        {
            swap(a[i], a[pIndex]);
            pIndex++;
        }
    }
 
    swap (a[pIndex], a[end]);

    pivot = pIndex;
 
    quicksort(a, start, pivot - 1);
 
    quicksort(a, pivot + 1, end);
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
    
    quicksort(valores, 0, n - 1);

    t1 = clock();
    mostrar(valores, n);

    cout << "\nTiempo de ejecución: " << (double(t1 - t0)/CLOCKS_PER_SEC) << "s" << endl;
 
    return 0;
}