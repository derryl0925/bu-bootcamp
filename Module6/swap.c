#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* Takes copies of x and y, not their addresses.
Original variables in main are completely untouched. */
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int x = 10;
    int y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap:  x = %d, y = %d\n", x, y);

    int p = 10;
    int q = 20;

    printf("\nBefore broken_swap: p = %d, q = %d\n", p, q);
    broken_swap(p, q);
    printf("After broken_swap:  p = %d, q = %d\n", p, q);

    return 0;
}