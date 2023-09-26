import random
import time
class porsustitucion():
  def __init__(self):
    self.sustituible = ['q','e','t','i','o','a','s','l','z','b']
    self.sust_por = [['q','9'],['e','3'],['t','7'],
      ['i','1'],['o','0'],['a','4'],['s','5'],
      ['l','1'],['z','2'],['b','6']]
    self.psw = ""
  def generacion(self):
    self.string = input('\nIntroduzca una contraseña para ser modificada: \n')
    self.string = self.string.lower()
    for letter in self.string:
      if letter in self.sustituible:
        mayusominus = random.choice([1,0])
        if mayusominus:
          self.psw = self.psw + random.choice(self.sust_por[self.sustituible.index(letter)])
        else:
          self.psw = self.psw + random.choice(self.sust_por[self.sustituible.index(letter)]).upper()
      else:
        mayusominus = random.choice([1,0])
        if mayusominus:
          self.psw = self.psw + letter
        else:
          self.psw = self.psw + letter.upper()
    print('\nContraseña generada')
    print('PSW: ' + self.psw)
class porlongitud():
  def __init__(self):
    self.len = 12
    self.minus = "qwertyuiopasdfghjklñzxcvbnm"
    self.mayus = "QWERTYUIOPASDFGHJKLÑZXCVBNM"
    self.num = "0123456789"
    #self.specs = "_-"
    self.psw = ""
    self.res = [self.minus, self.mayus, self.num] #, self.specs]
  def generacion(self):
    self.len = int(input("\nIntroduce número de caracteres: "))
    print('Generando contraseña...')
    if self.len>20:
      print('\nPor favor, ten en cuenta que\nla generación pseudoaleatoria\nse ve definida por la hora real.\nPor este motivo se varían \na propósito las variables de entorno\nlo cual lleva tiempo')
    for i in range(self.len):
      time.sleep((random.random())/2)
      self.source = random.choice(self.res)
      self.psw = self.psw + random.choice(self.source)
    print('\nContraseña generada')
    print('PSW: ' + self.psw)
print('''Hay dos opciones: \n(0) Construir de cero una nueva contraseña\n(1) Introducir una cadena para que sea modificada\n''')
select = input('Elige una según el índice indicado\n')
if select not in ['0','1']:
  print('Por favor, introduce una opción válida según se indica')
else:
  if select == '1':
    Gen = porsustitucion()
    Gen.generacion()
  else:
    Gen = porlongitud()
    Gen.generacion()