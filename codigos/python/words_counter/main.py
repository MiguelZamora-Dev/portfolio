# This is a program to count words in a text. It removes blank spaces and count the words in the resultant list

def wordsCounter(text):
    text = text.strip().split()
    return len(text)

if __name__ == "__main__":
    text = "this is the  text that i have to count words with "
    print(wordsCounter(text))