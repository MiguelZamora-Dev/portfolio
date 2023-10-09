using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leyGravitacionUniversal
{
    internal class LGUClass
    {
        // Earth
        private double G = 6.67E-11, F = 0, m1 = 15.654, m2 = 5.9722E+24, d = 36E+6, T = 86400, Re = 6.371E+6;
        //Moon
        private double m3 = 7.349E+22, d2 = 3484E+5;
        public LGUClass ()
        {
        }

        public double Force
        {
            get
            {
                return this.getForce() - this.getForceMoon();
            }

            set
            {
                Console.WriteLine("Introduce new gravity force");
                if (value > 0 && value != double.PositiveInfinity && value != double.NegativeInfinity)
                {
                    this.F = value;
                }
                else
                {
                    Console.WriteLine("Force couldn't be setted");
                }
            }
        }

        public double D2
        {
            get
            {
                return this.d2;
            }

            set
            {
                if (value > 0)
                {
                    this.d2 = value;
                }
                else
                {
                    Console.WriteLine("Distance respect Moon couldn't be setted");
                }
            }
        }

        public double OrbitHeight
        {
            get
            {
                return this.getOrbitHeight();
            }
            set
            {
                if (value > 35E+6)
                {
                    this.d = value;
                }
                else
                {
                    Console.WriteLine("Please introduce a valid orbit. It cannot be lower than 35E+6");
                }
            }
        }

        private double getForce()
        {
            return this.G * ((this.m1 * this.m2) / Math.Pow(this.d, 2));
        }

        private double getForceMoon()
        {
            return this.G * ((this.m1 * this.m3) / Math.Pow(this.d2, 2));
        }

        private double getOrbitHeight()
        {
            return Math.Cbrt((this.G*Math.Pow(this.T, 2)*this.m2)/(4*Math.Pow(Math.PI, 2))) - this.Re;
        }
    }
}
