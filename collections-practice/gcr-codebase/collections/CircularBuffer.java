package interfaces;

class CircularBuffer {
    int[] arr;
    int front = 0, size = 0, capacity;

    CircularBuffer(int cap){
        capacity = cap;
        arr = new int[cap];
    }

    void add(int x){
        arr[(front + size) % capacity] = x;
        if(size < capacity) size++;
        else front = (front + 1) % capacity;
    }

    void display(){
        for(int i=0;i<size;i++)
            System.out.print(arr[(front+i)%capacity] + " ");
        System.out.println();
    }
}
