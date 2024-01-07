use std::fmt::{Error, Display};

pub struct Stack<T: Display + Copy> {
    store: Vec<T>,
    cur_idx: i32,
    max_size: i32,
}

impl<T: Display + Copy> Stack<T> {
    pub fn new(max_size: i32) -> Self {
        Stack {
            store: Vec::new(),
            cur_idx: -1,
            max_size: max_size - 1,
        }
    }

    pub fn push(&mut self, val: T) {
        if self.cur_idx >= self.max_size {
            panic!("Stack overflow");
        }

        self.cur_idx = self.cur_idx + 1;
        self.store.insert(self.cur_idx as usize, val);
    }

    pub fn pop(&mut self) -> Result<T, Error> {
        if self.cur_idx <= 0 {
            return Err(Error)
        }

        let pop_val = self.store.get(self.cur_idx as usize).copied().unwrap();

        self.store.remove(self.cur_idx as usize);

        self.cur_idx = self.cur_idx - 1;

        Ok(pop_val)
    }

    pub fn size(&self) -> i32 {
        self.cur_idx + 1
    }

    pub fn display(&self) {
        print!("[");
        for i in 0..self.store.len() {
            print!("{}", &self.store[i]);
            if i != self.store.len() - 1 {
                print!(", ");
            }
        }
        println!("]")
    }
}

#[cfg(test)]
mod tests {

    use super::*;

    #[test]
    fn test_stack_push_works() {
        let mut st = Stack::new(5);
        st.push(5);
        st.push(2);
        st.push(3);
        st.push(8);
        assert_eq!(st.size(), 4)
    }
    
    #[test]
    fn test_stack_pop_works() {
        let mut st = Stack::new(5);
        st.push(5);
        st.push(2);
        st.push(3);
        st.push(8);

        let popped = st.pop().expect("Stack Underflow");

        assert_eq!(popped, 8);
    }

    #[test]
    #[should_panic]
    fn test_pop_from_empty_stack() {
        let mut st: Stack<u32> = Stack::new(5);
        st.pop().unwrap();
    }

    #[test]
    #[should_panic(expected = "overflow")]
    fn test_push_on_full_stack() {
        let mut st: Stack<u32> = Stack::new(2);
        st.push(1);
        st.push(1);
        st.push(1);
    }
}