using System;

namespace ReverseString
{
    public static class ReverseString
    {
        public static string reverseString (string s)
        {
            string reversed = "";
            for (int i = s.Length - 1; i >= 0; i--)
            {
                reversed += s[i];
            }

            return reversed;
        }
        public static void Main (string[] args)
        {
            string myString = "thisisastring";
            string myReversedString = reverseString(myString);
            Console.WriteLine(myReversedString);
        }
    }
}