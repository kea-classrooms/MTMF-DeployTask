INSERT INTO City (CITY_NAME, CITY_ID) VALUES
('Metropolis', 1),
('Gotham City', 2),
('Central City', 3),
('Star City', 4),
('National City', 5);

INSERT INTO Superhero (SUPERHERO_NAME, REEL_NAME, IS_HUMAN, CREATION_DATE, POWERLEVEL, CITY_ID) VALUES
('Superman', 'Clark Kent', false, '2022-12-21', 9.8, 1),
('Batman', 'Bruce Wayne', true, '2022-12-21', 9.5, 2),
('The Flash', 'Barry Allen', true, '2022-12-21', 9.2, 3),
('Green Arrow', 'Oliver Queen', true, '2022-12-21', 8.5, 4),
('Supergirl', 'Kara Danvers', false, '2022-12-21', 9.3, 5);

INSERT INTO Superpower (SUPERPOWER_NAME, SUPERPOWER_ID) VALUES
('Flight', 1),
('Super Strength', 2),
('Super Speed', 3),
('Intelligence', 4),
('Wealth', 5),
('Archery', 6);

INSERT INTO Superheropower (SUPERHERO_ID, SUPERPOWER_ID) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 3),
(4, 4),
(5, 1),
(5, 3);
