INSERT INTO app_user (user_name, password, active) VALUES
('sharath', 'pass', true),
('gopal', 'pass', false),
('vivek', 'pass', true);

INSERT INTO role (name) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

INSERT INTO user_role VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2);