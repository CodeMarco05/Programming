
lcd lcd;

DigitalIn input(PC_3);



int main(){
	lcd.clear();
	lcd.curserpos(0);
	lcd.printf("Würfel: ");
	lcd.curserpos(8);

	input.mode(PullDown);

	int counter = 1;

	while(true){

		if(input == 1){
			counter ++;
			if(counter >= 7){
				counter = 1;
			}
		}

		lcd.printf("%i", counter)

	}
}