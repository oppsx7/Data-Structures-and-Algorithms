#include <iostream>

using namespace std;
int N, K;
bool ifPossible(int *array,int num,int cows,int pos){
    for (int i=1; i<N; i++)
    {
        if (array[i]-pos>=num)
        {
            pos=array[i];
            cows++;
            if (cows==K)
                return true;
        }
    }
    return false;
}

int binarySearch(int *array,int l,int r,int max){
    while(r>l){
        int mid = (r+l)/2;
        if (ifPossible(array,mid,1,array[0]))
        {
            if (mid>max)
                max=mid;
            l=mid+1;
        }
        else
            r=mid;
    }
    return max;


}

int main() {
    cin >> N >> K;

    int *array = new int[N];
    for (int i = 0; i < N; i++)
        cin >> array[i];
    sort(array,array+N);
    cout<<binarySearch(array,0,array[N-1],-1);


    return 0;
}