using System;

namespace HammingDistance
{
    public static class hammingDistance
    {
        public static int hdistance (string my1string, string my2string)
        {
            int distance = 0;
            if (my1string.Length != my2string.Length)
                throw new Exception("Must be the same size");
            for (int i = 0; i < my1string.Length; i++)
            {
                if (my1string[i] != my2string[i])
                {
                    distance++;
                }
            }
            return distance;
        }
        public static void Main (string[] args)
        {
            string my1string = "thisismystring";
            string my2string = "th1s1smystr1ng";

            Console.WriteLine(hdistance(my1string, my2string));
        }
    }
}