INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (4, '1- Préchauffez le four à 180°C.', 1);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (5, '2- Pelez et émincez l’ail et l’oignon. Épluchez tous les légumes et coupez-les en dés 
 (vous pouvez également utiliser un mélange de légumes surgelés pour ratatouille).', 1);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (6, '3- Chauffez 1 c. d’huile dans une poêle antiadhésive et faites-y revenir l’ail et 
 l’oignon 5 min à feu moyen, en remuant.', 1);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (7, '4- Ajoutez les légumes, l’origan, du sel et du poivre. Laissez cuire 20 minutes à feu 
 moyen, en remuant régulièrement.', 1);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (8, '5- Disposez une couche de lasagnes dans un plat à gratin. Recouvrez de sauce 
 tomate puis de légumes, et recommencez l’opération jusqu’à avoir rempli le plat.', 1);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (9, '6- Terminez par une couche de lasagnes, une couche de sauce tomate et 
 recouvrez de mozzarella en rondelles.', 1);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (10, '7- Enfournez pour 30 à 40 minutes environ, jusqu’à ce que les lasagnes soient 
 tendres et le dessus doré.', 1);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (11, '8- Servez chaud !', 1);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (12, '1- Dans une poêle, faites fondre la margarine à feu moyen jusqu’à ce qu’elle mousse légèrement. Lorsque la margarine est fondue et mousseuse, déposez le boeuf haché pour le faire cuire. Retournez les steaks hachés à mi-cuisson puis déposez une tranche de fromage à hamburger. Laissez cuire quelques minutes supplémentaires, jusqu’à ce que le fromage commence à fondre.', 2);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (13, '2- Lavez et coupez les tomates en fines rondelles.', 2);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (14, '3- Coupez les pains à hamburger en deux puis disposez la deuxième tranche de fromage sur le pain du dessous. Faites cuire 2 min au four à micro-ondes.', 2);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (15, '4- Disposez ensuite sur chaque moitié inférieure de pain à hamburger la garniture : une feuille de laitue, 2 rondelles de tomates et le steak haché (la tranche de fromage dessous).', 2);
INSERT INTO co.etapes (idderoulement, etape, idrecette) VALUES (16, '5- Badigeonnez la moitié supérieure du pain à hamburger avec la sauce de votre choix et déposez une tranche de fromage. Terminez vos hamburgers maison en les refermant. Servez et dégustez aussitôt accompagnés de frites (du fait maison bien sûr !).', 2);
INSERT INTO co.recette (idrecette, nom, calorie, temppreparation, tempcuisson) VALUES (1, 'Lasagne végétarienne', 150, 20, 60);
INSERT INTO co.recette (idrecette, nom, calorie, temppreparation, tempcuisson) VALUES (2, 'Hamburger maison', 600, 10, 10);
INSERT INTO co.roleuser (idrole, nomrole) VALUES (1, 'utilisateur');
INSERT INTO co.roleuser (idrole, nomrole) VALUES (2, 'administrateur');
