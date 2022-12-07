

PortIn spalte(PortC, 0xF0);
PortInOut zeile(PortC, 0x0F);

lcd myLCD;

void ausgabe(unsigned int i){
	if(i == 0b01111110) myLCD.printf("1");
	if(i == 0b10111110) myLCD.printf("2");
	if(i == 0b11011110) myLCD.printf("3");
	if(i == 0b11101110) myLCD.printf("A");

	if(i == 0b01111101) myLCD.printf("4");
	if(i == 0b10111101) myLCD.printf("5");
	if(i == 0b11011101) myLCD.printf("6");
	if(i == 0b11101101) myLCD.printf("B");

	if(i == 0b01111011) myLCD.printf("7");
	if(i == 0b10111011) myLCD.printf("8");
	if(i == 0b11011011) myLCD.printf("9");
	if(i == 0b11101011) myLCD.printf("C");

	if(i == 0b01110111) myLCD.printf("*");
	if(i == 0b10110111) myLCD.printf("0");
	if(i == 0b11010111) myLCD.printf("#");
	if(i == 0b11100111) myLCD.printf("D");
}

int main(){

	spalte.mode(PullUp);
	spalte.output();
	spalte.mode(OpenDrain);

	int output;

	while(true){

		zeile = 0b1110;
		thread_sleep_for(5);
		output = spalte + zeile; //0b 1011 1110

		ausgabe(output);

		zeile = 0b1101;
		thread_sleep_for(5);
		output = spalte + zeile;

		ausgabe(output);

		zeile = 0b1011;
		thread_sleep_for(5);
		output = spalte + zeile;

		ausgabe(output);

		zeile = 0b0111;
		thread_sleep_for(5);
		output = spalte + zeile;

		ausgabe(output);
	}

}
