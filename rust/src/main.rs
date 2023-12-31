mod sur_stack;

use sur_stack::Stack;
fn main() {
    test_stack();
}

fn test_stack() {
    let mut stack : Stack = Stack::new(5);

    stack.push(5);
    stack.push(4);
    stack.push(5);
    stack.push(8);
    stack.push(9);

    println!("Stack test start");
    stack.display();

    stack.pop().expect("Stack underflow occurred");

    stack.display();

    println!("Stack test end");
}
