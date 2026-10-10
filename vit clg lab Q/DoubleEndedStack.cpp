#include <iostream>
using namespace std;

#define SIZE 5

class DoubleStack {
    int arr[SIZE];
    int front, rear;

public:
    DoubleStack() {
        front = -1;
        rear = -1;
    }

    void pushFront(int value) {
        if (front == 0) {
            cout << "No space at front\n";
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else {
            front--;
        }

        arr[front] = value;
    }

    void pushRear(int value) {
        if (rear == SIZE - 1) {
            cout << "No space at rear\n";
            return;
        }

        if (rear == -1) {
            front = rear = 0;
        } else {
            rear++;
        }

        arr[rear] = value;
    }

    void popFront() {
        if (front == -1) {
            cout << "Stack is empty\n";
            return;
        }

        cout << "Deleted: " << arr[front] << endl;

        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }

    void popRear() {
        if (rear == -1) {
            cout << "Stack is empty\n";
            return;
        }

        cout << "Deleted: " << arr[rear] << endl;

        if (front == rear) {
            front = rear = -1;
        } else {
            rear--;
        }
    }

    void display() {
        if (front == -1) {
            cout << "Stack is empty\n";
            return;
        }

        for (int i = front; i <= rear; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

int main() {
    DoubleStack s;

    s.pushFront(10);
    s.pushRear(20);
    s.pushFront(5);
    s.pushRear(30);

    cout << "Stack elements: ";
    s.display();

    s.popFront();
    s.popRear();

    cout << "After deletion: ";
    s.display();

    return 0;
}