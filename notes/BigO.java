void selectionSort(int[] arr) {
  for (int i=0; i < arr.length-1; i++) {
    for (int j = i+1; j < arr.length; j++) {
      if (arr[i] > arr[j]) {
        int temp = arr[i]; // swap arr[i] and arr[j]
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
  }
}

if (arr[i] > arr[j]) {
  int temp = arr[i]; // swap arr[i] and arr[j]
  arr[i] = arr[j];
  arr[j] = temp;
}


for (int j = i+1; j < arr.length; j++) {
  // O(1) inner part
}

for (int i=0; i < arr.length-1; i++) {
  // O(n) inner part
}
