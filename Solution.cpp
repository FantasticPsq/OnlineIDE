#include <iostream>
using namespace std;

int main() {
    int n;
    long sum = 0;

    n = 200000000;

    for (int i = 1; i <= n; ++i) {
        sum += i;
    }

    cout << "Sum = " << sum;
    return 0;
}