USE clientes;

SELECT * FROM cliente;
SELECT * FROM cliente WHERE usuario='sdfg';
SELECT * FROM cliente WHERE usuario="sdfg" AND psw="1";
DELETE FROM cliente WHERE usuario="Miguelzc";

UPDATE cliente SET nombreCompleto="asdf" WHERE idcliente=9;

INSERT INTO empleado (nombreCompleto, sueldo, puesto, departamento, email, telefono, psw, usuario) VALUES ("sdfg", 1234.0, "software manager", "informatica", "emial@eemma.com", 123451111, "123456", "sdfg");
SELECT * FROM empleado;
SELECT * FROM empleado WHERE nombreCompleto="" AND psw="";
DELETE FROM empleado WHERE idempleado=2;


SELECT * FROM departamento;
SELECT * FROM departamento WHERE nombreDpt='sdfg';


INSERT INTO departamento (nombreDpt, presupuesto) VALUES ("Ventas", 235.5);
INSERT INTO departamento (nombreDpt, presupuesto) VALUES ("Informatico", 2235.5);

SELECT * FROM cita;

INSERT INTO coche (modelo, matricula, precio, color, caballos, capacidadMaletero, puertas, idcliente) VALUES ("verdecito","1234def",123453,"verde",123,234,5,12);
SELECT * FROM coche;

SELECT * FROM ataque;

DELETE FROM clientes.cliente;