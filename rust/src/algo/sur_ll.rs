use std::fmt::Display;

pub struct LL<T: PartialOrd + Display> {
    head: Option<Box<Node<T>>>,
    size: u32,
}

struct Node<T: PartialOrd + Display> {
    val: T,
    next: Option<Box<Node<T>>>,
}

impl<T: PartialOrd + Display> LL<T> {

    pub fn new(val: T) -> Self {
        LL {head: Some(Box::new(Node {val, next: None})), size: 1}
    }

    pub fn insert(&mut self, val: T) {
        let new_node = Node {val, next: None};

        let mut curr = &mut self.head;
        while let Some(node) = curr {
            curr = &mut node.next;
        }

        *curr = Some(Box::new(new_node));
        self.size = self.size + 1;
    }
}

#[cfg(test)] 
mod tests {
    use super::*;

    #[test]
    fn test_insert_works() {
        let mut ll = LL::new(5);
        ll.insert(6);
        ll.insert(2);

        assert_eq!(3, ll.size);
    }
}