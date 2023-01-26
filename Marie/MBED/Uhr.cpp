/* mbed Microcontroller Library
 * Copyright (c) 2019 ARM Limited
 * SPDX-License-Identifier: Apache-2.0
 */

#include "mbed.h"

#include "LCD.h"
// Lcd Anzeige deklarieren
lcd myLCD;

//Taster als Interrupt deklariert
InterruptIn pa1(PA_1);
InterruptIn pa6(PA_6);
InterruptIn pa10(PA_10);

//Variablen initialisiert
long sekunden = 0;
long minuten = 0;
long stunden = 0;

//Interrupt Service Routinen
void isr_1() { stunden++; }

void isr_6() { minuten++; }

void isr_10() { sekunden++; }

int main() {

  // Timer mit Takt versorgen, TIM6
  RCC->APB1ENR |= 0b10000;

  //gezaehlte Durchlaeufe von ARR zurücksetzen
  TIM6->CNT = 0;

  //Update Interrupt Flag (UIF) auf 0 setzen
  TIM6->SR = 0;

  //Ein Durchlauf -> 1ms
  TIM6->PSC = 31999;

  //Muss 999 Mal durchlaufen, um Flag auszulösen 
  //Beachten 0 zaehlt mit -> 1.000 Durchlaefe
  TIM6->ARR = 999;

  /*
  
  100%          Maschienenzyklen in 1ms oder 1ns
                |                  
                |                 Verlangsamt auf von uns gegebene Durchlaufdauer 
                |                 |                         Zählt uns die Durchläufe von AutoReload
  (Timer)-->-->(PreSCaler)-->-->(AutoReloadRegister)-->-->(CouNTer)

  */  

  //Timer starten
  TIM6->CR1 = 1;

  myLCD.clear();

  //Taster initialisieren
  pa1.mode(PullDown);
  pa6.mode(PullDown);
  pa10.mode(PullDown);
  //Taster isr freigeben
  pa1.enable_irq();
  pa6.enable_irq();
  pa10.enable_irq();
  //auf steigende Flanke reagieren
  pa1.rise(&isr_1);
  pa6.rise(&isr_6);
  pa10.rise(&isr_10);

  //Endlosschleife
  while (true) {
    //Cursor positionieren
    myLCD.cursorpos(0);
    //Anzeige freihalten fuer Werte
    myLCD.printf("%d : %d : %d", stunden, minuten, sekunden);

    //wenn UIF auf 1 -> ein Durchlauf fertig => in Verzweigung
    if (TIM6->SR == 1) {
        //UIF auf 0 setzen
        TIM6->SR = 0;
        //Sekunden eins hochzaehlen
        sekunden++;
    }
    //wenn sekunden auf 60 hochgezaehlt wurde => in Verzweigung
    if (sekunden == 60) {
      //Sekunden auf 0 setzen
      sekunden = 0;
      //Minuten eins hochzaehlen
      minuten++;      
    }
    //wenn minuten auf 60 hochgezaehlt => in Verzweigung
    if (minuten == 60) {
      //Minuten auf 0 setzen
      minuten = 0;
      //Stunden eins hochzaehlen
      stunden++;
    }
    //wenn stunden auf 24 hochgezaehlt => in Verzweigung
    if (stunden == 24) {
      //Stunden auf 0 setzen 
      stunden = 0;
    }
    
  }
}
