drop schema if exists cinefide;
drop user if exists administrador;
CREATE SCHEMA cinefide ;

create user 'administrador'@'%' identified by 'Admin123';

grant all privileges on cinefide.* to 'administrador'@'%';
flush privileges;

create table cinefide.usuario(
id_usuario int NOT NULL Auto_Increment primary key, 
username  varchar(50) UNIQUE,    
nombre  varchar(50), 
apellidos  varchar(100),
password  varchar(512), 
correo  varchar(100) UNIQUE, 
telefono VARCHAR(15) NULL,
ruta_imagen varchar(1024))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table cinefide.promocion(
id_promocion int NOT NULL Auto_Increment primary key, 
nombre_promocion  varchar(100),
descripcion  varchar(5000),
reglamento  varchar(5000))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
/*Se insertan 3 registros en la tabla cliente como ejemplo */
INSERT INTO cinefide.usuario (username,password,nombre, apellidos, correo, telefono,ruta_imagen) VALUES 
('juan','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Juan', 'Castro Mora',    'jcastro@gmail.com',    '4556-8978', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Juan_Diego_Madrigal.jpg/250px-Juan_Diego_Madrigal.jpg'),
('rebeca','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Rebeca',  'Contreras Mora', 'acontreras@gmail.com', '5456-8789','https://upload.wikimedia.org/wikipedia/commons/0/06/Photo_of_Rebeca_Arthur.jpg'),
('pedro','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Pedro', 'Mena Loria',     'lmena@gmail.com',      '7898-8936','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Eduardo_de_Pedro_2019.jpg/480px-Eduardo_de_Pedro_2019.jpg?20200109230854');


create table cinefide.cartelera(
id_pelicula int NOT NULL Auto_Increment primary key, 
titulo  varchar(200), 
imagen  varchar(3000),
descripcion varchar(3000),
horario varchar(3000),
trailer varchar(300),
director varchar(100),
actor varchar(100),
guionista varchar(100),
clasificacion varchar(10))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO cinefide.cartelera(id_pelicula,titulo,imagen,descripcion,horario,trailer,director,actor,guionista,clasificacion) VALUES
(1,'Dune 2','https://m.media-amazon.com/images/M/MV5BN2QyZGU4ZDctOWMzMy00NTc5LThlOGQtODhmNDI1NmY5YzAwXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg','Explorara el viaje mitico de Paul Atreides mientras se une a Chani y los Fremen en una guerra de venganza contra los conspiradores que destruyeron a su familia.','L: 2:30 a 4:00 pm, 4:30 a 6:00 pm, V: 2:30 a 4:00 pm, 4:30 a 6:00 pm','https://www.youtube.com/embed/BUayub_LJJw','Denis Villeneuve','Zendaya','Denis Villeneuve & Jon Spaihts','PG +13'),
(2,'Kung Fu Panda 4','https://m.media-amazon.com/images/M/MV5BZDY0YzI0OTctYjVhYy00MTVhLWE0NTgtYTRmYTBmOTE3YTViXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_FMjpg_UX1000_.jpg','Despues que Po ha sido elegido para convertirse en el Lider Espiritual del Valle de la Paz, necesita encontrar y entrenar a un nuevo Guerrero Dragon, mientras una hechicera planea volver a convocar a los maestros villanos a quienes Po ha vencido.','M: 2:30 a 4:00 pm, 4:30 a 6:00 pm','https://www.youtube.com/embed/_inKs4eeHiI','Mike Mitchell & Stephanie Stine','Jack Black, Awkwafina & Viola Davis','Jonathan Aibel, Glenn Berger & Darren Lemke','PG +13'),
(3,'Bob Marley','https://m.media-amazon.com/images/M/MV5BY2U4M2NmY2ItMjAyNC00NzM1LTg3ZTEtNzVlYjEzNTE5NDI5XkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg','BOB MARLEY LA LEYENDA celebra la vida y la musica de un icono que inspiro a generaciones a traves de su mensaje de amor y unidad.','M: 2:30 a 4:00 pm, 4:30 a 6:00 pm','https://www.youtube.com/embed/ajw425Kuvtw','Reinaldo Marcus Green','Kingsley Ben-Air, Lashana Lynch & James Norton','Terence Winter, Frank E. Flowers & Zach Baylin','PG +13'),
(4,'Madame Web','https://m.media-amazon.com/images/M/MV5BYWJkY2Q4NmYtOGRlMi00YTg5LWE2ZmQtY2NkYzk3YTRmNWZlXkEyXkFqcGdeQXVyMTY3ODkyNDkz._V1_.jpg','Cassandra Webb es una paramedica de Nueva York que empieza a mostrar signos de clarividencia. Obligada a enfrentarse a revelaciones sobre su pasado, debe proteger a tres jovenes.','K: 2:30 a 4:00 pm, 4:30 a 6:00 pm','https://www.youtube.com/embed/s_76M4c4LTo','SJ Clarkson','Dakota Johnson, Sidney Sweeney & Isabela Merced','Matt Sazama, Burk Sharpless & Claire Parker','PG +13'),
(5,'Migration','https://m.media-amazon.com/images/I/9162HQDZznL._AC_UF894,1000_QL80_.jpg','Una familia de patos intenta convencer a su padre sobreprotector para que se vaya a las vacaciones de su vida.','K: 2:30 a 4:00 pm, 4:30 a 6:00 pm','https://www.youtube.com/embed/cQfo0HJhCnE','Benjamin Renner & Guylo Homsy','Kumail Nanjiani, Tresi Gazal & Elizabeth Banks','Mike White & Benjamin Renner','PG +13'),
(6,'Demon Slayer: Kimetsu No Yaiba - To the Hashira Training','https://m.media-amazon.com/images/M/MV5BNWFkNzI5NDQtY2QyZS00NGE2LWJiNDEtMTI5ZTFmNDE0ZjcwXkEyXkFqcGdeQXVyNjk1NzU1Mjk@._V1_FMjpg_UX1000_.jpg','Tanjiro Kamado y sus amigos del Demon Slayer Corps acompañan a Kyōjurō Rengoku, el Flame Hashira, para investigar una misteriosa serie de desapariciones que ocurren dentro de un tren aparentemente infinitamente largo. Poco saben que Enmu, la última de las Lunas Inferiores de los Doce Kizuki, también está a bordo y les ha preparado una trampa.','V: 2:30 a 4:00 pm, 4:30 a 6:00 pm','https://www.youtube.com/embed/7w5Vfjozzb8','Haruo Sotozaki','Natsuki Hanae, Kengo Kawanishi & Akari Kitô','Koyoharu Gotouge','R'),
(7,'Anyone But You Movie','https://m.media-amazon.com/images/M/MV5BYmQ2MmY2MmYtMjUzOS00Y2MyLWE4YmQtYzIzYWQ4OTdmMGU0XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg','Bea y Ben parecen la pareja perfecta, pero después de una primera cita increíble, sucede algo que frena su atracción. Hasta que inesperadamente se juntan en una boda en Australia.','L: 6:30 a 8:00 pm, 4:30 a 6:00 pm','https://www.youtube.com/embed/UtjH6Sk7Gxs','Will Gluck','Sydney Sweeney, Glen Powell & Alexandra Shipp','Ilana Wolpert & Will Gluck','R'),
(8,'The Iron Claw','https://m.media-amazon.com/images/M/MV5BOGE5NjllZTEtMGJjNy00ZTFmLThlNDItNmNiZTgyOTQ4OTA2XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg','Una familia de luchadores que se enfrentan en el ring deben lidiar con una serie de tragedias personales.','S: 9:30 a 12:00 AM','https://www.youtube.com/embed/8KVsaoveTbw','Sean Durkin','Zac Efron, Jeremy Allen White & Harris Dickinson','Sean Durkin','PG +13'),
(9,'Imaginary','https://m.media-amazon.com/images/M/MV5BODIzOTJiODUtNzM2MC00YjdjLTg5YTktZWZhNjY1N2I5NWRjXkEyXkFqcGdeQXVyMjY5ODI4NDk@._V1_.jpg','Una mujer regresa con su familia a la casa donde creció. Su hija menor pronto se encariña con un osito de peluche que encuentra en el sótano. Aunque la interacción parece divertida, la situación pronto se vuelve siniestra.','D: 2:30 a 4:00 pm, 6:30 a 8:00 pm','https://www.youtube.com/embed/8XoNfrgrAGM','Jeff Wadlow','DeWanda Wise, Taegen Burns & Pyper Braun','Jeff Wadlow, Greg Erb & Jason Oremland','PG +13');


create table cinefide.proximosEstrenos(
id_pelicula int NOT NULL Auto_Increment primary key, 
titulo  varchar(200), 
imagen  varchar(3000),
descripcion varchar(3000),
fecha varchar(3000))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO cinefide.proximosEstrenos(id_pelicula,titulo,imagen,descripcion,fecha) VALUES
(1,'Godzilla y Kong: El Nuevo Imperio','https://static.cinepolis.com.ar/posters/2130/w500/lm-gxk-vert-tsr-2764x4096-intljpg','Una aventura cinematográfica completamente nueva, que enfrentará al todopoderoso Kong y al temible Godzilla contra una colosal amenaza desconocida escondida dentro de nuestro mundo.','Marzo 2024'),
(2,'Nosotros los de la Fe','https://m.media-amazon.com/images/M/MV5BNDczNTVmZmItNGY2MC00YzYxLThmNmYtYzdhMGRiNzBkZjM2XkEyXkFqcGdeQXVyODU4MjAxOQ@@._V1_FMjpg_UX1000_.jpg','Narra la vida de una familia cristiana a lo largo de 20 años y su búsqueda por hacer la voluntad de Dios.','Marzo 2024'),
(3,'Exorcistas','https://s3-eu-west-1.amazonaws.com/abandomedia/db/foto/db_44817_45.jpg','Cuando su hijo es poseído por un mal implacable, un padre contrata a tres exorcistas expertos para alejar al demonio y salvar a su familia.','Marzo 2024'),
(4,'Suga','https://statics.cinemex.com/movie_posters/LQdGPwlTP16wLQl-750x1125.jpg','¡La esperada película del concierto bis de SUGA de BTS <SUGA│Agust D TOUR ‘D-DAY’ THE MOVIE> irrumpe en la gran pantalla de todo el mundo! Como gran final de la gira mundial, "SUGA | Agust D TOUR THE FINAL" simbolizó la culminación de 25 conciertos ofrecidos en 10 ciudades, que cautivaron a un total de 290 000 espectadores durante el transcurso de todas sus presentaciones.','Abril 2024'),
(5,'GhostBursters: Apocalipsis Fantasma','https://palomaynacho-1f321.kxcdn.com/wp-content/uploads/2023/12/Poster-Ghostbusters-Apocalipsis-fantasma-jpg.webp','Después de los eventos de Oklahoma, el equipo de Cazafantasmas regresa a donde comenzó todo: ¡Nueva York! La historia de la familia Spengler continúa con un nuevo grupo de Cazafantasmas.','Abril 2024');

create table cinefide.valoracion(
id_pelicula int NOT NULL Auto_Increment primary key, 
titulo  varchar(200), 
imagen  varchar(3000),
descripcion varchar(3000),
valoraciones varchar(3000),
horario varchar(3000))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO cinefide.valoracion(id_pelicula,titulo,imagen,descripcion,horario) VALUES
(1,'Dune 2','https://m.media-amazon.com/images/M/MV5BN2QyZGU4ZDctOWMzMy00NTc5LThlOGQtODhmNDI1NmY5YzAwXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg','Explorara el viaje mitico de Paul Atreides mientras se une a Chani y los Fremen en una guerra de venganza contra los conspiradores que destruyeron a su familia.','L: 2:30 a 4:00 pm, 4:30 a 6:00 pm, V: 2:30 a 4:00 pm, 4:30 a 6:00 pm'),
(2,'Kung Fu Panda 4','https://m.media-amazon.com/images/M/MV5BZDY0YzI0OTctYjVhYy00MTVhLWE0NTgtYTRmYTBmOTE3YTViXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_FMjpg_UX1000_.jpg','Despues que Po ha sido elegido para convertirse en el Lider Espiritual del Valle de la Paz, necesita encontrar y entrenar a un nuevo Guerrero Dragon, mientras una hechicera planea volver a convocar a los maestros villanos a quienes Po ha vencido.','M: 2:30 a 4:00 pm, 4:30 a 6:00 pm'),
(3,'Bob Marley','https://m.media-amazon.com/images/M/MV5BY2U4M2NmY2ItMjAyNC00NzM1LTg3ZTEtNzVlYjEzNTE5NDI5XkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg','BOB MARLEY LA LEYENDA celebra la vida y la musica de un icono que inspiro a generaciones a traves de su mensaje de amor y unidad.','M: 2:30 a 4:00 pm, 4:30 a 6:00 pm'),
(4,'Madame Web','https://m.media-amazon.com/images/M/MV5BYWJkY2Q4NmYtOGRlMi00YTg5LWE2ZmQtY2NkYzk3YTRmNWZlXkEyXkFqcGdeQXVyMTY3ODkyNDkz._V1_.jpg','Cassandra Webb es una paramedica de Nueva York que empieza a mostrar signos de clarividencia. Obligada a enfrentarse a revelaciones sobre su pasado, debe proteger a tres jovenes.','K: 2:30 a 4:00 pm, 4:30 a 6:00 pm'),
(5,'Migration','https://m.media-amazon.com/images/I/9162HQDZznL._AC_UF894,1000_QL80_.jpg','Una familia de patos intenta convencer a su padre sobreprotector para que se vaya a las vacaciones de su vida.','K: 2:30 a 4:00 pm, 4:30 a 6:00 pm'),
(6,'Demon Slayer: Kimetsu No Yaiba - To the Hashira Training','https://m.media-amazon.com/images/M/MV5BNWFkNzI5NDQtY2QyZS00NGE2LWJiNDEtMTI5ZTFmNDE0ZjcwXkEyXkFqcGdeQXVyNjk1NzU1Mjk@._V1_FMjpg_UX1000_.jpg','Tanjiro Kamado y sus amigos del Demon Slayer Corps acompañan a Kyōjurō Rengoku, el Flame Hashira, para investigar una misteriosa serie de desapariciones que ocurren dentro de un tren aparentemente infinitamente largo. Poco saben que Enmu, la última de las Lunas Inferiores de los Doce Kizuki, también está a bordo y les ha preparado una trampa.','V: 2:30 a 4:00 pm, 4:30 a 6:00 pm'),
(7,'Anyone But You Movie','https://m.media-amazon.com/images/M/MV5BYmQ2MmY2MmYtMjUzOS00Y2MyLWE4YmQtYzIzYWQ4OTdmMGU0XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg','Bea y Ben parecen la pareja perfecta, pero después de una primera cita increíble, sucede algo que frena su atracción. Hasta que inesperadamente se juntan en una boda en Australia.','L: 6:30 a 8:00 pm, 4:30 a 6:00 pm'),
(8,'The Iron Claw','https://m.media-amazon.com/images/M/MV5BOGE5NjllZTEtMGJjNy00ZTFmLThlNDItNmNiZTgyOTQ4OTA2XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg','Una familia de luchadores que se enfrentan en el ring deben lidiar con una serie de tragedias personales.','S: 9:30 a 12:00 AM'),
(9,'Imaginary','https://m.media-amazon.com/images/M/MV5BODIzOTJiODUtNzM2MC00YjdjLTg5YTktZWZhNjY1N2I5NWRjXkEyXkFqcGdeQXVyMjY5ODI4NDk@._V1_.jpg','Una mujer regresa con su familia a la casa donde creció. Su hija menor pronto se encariña con un osito de peluche que encuentra en el sótano. Aunque la interacción parece divertida, la situación pronto se vuelve siniestra.','D: 2:30 a 4:00 pm, 6:30 a 8:00 pm');
create table cinefide.reservas(
id_pelicula int NOT NULL Auto_Increment primary key, 
imagen  varchar(3000),
fecha varchar(3000),
horario varchar(3000),
asiento varchar(3000),
titulo varchar(3000))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO cinefide.reservas(id_pelicula,imagen,fecha,horario,asiento,titulo) VALUES
(1,'https://m.media-amazon.com/images/M/MV5BN2QyZGU4ZDctOWMzMy00NTc5LThlOGQtODhmNDI1NmY5YzAwXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg','Lunes','2:30 a 4:30pm','D1 - D2','Dune 2'),
(3,'https://m.media-amazon.com/images/M/MV5BY2U4M2NmY2ItMjAyNC00NzM1LTg3ZTEtNzVlYjEzNTE5NDI5XkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg','Miercoles','4:30 a 6:00pm','F4 - F5','Bob Marley'),
(5,'https://m.media-amazon.com/images/I/9162HQDZznL._AC_UF894,1000_QL80_.jpg','Martes','2:30 a 4:00pm','H7 - H8 - H9','Migration');

create table cinefide.horarios(
id_pelicula int NOT NULL Auto_Increment primary key, 
titulo  varchar(200), 
imagen  varchar(3000),
fecha   varchar(3000),
horario varchar(3000),
asiento varchar(3000))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO cinefide.horarios(id_pelicula,titulo,imagen,fecha,horario,asiento) VALUES
(1,'Dune 2','https://m.media-amazon.com/images/M/MV5BN2QyZGU4ZDctOWMzMy00NTc5LThlOGQtODhmNDI1NmY5YzAwXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg','Lunes Viernes','2:30 a 4:00 pm, 4:30 a 6:00 pm, 2:30 a 4:00 pm, 4:30 a 6:00 pm',''),
(2,'Kung Fu Panda 4','https://m.media-amazon.com/images/M/MV5BZDY0YzI0OTctYjVhYy00MTVhLWE0NTgtYTRmYTBmOTE3YTViXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_FMjpg_UX1000_.jpg','Miercoles','2:30 a 4:00 pm, 4:30 a 6:00 pm',''),
(3,'Bob Marley','https://m.media-amazon.com/images/M/MV5BY2U4M2NmY2ItMjAyNC00NzM1LTg3ZTEtNzVlYjEzNTE5NDI5XkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg','Miercoles','2:30 a 4:00 pm, 4:30 a 6:00 pm',''),
(4,'Madame Web','https://m.media-amazon.com/images/M/MV5BYWJkY2Q4NmYtOGRlMi00YTg5LWE2ZmQtY2NkYzk3YTRmNWZlXkEyXkFqcGdeQXVyMTY3ODkyNDkz._V1_.jpg','Martes',' 2:30 a 4:00 pm, 4:30 a 6:00 pm',''),
(5,'Migration','https://m.media-amazon.com/images/I/9162HQDZznL._AC_UF894,1000_QL80_.jpg','Martes','2:30 a 4:00 pm, 4:30 a 6:00 pm',''),
(6,'Demon Slayer: Kimetsu No Yaiba - To the Hashira Training','https://m.media-amazon.com/images/M/MV5BNWFkNzI5NDQtY2QyZS00NGE2LWJiNDEtMTI5ZTFmNDE0ZjcwXkEyXkFqcGdeQXVyNjk1NzU1Mjk@._V1_FMjpg_UX1000_.jpg','Viernes','2:30 a 4:00 pm, 4:30 a 6:00 pm',''),
(7,'Anyone But You Movie','https://pics.filmaffinity.com/Anyone_But_You-290348256-large.jpg','Lunes','6:30 a 8:00 pm, 4:30 a 6:00 pm',''),
(8,'The Iron Claw','https://m.media-amazon.com/images/M/MV5BOGE5NjllZTEtMGJjNy00ZTFmLThlNDItNmNiZTgyOTQ4OTA2XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg','Sabado','9:30 a 12:00 AM',''),
(9,'Imaginary','https://m.media-amazon.com/images/M/MV5BODIzOTJiODUtNzM2MC00YjdjLTg5YTktZWZhNjY1N2I5NWRjXkEyXkFqcGdeQXVyMjY5ODI4NDk@._V1_.jpg','Domingo','2:30 a 4:00 pm, 6:30 a 8:00 pm','');

create table cinefide.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into cinefide.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), (2,'ROLE_VENDEDOR',1), (3,'ROLE_USER',1),
 (4,'ROLE_VENDEDOR',2), (5,'ROLE_USER',2),
 (6,'ROLE_USER',3);
