import os
from PIL import Image
import shutil

def order_by_dimensions(originDirectory, destinationDirectory, threshold = 175, onlyVertical = False, onlyHorizontal = False, onlySquare = False):
        onlyCount = 0
        if onlyVertical:
            onlyCount += 1
        if onlyHorizontal:
            onlyCount += 1
        if onlySquare:
            onlyCount += 1
        if onlyCount > 1:
            onlyVertical = True
            onlyHorizontal = onlySquare = False
            print("Please add only one true (onlyVertical, onlyHorizontal, onlySquare)")
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
        if not os.path.exists(destinationDirectory + "/vertical") and not onlyHorizontal and not onlySquare:
            os.mkdir(destinationDirectory + "/vertical")
        if not os.path.exists(destinationDirectory + "/horizontal") and not onlySquare and not onlyVertical:
            os.mkdir(destinationDirectory + "/horizontal")
        if not os.path.exists(destinationDirectory + "/square") and not onlyHorizontal and not onlyVertical:
            os.mkdir(destinationDirectory + "/square")

        for img in directory:
            # if img.endswith(".jpg") or img.endswith(".jpeg") or img.endswith(".png") or ...
            if not img.endswith(".mp4") and not img.endswith(".webm"):
                image = Image.open(originDirectory + "/" + img)
                if ((image.width > image.height + threshold) and not onlySquare and not onlyVertical):
                    if img not in os.listdir(destinationDirectory + "/horizontal"):
                        shutil.copy(originDirectory + "/" + img, destinationDirectory + "/horizontal")
                        horizontalCount += 1
                elif ((image.height > image.width + threshold) and not onlyHorizontal and not onlySquare):
                    if img not in os.listdir(destinationDirectory + "/vertical"):
                        shutil.copy(originDirectory + "/" + img, destinationDirectory + "/vertical")
                        verticalCount += 1
                # else is not an option due to the needed to avoid os.listdir exception when folder square is not created
                elif ((not (image.width > image.height + threshold) and not (image.height > image.width + threshold)) and not onlyHorizontal and not onlyVertical):
                    if (img not in os.listdir(destinationDirectory + "/square")):
                        shutil.copy(originDirectory + "/" + img, destinationDirectory + "/square")
                        squareCount += 1
            else:
                notValidCount += 1
        print(str(horizontalCount + verticalCount + squareCount) + " images has been ordered by resolution. " + str(notValidCount) + " was not valid format")
        print(str(verticalCount) + " images in vertical folder\n" + str(horizontalCount) + " images in horizontal folder\n" + str(squareCount) + " images in square folder")


if __name__ == "__main__":
    originDirectory = input("Enter the directory from where the images are going to be ordered: ")
    destinationDirectory = input("Enter the directory where it is going to be created the three folders for vertical, horizontal and square images: ")
    threshold = int(input("Enter the threshold for detecting square images (Default = 175 px): "))
    order_by_dimensions(originDirectory, destinationDirectory, threshold, onlyVertical = False, onlyHorizontal = True, onlySquare = False)