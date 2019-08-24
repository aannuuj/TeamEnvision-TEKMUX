 #include <ESP8266WiFi.h>
#include <FirebaseArduino.h>

const char* ssid     = "#Enter Wifi Ssid";
const char* password = "#Enter Wifi Password";
#define FIREBASE_HOST "xxx.firebaseio.com"
#define FIREBASE_AUTH "enter auth key!"

const int trigPin = 2;  
const int echoPin = 0; 

long duration;
int distance;

void setup() {
pinMode(trigPin, OUTPUT); 
pinMode(echoPin, INPUT);
Serial.begin(9600); 
WiFi.begin(ssid, password);
      
      while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
      }
     Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
}

void loop() {

digitalWrite(trigPin, LOW);
delayMicroseconds(2);


digitalWrite(trigPin, HIGH);
delayMicroseconds(10);
digitalWrite(trigPin, LOW);

duration = pulseIn(echoPin, HIGH);

distance= duration*0.034/2;
Serial.print("Distance: ");
Serial.println(distance);
delay(2000);
Firebase.pushInt("status",distance);
}
