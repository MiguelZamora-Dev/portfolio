
import os, shutil
from PIL import Image

def order_by_reso(originDirectory, destinationDirectory, upper = 3000, medium = 1500):
    if medium > upper:
        upper = 3000
        medium = 1500
    try:
        directory = os.listdir(originDirectory)
    except:
        raise Exception("Please add a valid origin directory")
    largeCount, mediumCount, smallCount = 0, 0, 0
    if not os.path.exists(destinationDirectory + "/large"):
        os.mkdir(destinationDirectory + "/large")
    if not os.path.exists(destinationDirectory + "/medium"):
        os.mkdir(destinationDirectory + "/medium")
    if not os.path.exists(destinationDirectory + "/small"):
        os.mkdir(destinationDirectory + "/small")

    for img in directory:
        image = Image.open(originDirectory + "/" + img)
        if (image.width > upper or image.height > upper):
            if (img not in os.listdir(destinationDirectory + "/large")):
                shutil.copy(originDirectory + "/" + img, destinationDirectory + "/large")
                largeCount += 1
        elif ((image.width > medium and image.width < upper) or (image.height > medium and image.height < upper)):
            if (img not in os.listdir(destinationDirectory + "/medium")):
                shutil.copy(originDirectory + "/" + img, destinationDirectory + "/medium")
                mediumCount += 1
        else:
            if (img not in os.listdir(destinationDirectory + "/small")):
                shutil.copy(originDirectory + "/" + img, destinationDirectory + "/small")
                smallCount += 1
    
    print(str(largeCount + mediumCount + smallCount) + " images has been ordered by resolution.")
    print(str(largeCount) + " has been added to " + destinationDirectory + "/large")
    print(str(mediumCount) + " has been added to " + destinationDirectory + "/medium")
    print(str(smallCount) + " has been added to " + destinationDirectory + "/small")


if __name__ == "__main__":
    originDirectory = input("Enter the directory where the pics are going to be ordered: ")
    destinationDirectory = input("Enter the directory where the folders for large, medium and small pics are going to be created (Press enter to same as origin): ")
    upper = input("What is the width or height that you consider the minimum of a large picture: ")
    medium = input("What is the width or height that you consider the minimum of a medium picture: ")
    order_by_reso(originDirectory, destinationDirectory, int(upper), int(medium))