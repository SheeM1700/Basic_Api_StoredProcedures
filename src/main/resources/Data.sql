CREATE TABLE IF NOT exists Movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    category VARCHAR(255),
    classification VARCHAR(255)
);

-- INSERTAR DATOS EN LA TABLA
INSERT INTO Movie(name, description, category, classification) VALUES ('Venom: El último baile', 'Venom: El último baile es una película estadounidense de superhéroes de 2024, basada en el personaje de Marvel Comics, Venom.', 'Acción', 'PG-13');
INSERT INTO Movie(name, description, category, classification) VALUES ('Cars', 'De camino al prestigiado campeonato Copa Pistón, un automóvil de carreras que sólo se preocupa por ganar aprende sobre lo que realmente es importante en la vida de varios vehículos que viven en un pueblo a lo largo de la histórica Ruta 66.', 'Aventura', 'Todos');
INSERT INTO Movie(name, description, category, classification) VALUES ('IT', 'Varios niños de una pequeña ciudad del estado de Maine se alían para combatir a una entidad diabólica que adopta la forma de un payaso y desde hace mucho tiempo emerge cada 27 años para saciarse de sangre infantil.', 'Terror', 'PG-13');

-- Procedimiento almacenado para consultar
DELIMITER $$
CREATE PROCEDURE verPeliculas()
BEGIN
	SELECT * FROM movie;
END$$;

-- Procedimiento almacenado para consultar un solo registro
DELIMITER $$
CREATE PROCEDURE buscarPelicula(IN movie_id INT)
BEGIN
	SELECT * FROM movie WHERE id = movie_id;
END$$;

-- Procedimiento almacenado para insertar un registro
DELIMITER $$
CREATE PROCEDURE insertarPelicula(IN m_name VARCHAR(255), IN m_description VARCHAR(255), IN m_category VARCHAR(255), IN m_classification VARCHAR(255))
BEGIN
    INSERT INTO Movie (name, description, category, classification) VALUES (m_name, m_description, m_category, m_classification);
END$$;

-- Procedimiento almacenado para actualizar un registro
DELIMITER $$
CREATE PROCEDURE actualizarPelicula(IN m_id INT, IN m_name VARCHAR(255), IN m_description VARCHAR(255), IN m_category VARCHAR(255), IN m_classification VARCHAR(255))
BEGIN
    UPDATE Movie SET name = m_name, description = m_description, category = m_category, classification = m_classification WHERE id = m_id;
END$$

-- Procedimiento almacenado para eliminar un registro
DELIMITER $$
CREATE PROCEDURE eliminarPelicula(IN movie_id INT)
BEGIN
    DELETE FROM Movie WHERE id = movie_id;
END$$;