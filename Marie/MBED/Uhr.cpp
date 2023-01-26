/* mbed Microcontroller Library
 * Copyright (c) 2019 ARM Limited
 * SPDX-License-Identifier: Apache-2.0
 */

#include "mbed.h"

#include "LCD.h"
lcd myLCD;

InterruptIn pa1(PA_1);
InterruptIn pa6(PA_6);
InterruptIn pa10(PA_10);

long sekunden = 0;
long minuten = 0;
long stunden = 0;

void isr_1() { stunden++; }

void isr_6() { minuten++; }

void isr_10() { sekunden++; }

int main() {

  // Timer
  RCC->APB1ENR |= 0b10000;

  TIM6->CNT = 0;
  TIM6->SR = 0;

  // Ist eine ms
  TIM6->PSC = 31999;
  // Ist dann mal tausend eine s
  TIM6->ARR = 999;

  TIM6->CR1 = 1;

  myLCD.clear();

  pa1.mode(PullDown);
  pa6.mode(PullDown);
  pa10.mode(PullDown);
  pa1.enable_irq();
  pa6.enable_irq();
  pa10.enable_irq();
  pa1.rise(&isr_1);
  pa6.rise(&isr_6);
  pa10.rise(&isr_10);

  bool running = true;

  while (true) {
    myLCD.cursorpos(0);
    myLCD.printf("%d : %d : %d", stunden, minuten, sekunden);

    if (running) {

      if (TIM6->SR == 1) {
        TIM6->SR = 0;
        sekunden++;
      }
      if (sekunden == 60) {
        sekunden = 0;
        minuten++;
      }
      if (minuten == 60) {
        minuten = 0;
        stunden++;
      }
      if (stunden == 24) {
        stunden = 0;
      }
    } else {
    }
  }
}
