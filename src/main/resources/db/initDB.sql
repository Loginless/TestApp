DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS columns;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE columns (
  id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name         VARCHAR(255) NOT NULL,
  description  VARCHAR(255)
);
CREATE UNIQUE INDEX columns_unique_name_idx
  ON columns (name);

CREATE TABLE cards
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name         VARCHAR(255) NOT NULL,
  description  VARCHAR(255),
  column_id    INTEGER NOT NULL,
  FOREIGN KEY (column_id) REFERENCES COLUMNS (id)
  ON DELETE CASCADE
);

CREATE UNIQUE INDEX cards_unique_name_idx
  ON cards (name);