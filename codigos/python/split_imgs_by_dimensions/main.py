import os
from PIL import Image
import shutil

def splitByReso(originDirectory = "./images", destinationDirectory = ".", threshold = 175):
    try:
        directory = os.listdir(originDirectory)
    except:
        raise Exception("Please add a valid origin directory")
    if (threshold == " " or threshold == "" or threshold == None or threshold < 0):
        threshold = 175
    notValidCount = 0
    verticalCount = 0
    horizontalCount = 0
    squareCount = 0
    if not os.path.exists(destinationDirectory + "/vertical"):
        os.mkdir(destinationDirectory + "/vertical")
    if not os.path.exists(destinationDirectory + "/horizontal"):
        os.mkdir(destinationDirectory + "/horizontal")
    if not os.path.exists(destinationDirectory + "/square"):
        os.mkdir(destinationDirectory + "/square")
    print("Origin directory: " + originDirectory + "\nDestination directory: " + destinationDirectory + "\nThreshold: " + str(threshold))
    print("Items at the directory: " + str(len(directory)))
    for img in directory:
        # if img.endswith(".jpg") or img.endswith(".jpeg") or img.endswith(".png") or ...
        if not img.endswith(".mp4") and not img.endswith(".webm"):
            image = Image.open(originDirectory + "/" + img)
            if (image.width > image.height + threshold):
                if img not in os.listdir(destinationDirectory + "/horizontal"):
                    shutil.copy(originDirectory + "/" + img, destinationDirectory + "/horizontal")
                    horizontalCount += 1
            elif (image.height > image.width + threshold):
                if img not in os.listdir(destinationDirectory + "/vertical"):
                    shutil.copy(originDirectory + "/" + img, destinationDirectory + "/vertical")
                    verticalCount += 1
            else:
                if img not in os.listdir(destinationDirectory + "/square"):
                    shutil.copy(originDirectory + "/" + img, destinationDirectory + "/square")
                    squareCount += 1
        else:
            notValidCount += 1
    print(str(horizontalCount + verticalCount + squareCount) + " images has been ordered by resolution. " + str(notValidCount) + " was not valid format")
    print(str(verticalCount) + " images in vertical folder\n" + str(horizontalCount) + " images in horizontal folder\n" + str(squareCount) + " images in square folder")


if __name__ == "__main__":
    originDirectory = input("Enter the directory from where the images are going to be splitted (folder): ")
    destinationDirectory = input("Enter the directory where it is going to be created the three folders for vertical, horizontal and square images (folder): ")
    threshold = int(input("Enter the threshold for detecting square images (Default = 175 px): "))
    splitByReso(originDirectory, destinationDirectory, threshold)