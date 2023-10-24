# Program to order images by resolution and dimensions. It can be ordered both pipelined


import os, shutil
from PIL import Image

class OrderImagesBy:
    def __init__(self):
        self.originDirectory = ""
        self.destinationDirectory = ""
        self.order_by_reso = False
        self.order_by_dims = False
        self.upper = 3000
        self.medium = 1500

    def select_mode(self):
        order_by_reso_q = input("Do you want to order by resolution (large, medium, small pictures)? (y/n)")
        order_by_dims_q = input("Do you want to order by dimensions (vertical, horizontal and square)? (y/n)")
        self.originDirectory = input("Origin directory: ")
        self.destinationDirectory = input("Destination directory: ")
        if (order_by_reso_q == "y" and order_by_dims_q == "y"):
            order = int(input("Do you want to first order by resolution (0) or by dimensions (1). Results may vary from one to the other: "))
            if (order == 0):
                #first order by reso and pipeline with dims
                self.active_order_by_reso()
                self.active_order_by_dims(True)
            elif (order == 1):
                #first order by dims and pipeline with reso
                self.active_order_by_dims()
                self.active_order_by_reso(True)
            else:
                print("Please enter a valid option")
        elif (order_by_reso_q == "y"):
            self.active_order_by_reso()
        elif (order_by_dims_q == "y"):
            self.active_order_by_dims()
        else:
            print("Nothing has been select")

    def active_order_by_reso(self, double_call = False):
        upper, medium = 0, 0
        self.order_by_reso = True
        upper = int(input("What is the width or height that you consider the minimum of a large picture: "))
        if (upper <= 0):
            self.upper = 3000
        else:
            self.upper = upper
        medium = int(input("What is the width or height that you consider the minimum of a medium picture: "))
        if (medium <= 0 or medium > upper):
            self.medium = 1500
        else:
            self.medium = medium
        if (double_call == True):
            dims = int(input("Select horizontal (0), square (1), vertical (2) image: "))
            #else could be: make three folders at the three folders
            if (dims == 0):
                self.destinationDirectory = self.destinationDirectory + "/horizontal"
                self.originDirectory = self.destinationDirectory
            elif (dims == 1):
                self.destinationDirectory = self.destinationDirectory + "/square"
                self.originDirectory = self.destinationDirectory
            elif (dims == 2):
                self.destinationDirectory = self.destinationDirectory + "/vertical"
                self.originDirectory = self.destinationDirectory 
            else:
                print("Please enter a valid option")
        self.order_by_resolution(self.originDirectory, self.destinationDirectory, self.upper, self.medium)

    def active_order_by_dims(self, double_call = False):
        threshold = 0
        reso = 0
        self.order_by_dims = True
        threshold = int(input("Enter the threshold for detecting square images (Default = 175 px): "))
        if (threshold < 0): 
            self.threshold = 175
        else:
            self.threshold = threshold
        if (double_call == True):
            reso = int(input("Select small (0), medium (1), large (2) image: "))
            #else could be: make three folders at the three folders
            if (reso == 0):
                self.destinationDirectory = self.destinationDirectory + "/small"
                self.originDirectory = self.destinationDirectory
            elif (reso == 1):
                self.destinationDirectory = self.destinationDirectory + "/medium"
                self.originDirectory = self.destinationDirectory
            elif (reso == 2):
                self.destinationDirectory = self.destinationDirectory + "/large"
                self.originDirectory = self.destinationDirectory 
            else:
                print("Please enter a valid option")
        self.order_by_dimensions(self.originDirectory, self.destinationDirectory, self.threshold)

    def order_by_resolution(self, originDirectory, destinationDirectory, upper = 3000, medium = 1500):
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


    def order_by_dimensions(self, originDirectory, destinationDirectory, threshold = 175):
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
    order = OrderImagesBy()
    order.select_mode()