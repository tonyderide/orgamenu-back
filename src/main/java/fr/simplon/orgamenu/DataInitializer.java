//package fr.simplon.orgamenu;
//
//
//import fr.simplon.orgamenu.models.*;
//import fr.simplon.orgamenu.repository.EtapesRepository;
//import fr.simplon.orgamenu.repository.RecetteRepository;
//import fr.simplon.orgamenu.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final RecetteRepository recetteRepository;
//    private final EtapesRepository etapesRepository;
//
//
//    public void initData() {
//
//        try {
//            User user1 = new User("tony",
//                    "tony.deride.lp4@gmail.com",
//                    "$2a$10$lyfQmupOyWj2yAFurxFQceFyPrQRUKho4IonK2tXvomWSeeIrS89u",
//                    "tony",
//                    "deride",
//                    178,
//                    76,
//                    40,
//                    "masculin");
//
//            User user2 = new User("justine",
//                    "justine.landais@gmail.com",
//                    "$2a$10$lyfQmupOyWj2yAFurxFQceFyPrQRUKho4IonK2tXvomWSeeIrS89u",
//                    "justine",
//                    "landais",
//                    165,
//                    50,
//                    28,
//                    "feminin");
//            LocalDate maintenant= LocalDate.of(2020, Month.APRIL, 15);
//            LocalDate demain = LocalDateTime.now().toLocalDate().plusDays(1);
//
//            CalendrierRecette cal1=new CalendrierRecette(1,maintenant);
//            CalendrierRecette cal2=new CalendrierRecette(2,demain);
//            Set<CalendrierRecette> calRecette1= new HashSet<>(Arrays.asList(cal1,cal2));
//
//
//
//            Etapes recette11= new Etapes(1,"Préchauffez le four à 180°C.");
//            Etapes recette12= new Etapes(2,"Pelez et émincez l’ail et l’oignon. Épluchez tous les légumes et coupez-les en dés (vous pouvez également utiliser un mélange de légumes surgelés pour ratatouille).");
//            Etapes recette13= new Etapes(3,"Chauffez 1 c. d’huile dans une poêle antiadhésive et faites-y revenir l’ail et  l’oignon 5 min à feu moyen, en remuant.");
//            Etapes recette14= new Etapes(4,"Ajoutez les légumes, l’origan, du sel et du poivre. Laissez cuire 20 minutes à feu moyen, en remuant régulièrement.");
//            Etapes recette15= new Etapes(5,"Disposez une couche de lasagnes dans un plat à gratin. Recouvrez de sauce tomate puis de légumes, et recommencez l’opération jusqu’à avoir rempli le plat.");
//            Etapes recette16= new Etapes(6,"Terminez par une couche de lasagnes, une couche de sauce tomate et recouvrez de mozzarella en rondelles.");
//            Etapes recette17= new Etapes(7,"Enfournez pour 30 à 40 minutes environ, jusqu’à ce que les lasagnes soient tendres et le dessus doré.");
//            Etapes recette18= new Etapes(8,"Servez chaud !");
//
//            Etapes recette21= new Etapes(9,"Dans une poêle, faites fondre la margarine à feu moyen jusqu’à ce qu’elle mousse légèrement. Lorsque la margarine est fondue et mousseuse, déposez le boeuf haché pour le faire cuire. Retournez les steaks hachés à mi-cuisson puis déposez une tranche de fromage à hamburger. Laissez cuire quelques minutes supplémentaires, jusqu’à ce que le fromage commence à fondre.");
//            Etapes recette22= new Etapes(10,"Lavez et coupez les tomates en fines rondelles.");
//            Etapes recette23= new Etapes(11,"Coupez les pains à hamburger en deux puis disposez la deuxième tranche de fromage sur le pain du dessous. Faites cuire 2 min au four à micro-ondes.");
//            Etapes recette24= new Etapes(12,"Disposez ensuite sur chaque moitié inférieure de pain à hamburger la garniture : une feuille de laitue, 2 rondelles de tomates et le steak haché (la tranche de fromage dessous).");
//            Etapes recette25= new Etapes(13,"Badigeonnez la moitié supérieure du pain à hamburger avec la sauce de votre choix et déposez une tranche de fromage. Terminez vos hamburgers maison en les refermant. Servez et dégustez aussitôt accompagnés de frites.");
//
//            Set<Etapes> recette1 = new HashSet<>(Arrays.asList(recette11,recette12,recette13,recette14,recette15,recette16,recette17,recette18));
//
//            Set<Etapes> recette2 = new HashSet<>(Arrays.asList(recette21,recette22,recette23,recette24,recette25));
//
//            Recette lasagne = new Recette(
//                    "Lasagne végétarienne",
//                    150,
//                    20,
//                    60,
//                    recette1,
//                    calRecette1);
//            Recette hamburger = new Recette(
//                    "Hamburger maison",
//                    600,
//                    10,
//                    10,
//                    recette2,
//                    calRecette1);
//
//            userRepository.saveAll(Arrays.asList(user1,user2));
//            etapesRepository.saveAll(recette1);
//            etapesRepository.saveAll(recette2);
//            recetteRepository.saveAll(Arrays.asList(lasagne,hamburger));
//
//        } catch (final Exception ex) {
//            log.error("probleme d'insertion {0}", ex);
//        }
//    }
//
//    @Override
//    public void run(String... args) {
//        initData();
//    }
//
//}
