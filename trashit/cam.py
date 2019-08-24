import cv2
import tensorflow as tf
from time import sleep
import serial
#ser = serial.Serial('/dev/cu.usbmodem141101', 9600)

CATEGORIES = ["biodegradable", "nonbiodegradable"]

key = cv2.waitKey(1)
webcam = cv2.VideoCapture(0)
while True:
     
    check, frame = webcam.read()
    print(check) #prints true as long as the webcam is running
    print(frame) #prints matrix values of each framecd 
    cv2.imshow("Capturing", frame)
    key = cv2.waitKey(1)
    if key == ord('s'): 
        cv2.imwrite(filename='img/capture.jpg', img=frame)
        webcam.release()
        img_new = cv2.imread('img/capture.jpg', cv2.IMREAD_GRAYSCALE)
        #img_new = cv2.imshow("Captured Image", img_new)
        cv2.waitKey(1650)
        cv2.destroyAllWindows()
        #print("Processing image...")
        #img_ = cv2.imread('img/capture.jpg', cv2.IMREAD_ANYCOLOR)
        #print("Converting RGB image to grayscale...")
        #gray = cv2.cvtColor(img_, cv2.COLOR_BGR2GRAY)
        #print("Converted RGB image to grayscale...")
        #print("Resizing image to 28x28 scale...")
        #img_ = cv2.resize(gray,(28,28))
        #print("Resized...")
        #ximg_resized = cv2.imwrite(filename='saved_img-final.jpg', img=img_)
        print("Image saved!")
     
        break
    elif key == ord('q'):
        print("Turning off camera.")
        webcam.release()
        print("Camera off.")
        print("Program ended.")
        cv2.destroyAllWindows()
        break


filepath=''
def prepare(filepath):
    IMG_SIZE = 126
    img_array = cv2.imread(filepath, cv2.IMREAD_COLOR)
    new_array = cv2.resize(img_array, (IMG_SIZE, IMG_SIZE))
    return new_array.reshape(-3, IMG_SIZE, IMG_SIZE, 3)

model = tf.keras.models.load_model("Trashit_final_transfer-CNN.model")

prediction = model.predict([prepare('img/capture.jpg')])
print(CATEGORIES[int(prediction[0][0])])
pred=(prediction[0][0])
if(pred ==1.0):
    print("Non")
    for i in range(0,1):
        ser.write('1'.encode())
    #ser.write('1'.encode())
        print("Sent to Arduino")
else:
    print("Bio")
    for i in range(0,1):
        ser.write('0'.encode())
        print("Sent to Arduino")
