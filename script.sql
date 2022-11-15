DROP DATABASE IF EXISTS weathertrack;
CREATE DATABASE IF NOT EXISTS weathertrack;
USE weathertrack;

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(200) UNIQUE NOT NULL,
	user_password VARCHAR(200) NOT NULL,
	user_email VARCHAR(200) UNIQUE NOT NULL,
	PRIMARY KEY (user_id)
);

CREATE TABLE locations (
    location_id INT NOT NULL AUTO_INCREMENT,
	location_name VARCHAR(200) NOT NULL,
	location_coordinates VARCHAR(200) NOT NULL,
	user_id INT NOT NULL,
	PRIMARY KEY (location_id),
    CONSTRAINT location_fk FOREIGN KEY (user_id)
        REFERENCES users (user_id)
		ON DELETE CASCADE
);

INSERT INTO users (user_name, user_password, user_email) VALUES
('user_1', 'p@55w0rd!', 'user.email.1@gmail.com'),
('user_2', 'p@55w0rd@', 'user.email.2@gmail.com'),
('user_3', 'p@55w0rd#', 'user.email.3@gmail.com');

INSERT INTO locations (location_name, location_coordinates, user_id) VALUES
('White House', '38.898266276570894, -77.03663103760712', 1),
('Taj Mahal', '27.174992070454255, 78.04228167281138', 1),
('Eiffel Tower', '48.85861371825382, 2.2948149407613943', 1),
('Cape of Good Hope', '-34.35678326101048, 18.47487360194983', 1),
('USS', '1.2544417651265127, 103.82480123836918', 2),
('KSL', '1.4858245071818195, 103.76331025123008', 2),
('Batam Ferry Terminal', '1.1307547477353375, 104.0563119873033', 2);