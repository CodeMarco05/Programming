/* mbed Microcontroller Library
 * Copyright (c) 2019 ARM Limited
 * SPDX-License-Identifier: Apache-2.0
 */

#include "mbed.h"

#include "LCD.h"
#include <algorithm>

lcd myLCD;

InterruptIn pa1(PA_1);
InterruptIn pa6(PA_6);
InterruptIn pa10(PA_10);
InterruptIn pb4(PB_4);
InterruptIn pb3(PB_3);

long sekunden = 0;
long minuten = 0;
long stunden = 0;
bool running = false;

void isr_1() { stunden++; }

void isr_6() {
  minuten++;
  if (minuten == 60) {
    minuten = 0;
  }
}

void isr_10() {
  sekunden++;
  if (sekunden == 60) {
    sekunden = 0;
  }
}

void isr_4() { running = !running; }

void isr_3() {
  stunden = 0;
  minuten = 0;
  sekunden = 0;
}

void enable() {
  pa1.enable_irq();
  pa6.enable_irq();
  pa10.enable_irq();
  pb3.enable_irq();
}

void disable() {
  pa1.disable_irq();
  pa6.disable_irq();
  pa10.disable_irq();
  pb3.disable_irq();
}

int main() {

  
  RCC->APB1ENR |= 0b10000;

  TIM6->CNT = 0;
  TIM6->SR = 0;

  
  TIM6->PSC = 31999;
  
  TIM6->ARR = 999;

  TIM6->CR1 = 1;

  myLCD.clear();

  pa1.mode(PullDown);
  pa6.mode(PullDown);
  pa10.mode(PullDown);
  pb4.mode(PullDown);
  pb3.mode(PullDown);

  pb4.enable_irq();
  enable();

  pa1.rise(&isr_1);
  pa6.rise(&isr_6);
  pa10.rise(&isr_10);
  pb4.rise(&isr_4);
  pb3.rise(&isr_3);

  while (true) {
    myLCD.cursorpos(0);
    myLCD.printf("%dh : %dm : %ds      ", stunden, minuten, sekunden);

    if (running) {
      disable();
      if (TIM6->SR == 1) {
        TIM6->SR = 0;
        sekunden--;
      }
      if (sekunden == -1) {
        sekunden = 59;
        minuten--;
      }
      if (minuten == -1) {
        minuten = 59;
        stunden--;
      }
      if (stunden == 0 && minuten == 0 && sekunden == 0) {
        running = false;
        enable();
      }
    } else {
      enable();
    }
  }
}
