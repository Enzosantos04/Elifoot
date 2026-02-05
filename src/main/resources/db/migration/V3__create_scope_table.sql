CREATE TABLE  scopes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);


CREATE TABLE users_scopes (
    user_id INT NOT NULL,
    scope_id INT NOT NULL,
    PRIMARY KEY (user_id, scope_id),
    CONSTRAINT fk_user_scopes_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_user_scopes_scope FOREIGN KEY (scope_id) REFERENCES scopes(id)
);