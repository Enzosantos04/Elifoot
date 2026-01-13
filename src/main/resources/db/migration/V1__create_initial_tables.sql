CREATE TABLE stadium(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    capacity INTEGER,
    url_img VARCHAR(255)
);



CREATE TABLE club (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    founded DATE NOT NULL,
    url_img VARCHAR(255),
    created_at TIMESTAMP,
    active BOOLEAN,
    stadium_id INTEGER NOT NULL,
    CONSTRAINT fk_club_stadium FOREIGN KEY (stadium_id) REFERENCES stadium(id)

);


CREATE TABLE player(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(50) NOT NULL,
    shirt_number INTEGER NOT NULL,
    url_img VARCHAR(255),
    club_id INTEGER NOT NULL,
    CONSTRAINT fk_player_club FOREIGN KEY (club_id) REFERENCES club(id)

);