#include <iostream>

using namespace std;

int binarySearch(int arr[], int l, int r, int x) {
    if (r >= l) {
        int mid = l + (r - l) / 2;

        // If the element is present at the middle
        // itself
        if (arr[mid] == x)
            return mid;

        // If element is smaller than mid, then
        // it can only be present in left subarray
        if (arr[mid] > x)
            return binarySearch(arr, l, mid - 1, x);

        // Else the element can only be present
        // in right subarray
        return binarySearch(arr, mid + 1, r, x);
    }

    // We reach here when element is not
    // present in array
    return -1;
}

int main() {
    long long N;
    cin >> N;
    long long sum = 0;
    long long curr;
    int *array = new int[N];
    for (long long i = 0; i < N; i++) {
        cin >> curr;
        sum += curr;
        array[i] = sum;
    }
    long long m;
    cin >> m;
    int *sweetOnesPositions = new int[m];
    for (int i = 0; i < m; i++)
        cin >> sweetOnesPositions[i];
    for (int j = 0; j < m; j++) {
        if (sweetOnesPositions[j] > 0 && sweetOnesPositions[j] <= array[0])
            cout << 1 << endl;
        for (int i = 1; i < N; i++) {
            if (sweetOnesPositions[j] <= array[i] && sweetOnesPositions[j] >= array[i - 1]) {
                cout << i + 1<<endl;
            }
        }
    }

        return 0;
    }