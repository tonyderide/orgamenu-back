INSERT INTO co.users (age, email, firstname, lastname, password, sexe, size, username, weight)
VALUES (40, 'tony.deride@gmail.com', 'tony', 'deride', '$2a$10$lyfQmupOyWj2yAFurxFQceFyPrQRUKho4IonK2tXvomWSeeIrS89u','masculin', 178, 'tony', 75);
INSERT INTO co.users (age, email, firstname, lastname, password, sexe, size, username, weight)
VALUES (28, 'justine.landais@gmail.com', 'justine', 'landais','$2a$10$lyfQmupOyWj2yAFurxFQceFyPrQRUKho4IonK2tXvomWSeeIrS89u', 'feminin', 165, 'justine', 50);

INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (10,0, 10, 'c. à café d’origan séché', 1);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (12,0, 0, 'pincée de sel', 2);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (13,0, 0, 'pincée de poivre', 1);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (11,0, 11, 'c. à soupe  d''huile d''olive', 2);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (3,8, 3, 'poivron rouge', 1);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (6,8, 6, 'tomates', 2);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (7,8, 7, 'oignon', 1);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (4,8, 4, 'courgette', 1);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (5,8, 5, 'carottes', 2);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (8,8, 8, 'cl de sauce tomate', 50);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (9,3, 9, 'g de mozzarella', 100);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (2,8, 2, 'aubergine', 1);
INSERT INTO co.ingredient (id_ingredient,type, allergene, nom_ingredient, quantity)VALUES (1,1, 1, 'paquet de feuilles de lasagnes', 1);

INSERT INTO co.recette ( calorie, image_url, name, temp_cuisson, temp_preparation) VALUES ( 150, '/assets/img/lasagne.jpg', 'Lasagne végétarienne', 60, 20);
INSERT INTO co.recette ( calorie, image_url, name, temp_cuisson, temp_preparation) VALUES ( 600, '/assets/img/hamburger.jpeg', 'Hamburger maison', 10, 10);
INSERT INTO co.recette ( calorie, image_url, name, temp_cuisson, temp_preparation) VALUES ( 100, '/assets/img/pates.jpeg', 'Pates', 10, 1);
INSERT INTO co.recette ( calorie, image_url, name, temp_cuisson, temp_preparation) VALUES ( 200, '/assets/img/riz.jpeg', 'Riz aux légumes', 20, 2);
INSERT INTO co.recette ( calorie, image_url, name, temp_cuisson, temp_preparation) VALUES ( 300, '/assets/img/soupe.jpeg', 'Soupe de légumes', 10, 3);

INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 8);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 13);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 11);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 4);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 3);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 12);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 6);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 10);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 9);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 5);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 7);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 2);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (1, 1);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (2, 9);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (2, 7);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (2, 6);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (3, 1);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (4, 8);
INSERT INTO co.contenir (id_recette, id_ingredient) VALUES (5, 8);

INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (1, 'Préchauffez le four à 180°C.', 1, 1);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (2, 'Pelez et émincez l’ail et l’oignon. Épluchez tous les légumes et coupez-les en dés (vous pouvez également utiliser un mélange de légumes surgelés pour ratatouille).', 2, 1);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (3, 'Chauffez 1 c. d’huile dans une poêle antiadhésive et faites-y revenir l’ail et  l’oignon 5 min à feu moyen', 3, 1);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (4, 'Ajoutez les légumes', 4, 1);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (5, 'Disposez une couche de lasagnes dans un plat à gratin. Recouvrez de sauce tomate puis de légumes', 5, 1);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (6, 'Terminez par une couche de lasagnes', 6, 1);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (7, 'Enfournez pour 30 à 40 minutes environ', 7, 1);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (8, 'Servez chaud !', 8, 1);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (9, 'Dans une poêle', 1, 2);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (10, 'Lavez et coupez les tomates en fines rondelles.', 2, 2);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (11,'Coupez les pains à hamburger en deux puis disposez la deuxième tranche de fromage sur le pain du dessous. Faites cuire 2 min au four à micro-ondes.', 3, 2);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (12, 'Disposez ensuite sur chaque moitié inférieure de pain à hamburger la garniture : une feuille de laitue', 4, 2);
INSERT INTO co.etapes (id_etape, etape, numero,id_recette)VALUES (13, 'Badigeonnez la moitié supérieure du pain à hamburger avec la sauce de votre choix et déposez une tranche de fromage. Terminez vos hamburgers maison en les refermant. Servez et dégustez aussitôt accompagnés de frites.', 5, 2);

INSERT INTO co.allergene (id, name)VALUES (1, 'Glutens');
INSERT INTO co.allergene (id, name)VALUES (2, 'Céleri');
INSERT INTO co.allergene (id, name)VALUES (3, 'Crustacés');
INSERT INTO co.allergene (id, name)VALUES (4, 'Moutarde');
INSERT INTO co.allergene (id, name)VALUES (5, 'Oeufs');
INSERT INTO co.allergene (id, name)VALUES (6, 'Graine de sésame');
INSERT INTO co.allergene (id, name)VALUES (7, 'Poissons');
INSERT INTO co.allergene (id, name)VALUES (8, 'Lupin');
INSERT INTO co.allergene (id, name)VALUES (9, 'Arachides');
INSERT INTO co.allergene (id, name)VALUES (10, 'Anhydride sulfureux(E220)');
INSERT INTO co.allergene (id, name)VALUES (11, 'Soja');
INSERT INTO co.allergene (id, name)VALUES (12, 'Lactose');
INSERT INTO co.allergene (id, name)VALUES (13, 'Fruits à coque');

INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (1, 'Pâte');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (2, 'Riz');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (3, 'Fromage');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (4, 'Lait');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (5, 'Frite');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (6, 'Viande');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (7, 'Poisson');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (8, 'Légumes');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (9, 'Chocolat');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (10, 'Volaille');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (11, 'Fruit');
INSERT INTO co.preferencealiment (id_preference_aliment, nom_preference_aliment)VALUES (12, 'Pomme de terre');

INSERT INTO co.roleuser (id, name)VALUES (1, 'ROLE_USER');
INSERT INTO co.roleuser (id, name)VALUES (2, 'ROLE_ADMIN');

INSERT INTO co.user_roles (user_id, role_id)VALUES (1, 1);
INSERT INTO co.user_roles (user_id, role_id)VALUES (1, 2);
INSERT INTO co.user_roles (user_id, role_id)VALUES (2, 1);

INSERT INTO co.preferer (user_id, id_recette)VALUES (1, 2);
INSERT INTO co.preferer (user_id, id_recette)VALUES (1, 1);


INSERT INTO co.calendrier (date, user_id)VALUES ('2020-05-06', 2);
INSERT INTO co.calendrier (date, user_id)VALUES ('2020-05-05', 1);
INSERT INTO co.calendrier (date, user_id)VALUES ('2020-05-11', 2);
INSERT INTO co.calendrier (date, user_id)VALUES ('2020-05-06', 1);
INSERT INTO co.calendrier (date, user_id)VALUES ('2020-05-10', 2);
INSERT INTO co.calendrier (date, user_id)VALUES ('2020-05-07', 1);
INSERT INTO co.calendrier (date, user_id)VALUES ('2020-05-09', 2);
INSERT INTO co.calendrier (date, user_id)VALUES ('2020-05-08', 2);

INSERT INTO co.programmer (id_recette, id_calendrier)VALUES (1, 1);
INSERT INTO co.programmer (id_recette, id_calendrier)VALUES (2, 2);
INSERT INTO co.programmer (id_recette, id_calendrier)VALUES (3, 1);
INSERT INTO co.programmer (id_recette, id_calendrier)VALUES (4, 2);
INSERT INTO co.programmer (id_recette, id_calendrier)VALUES (5, 1);
INSERT INTO co.programmer (id_recette, id_calendrier)VALUES (2, 2);


INSERT INTO co.fournir (user_id, preferencealiment_id)VALUES (1, 1);
INSERT INTO co.fournir (user_id, preferencealiment_id)VALUES (1, 2);
INSERT INTO co.fournir (user_id, preferencealiment_id)VALUES (1, 3);
INSERT INTO co.fournir (user_id, preferencealiment_id)VALUES (2, 1);
INSERT INTO co.fournir (user_id, preferencealiment_id)VALUES (2, 4);

ALTER SEQUENCE co.ingredient_id_ingredient_seq RESTART WITH 14;
ALTER SEQUENCE co.etapes_id_etape_seq RESTART WITH 14;
