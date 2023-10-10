using System;

namespace Fibonacci
{
    public static class Program
    {
        public static void computeNext (int sum1, int sum2, int num) 
        {
            Console.WriteLine(sum1 + sum2);
            if (num > 0)
            {
                computeNext(sum2, sum1 + sum2, --num);
            }
        }
        public static void Main (string[] args)
        {
            int num = 0;
            Console.WriteLine("How many numbers?");
            num = int.Parse(Console.ReadLine());
            Console.WriteLine(0);
            Console.WriteLine(1);
            computeNext(0, 1, num - 2);
            
        }
    }
}