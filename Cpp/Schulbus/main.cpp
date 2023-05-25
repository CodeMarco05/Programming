

void ankunft(){
	if(zustand == FahrenTuerZu){

		starteStopZeit();
		warnblinkerEin();
		zustand = HaltestelleTuerAuf;
	}
}

	
while(true){
	switch(zustand)
	case HaltestelleTuerAuf:
		anzeigenRestzeit();

		//Zusatzaufgabe
		if(rz == 0 && einAusSteigen()){
			starteStopZeit();
		}

		if(rz == 0){
			zustand = FahrenTuerZu;
			warnblinkerAus();
		}
	break;
	case FahrenTuerZu:

	break;
}