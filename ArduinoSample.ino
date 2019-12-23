#include <SoftwareSerial.h>

int inputPin = 8; // 센서 시그널핀 D2
int pirState = LOW; // PIR 초기상태
int val = 0; // Signal 입력값

//블루투스 초기 설정
SoftwareSerial mySerial(2, 3);  //시리얼 통신을 위한 객체선언 TX, RX

void setup() {
  Serial.begin(9600); // 시리얼 모니터 시작
  pinMode(inputPin, INPUT); // 센서 Input 설정
  mySerial.begin(9600); //  블루투스 시리얼 시작
}

void loop() {
  delay(100);
  val = digitalRead(inputPin); // 센서값 읽기

  if (val == HIGH) { //사람이 감지되면
    Serial.write("HIGH\n"); // (DEBUG)
    mySerial.println("alarmoff"); //alarmoff를 전달.
  }
}
