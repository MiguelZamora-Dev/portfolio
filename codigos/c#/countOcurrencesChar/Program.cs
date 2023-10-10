using System; 

namespace sumOcurrencesChar
{
    public static class sumOcurrences
    {
        public static int countOcurrences (string text, char letter)
        {
            int count = 0, i = 0;
            while (i < text.Length) {
                if (text[i] == letter)
                {
                    count++;
                }
                i++;
            }
            return count;
        }
        public static void Main (string[] args)
        {
            string text = "This is my text. It was created to count every ocurrence of a char.";
            char letter;
            Console.WriteLine("Count ocurrences for the letter: ");
            letter = char.Parse(Console.ReadLine());
            Console.WriteLine(countOcurrences(text, letter));
        }
    }
}