
DigitalOut einerstelle(PC_14);
DigitalOut zehnerstelle(PC_15);
PortOut ausgabe(PortC, 0b1111111);

const char tabelle [10]{
	0b00111111, //0
    0b00000110, //1
    0b01011011, //2
    0b01001111, //3
    0b01100110, //4
    0b01101101, //5
    0b01111101, //6
    0b00000111, //7
    0b01111111, //8
    0b011101111 //9
};

int main(){

	int i = 34; 
	

	while(true){

		einerstelle = 1;
		ausgabe = tabelle[i % 10];
		thread_sleep_for(10);
		einerstelle = 0;

		zehnerstelle = 1;
		ausgabe = tabelle[i / 10];
		thread_sleep_for(10);
		zehnerstelle = 0;

	}

}