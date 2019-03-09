DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM cards;
DELETE FROM columns;
ALTER SEQUENCE global_seq
RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('Admin', 'admin@gmail.com', '{noop}admin'),
  ('User_1', 'user1@gmail.ru', '{noop}password1'),
  ('User_2', 'user2@gmail.ru', '{noop}password2');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 100000),
  ('ROLE_USER', 100000),
  ('ROLE_USER', 100001),
  ('ROLE_USER', 100002);

INSERT INTO columns (name, description)
VALUES ('To Do', 'New tasks'),
  ('In Progress', 'Ongoing tasks'),
  ('Done', 'Completed tasks');

INSERT INTO cards (name, description, column_id)
VALUES
  ('Review technical task', 'Analyze technical task', 100005),
  ('Work on the architecture', '', 100004),
  ('Write code', 'Prepare Java code', 100003),
  ('WTest the app', 'Test the app features', 100003);

