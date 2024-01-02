#include <iostream>
#include <stack>

using namespace std;

void displayStack(stack <int> ds){
    stack<int> dis = ds;
    while(!dis.empty()){
        cout << dis.top() << " ";
        dis.pop();
    }
    cout << endl;
}


int main(){
    stack<int> stack1;
    stack1.push(80);
    displayStack(stack1);
    stack1.push(70);
    displayStack(stack1);
    stack1.push(60);
    displayStack(stack1);

    cout << "Stack elements: ";
    displayStack(stack1);

    cout << "Popping: ";
    stack1.pop();
    displayStack(stack1);
    cout << endl;
    return 0;
}
