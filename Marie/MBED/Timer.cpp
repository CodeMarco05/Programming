/* mbed Microcontroller Library
 * Copyright (c) 2019 ARM Limited
 * SPDX-License-Identifier: Apache-2.0
 */

#include "mbed.h"

#include "LCD.h"
#include <algorithm>

//Deklaration der LCD
lcd myLCD;

//Taster als Interrupt deklariert
InterruptIn pa1(PA_1);
InterruptIn pa6(PA_6);
InterruptIn pa10(PA_10);
//Taster als Interrupt deklariert
InterruptIn pb4(PB_4);
InterruptIn pb3(PB_3);

//Variablen initialisiert
long sekunden = 0;
long minuten = 0;
long stunden = 0;
bool running = false;

//ISR Methoden erstellt
void isr_1() { 
  //Stunden werden eins hochgezaehlt, bei Knopfdruck auf PA_1
  stunden++; 
}

void isr_6() {
  //Minuten werden eins hochgezaehlt, bei Knopfdruck auf PA_6
  minuten++;
  //wenn minuten (60 mal auf Taster gedrueckt) auf 60 => in Verzweigung
  if (minuten == 60) {
    //Minuten auf 0 setzen
    minuten = 0;
  }
}

void isr_10() {
  //Sekunden werden eins hochgezaehlt, bei Knopfdruck auf PA_10
  sekunden++;
  //wenn Sekunden (60 Mal auf Taster gedrueckt) auf 60 => in Verzweigung
  if (sekunden == 60) {
    //Sekunden auf 0 setzen
    sekunden = 0;
  }
}

void isr_4() { 
  //Start und Stop isr
  running = !running; 
} 

void isr_3() {
  //ruecksetzen auf 0 isr
  stunden = 0;
  minute = 0;
  sekunden = 0;
}

void enable() {
  //alle Taster bis auf den 'Start/Stopp Knopf' wieder freigeben
  pa1.enable_irq();
  pa6.enable_irq();
  pa10.enable_irq();
  pb3.enable_irq();
}

void disable() {
  //alle Taster bis auf den 'Start/Stopp Knopf' wieder sperren
  pa1.disable_irq();
  pa6.disable_irq();
  pa10.disable_irq();
  pb3.disable_irq();
}

int main() {

  //TIM6 mit Takt versorgen
  RCC->APB1ENR |= 0b10000;

  //Counter auf 0 setzen
  TIM6->CNT = 0;
  //UIF auf 0 setzen
  TIM6->SR = 0;

  
  //Prescaler setzen auf 1ms
  TIM6->PSC = 31999;
  
  //Auto Reload Register setzen, auf 1.000 Durchlaeufen
  TIM6->ARR = 999;

  //Timer starten
  TIM6->CR1 = 1;

  myLCD.clear();

  //Taster initialisieren, auf PullDown setzen
  pa1.mode(PullDown);
  pa6.mode(PullDown);
  pa10.mode(PullDown);
  pb4.mode(PullDown);
  pb3.mode(PullDown);

  //Taster PB_4 freigeben (einzeln, da in Methodenaufruf kurz darauf, nicht enthalten)
  pb4.enable_irq();
  //Methodenaufruf
  enable();

  //isr Adressen zuweisen
  pa1.rise(&isr_1);
  pa6.rise(&isr_6);
  pa10.rise(&isr_10);
  pb4.rise(&isr_4);
  pb3.rise(&isr_3);

  //Endlosschleife
  while (true) {
    //lcd Cursorposition zuweisen
    myLCD.cursorpos(0);
    //lcd Anzeige
    myLCD.printf("%dh : %dm : %ds      ", stunden, minuten, sekunden);


    //wenn running == true => disable Methode aufgerufen
    if (running) {
      disable();
      //wenn UIF auf 1 => in Verzweigung
      if (TIM6->SR == 1) {
        //UIF auf 0 setzen
        TIM6->SR = 0;
        //Sekunden eins abziehen
        sekunden--;
      }
      //wenn sekunden auf -1 => in Verzweigung
      if (sekunden == -1) {
        //Sekunden auf 59 setzen
        sekunden = 59;
        //Minuten eins abziehen
        minuten--;
      }
      //wenn minuten auf -1 => in Verzweigung
      if (minuten == -1) {
        //minuten auf 59 setzen
        minuten = 59;
        //Stunden eins abziehen
        stunden--;
      }
      //wenn stunden auf 0 und minuten auf 0 und sekunden auf 0 => in Verzweigung
      if (stunden == 0 && minuten == 0 && sekunden == 0) {
        //running auf false gesetzt
        running = false;
        //Methode enable aufgerufen 
        enable();
      }
    } else {
      //Methode enable aufgerufen
      enable();
    }
  }
}
