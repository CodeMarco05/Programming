use std::io;

fn main() {
    println!("Enter your name: ");
    let mut name = String::new();

    io::stdin().read_line(&mut name).expect("Unable to read input");

    let name: String= name.trim().parse().expect("Failed to convert");

    let s = "Marco";

    if s == name {
        print!("Right. Your name is {}", name);
    }

}
