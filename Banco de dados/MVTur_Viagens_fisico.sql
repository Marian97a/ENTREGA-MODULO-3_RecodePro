create database MVTur_Viagens;

use MVTur_Viagens;

CREATE TABLE Clientes (
    idClientes VARCHAR(15) PRIMARY KEY,
    Nome VARCHAR(40),
    CPF VARCHAR(15),
    Email VARCHAR(100),
    Telefone VARCHAR(15)
);


CREATE TABLE Destinos (
    idDestino VARCHAR(100) PRIMARY KEY,
    Partida VARCHAR(100),
    Chegada VARCHAR(100),
    Origem VARCHAR(100),
    Destino VARCHAR(100)
);


CREATE TABLE Passagem (
    idPassagem VARCHAR(100) PRIMARY KEY,
    valorPassagem DECIMAL(10,2),
    fk_Clientes_idClientes VARCHAR(15),
    fk_Destinos_idDestino VARCHAR(100)
);
 -- select dados
 select * from Clientes;
 select * from Destinos;
 select * from Passagem;
 select * from cliente_destino;
 
 SELECT *
FROM Clientes, Destinos, Passagem
WHERE idClientes = '1';

 select * from Passagem p, Destinos d, Clientes c where p.Passagem = d.Passagem and p.Clientes = c.Clientes;

 
CREATE VIEW cliente_destino AS
select d.id_passagem,  p.valor_passagem, d.*, c.* 
from Passagem p, Destinos d, Clientes c 
where p.Passagem = d.Passagem and p.Clientes = c.Clientes;

 
INSERT INTO Clientes (idClientes, Nome, CPF, Email, Telefone) VALUES 
('6', 'Ary Viana', '245456789094', 'ary@gmail', '12342347888'),
('2', 'Mana Atomny', '123456777094', 'mantny@gmail', '12345600888'),
('3', 'tomny Viny', '123456745678', 'tny@gmail', '123456046778'),
('4', 'Yanca Patricia', '123453459094', 'yanpaty@gmail', '1234897888');

INSERT INTO Destinos (idDestino, Partida, Chegada, Origem, Destino) VALUES
('1', '04/10/2024', '05/10/2024', 'Recife', 'Natal'),
('3', '02/10/2024', '03/10/2024', 'Sergipe', 'Paraiba'),
('4', '20/11/2024', '21/11/2024', 'Teresina', 'Salvador');

INSERT INTO Passagem (idPassagem, valorPassagem, fk_Clientes_idClientes, fk_Destinos_idDestino)VALUES 
('3', 2000.00, '1', 'Sergipe - Paraiba'),
('1', 3000.00, '2', 'São Paulo - Fortaleza');
 

-- atualizando(update) dados
UPDATE Clientes SET nome = 'Jorge', CPF = '977877576474', email = 'Jorge@gmail', telefone = '78453778909' WHERE idClientes = '2';
UPDATE Passagem SET idPassagem = '4', valorPassagem = '2500.00', fk_Clientes_idClientes = '3', fk_Destinos_idDestino = 'Curitiba - Sao Paulo' WHERE idPassagem = '4';


-- deletando(delete) dados
DELETE FROM Clientes WHERE idClientes = '1';