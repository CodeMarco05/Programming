
DigitalIn schalter1(PC_0);
DigitalIn schalter2(PC_1);
DigitalIn reset(PC_2);

lcd myLCD;


int main(){

    schalter2.mode(PullDown);
    schalter1.mode(PullDown);
    reset.mode(PullDown);

    myLCD.curserpos(0);
    myLCD.prinf("Start in: ");
    myLCD.curserpos(10);

    int counter = 10;

    while(true){
    	while(schalter1 == 1 && schalter2 == 1 && counter != 0){
    		myLCD.printf("%i", counter);
    		counter--;
    		thread_sleep_for(1000);

    		if(counter == 0){
    			myLCD.clear();
    			myLCD.curserpos(0);
    			myLCD.printf("Start");
    		}
    	}

    	if(reset == 1){
    		myLCD.clear();
    		myLCD.curserpos(0);
    		myLCD.printf("Start in: ")
    		myLCD.curserpos(10);
    		counter = 10;
    	}


    }

}