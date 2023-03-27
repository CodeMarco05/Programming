
int seg[10] = ={0b00111111, 0b00000110, 0b01011011, 0b01001111, 0b01100110, 0b01101101, 0b01111101, 0b00000111, 0b01111111, 0b01101111};{0b00111111;};

InterruptIn takt(PA_6);
InterruptIn s(PA_1);

int password = 317;




int main(){

    takt.mode(PullDown);
    s.mode(PullDown);
    takt.rise(&isr_takt);
    s.rise(&isr_s);

    while(true){
        
    }
}