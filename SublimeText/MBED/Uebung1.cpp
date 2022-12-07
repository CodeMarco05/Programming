

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

lcd myLCD;


DigitalOut einerstelle(PC_14);
DigitalOut zehnerstelle(PC_15);
PortOut ausgabe(PortC, 0b1111111);

DigitalIn hoch(PB_4);
DigitalIn runter(PB_6);

int main(){

	myLCD.clear();
	myLCD.curserpos(0);
	myLCD.printf("Zahl: ");
	myLCD.curserpos(6);

	hoch.mode(PullDown);
	runter.mode(PullDown);

	int counter = 0;

	while(true){

		if(hoch == 1){
			thread_sleep_for(30);
			counter++;
			if(counter == 100){
				counter = 0;
			}
			while(hoch == 1){}
		}

		if(runter == 1){
			thread_sleep_for(30);
			counter--;
			if(counter < 0){ // geht auch mit counter == -1
				counter = 99;
			}
			while(runter == 1){}
		}

		einerstelle = 1;
		ausgabe = tabelle[counter % 10];
		thread_sleep_for(20);
		einerstelle = 0;

		zehnerstelle = 1;
		ausgabe = tabelle[counter / 10];
		thread_sleep_for(20);
		zehnerstelle = 0;

		myLCD.printf("%i", counter);

	}


}