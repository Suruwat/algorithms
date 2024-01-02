use std::fmt::{Error, Display};

pub struct Stack<T: Display + Copy> {
    store: Vec<T>,
    cur_idx: i32,
    max_size: i32,
}

impl<T: Display + Copy> Stack<T> {
    pub fn new(size: i32) -> Self {
        Stack {
            store: Vec::new(),
            cur_idx: -1,
            max_size: size,
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