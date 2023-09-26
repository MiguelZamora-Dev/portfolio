
#include <string>
#include <iostream>
#include <bitset>

using namespace std;

string binarize (string texto) {
    string binary = "";
    for (int i = 0; i < texto.length(); i++) {
        binary += bitset<8>(texto[i]).to_string();
    }
    cout << "Binary of sentence: " << binary << endl;
    return binary;
}

string debinarize (string binary) {
    string texto = "";
    for (int i = 0; i < binary.length()/8; i+=8) {

    }
    return texto;
}

string toggle_bit (string texto) {
    string binary = binarize(texto);
    // falta el algoritmo y debinarizar. revisar la binarizacion
    //binary = debinarize(texto);
    cout << "Encrypted binary of sentence: " << binary << endl;
    return binary;
}

string encrypt (string texto) {
    string encrypted;
    int option;

    cout << "Please choose algorithm: " << endl;
    cout << "1. Toggle bit" << endl;
    cin >> option;

    switch (option)
    {
    case 1:
        encrypted = toggle_bit(texto);
        break;
    
    default:
        cout << "Please enter a valid option" << endl;
        break;
    }

    cout << "Encrypted sentence: " << encrypted << endl;

    return encrypted;
}


int main () {

    string sentence, e_sentence, d_sentence; 
    cout << "Please enter a sentence: " << endl;
    getline(cin, sentence);
    e_sentence = encrypt(sentence);

    return 0;
}