
import os
import shutil

def renameAll (originDirectory, destinationDirectory, newName):
    i = 0
    if originDirectory == "\n" or originDirectory == " " or originDirectory == "" or originDirectory == None:
        originDirectory = "./images"
    if destinationDirectory == "\n" or destinationDirectory == " " or destinationDirectory == "" or destinationDirectory == None:
        destinationDirectory = originDirectory
    if newName == "\n" or newName == " " or newName == "" or newName == None:
        newName = "file"
    directory = os.listdir(originDirectory)
    print("Origin directory: " + originDirectory)
    print("Destination directory: " + destinationDirectory)
    print("New name: " + newName)
    print("There are " + str(len(directory)) + " item in " + originDirectory)
    for item in directory:
        itemArr = item.split(".")
        extension = itemArr[1]
        newNameExt = newName + str(i) + "." + extension
        shutil.move(originDirectory + "/" + item, destinationDirectory + "/" + newNameExt)
        i += 1
    print(str(i) + " items has been renamed")    

if __name__ == "__main__":
    originDirectory = input("Enter the directory from where images is going to be renamed. Intro to '.' directory: ")
    destinationDirectory = input("Enter the directory where images are going to be stored. Intro to same as origin: ")
    newName = input("Enter new name to refactor: ")
    renameAll(originDirectory, destinationDirectory, newName)