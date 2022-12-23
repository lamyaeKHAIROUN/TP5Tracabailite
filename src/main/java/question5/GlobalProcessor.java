package question5;

import question5.cli_App.Product;
import question5.cli_App.User;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GlobalProcessor {


    public List<UserProfile> createProfilesForAllUsers(List<OurLPSFormater>ourLPSFormaters, List<Product>products) {
        List<UserProfile>userProfiles = new LinkedList<UserProfile>();
        UserProfile userProfile ;
        int i=-1;
        Product p =null;
        for(OurLPSFormater lps : ourLPSFormaters) {
            userProfile = createProfile(lps,products);
            i = getIndex(userProfiles,userProfile);
            if(i == -1) {
                userProfiles.add(userProfile);
            }else {
                if(lps.getMethod().equals("addNewProduct") || lps.getMethod().equals("deleteProduct") ||lps.getMethod().equals("updateProduct") ) {
                    userProfiles.get(i).getOperationsWritenByUsers().add(lps.getMethod());
                }
                userProfiles.get(i).getOperationsReadByUser().add(lps.getMessage());

            }
        }
        return userProfiles;
    }

    private UserProfile createProfile(OurLPSFormater lps, List<Product> products) {
        String messageRepo = lps.getMessage();
        String t1[]= messageRepo.split("];");
        String IDProduct;
        Product pr =null;
        String t[]= t1[0].split(",");
        String t2[];
        User user = new User();
        for (int i = 0; i < t.length; i++) {
            t2=t[i].split("=");
            switch (i) {
                case 0: {
                    user.setID(t2[1]);
                    break;
                }
                case 1: {
                    user.setName(t2[1]);
                    break;
                }
                case 2: {
                    user.setAge(t2[1]);
                    break;
                }
                case 3: {
                    user.setEmail(t2[1]);
                    break;
                }
                case 4: {
                    user.setPassword(t2[1]);
                    break;
                }
            }
        }
        UserProfile userProfile = new UserProfile(user);
        if(lps.getMethod().equals("addNewProduct") || lps.getMethod().equals("deleteProduct") ||lps.getMethod().equals("updateProduct") ) {
            userProfile.getOperationsWritenByUsers().add(lps.getMethod());
        }
        userProfile.getOperationsReadByUser().add(lps.getMethod());


        return userProfile;    }


    private Product getProductById(String ID,List<Product> products) {
        for (Product product : products) {
            if(product.getID().equals(ID)) {
                return product;
            }
        }
        return null;
    }


    private String findProductInMsg(String message) {
        String tab[]= message.split(";");
        return tab[1];
    }



    private int getIndex(List<UserProfile> userProfiles, UserProfile userProfile) {
        for (int i = 0; i < userProfiles.size(); i++) {
            if(userProfiles.get(i).getUser().getID().equals(userProfile.getUser().getID())) {
                return i;
            }
        }

        return -1;    }








//Products

    public List<Product> getCollectionSortedOfProducts(List<OurLPSFormater> ourLPSFormaters){
        List<Product>products = createProducts(ourLPSFormaters);
        Collections.sort(products, new ProductComparator());
        return products;
    }

    public List<Product> createProducts(List<OurLPSFormater> ourLPSFormaters) {
        List<Product>products =new LinkedList<Product>();
        String t[];
        Product p;
        for (OurLPSFormater lps : ourLPSFormaters) {
            if (lps.getMessage().contains("Product")) {
                t = lps.getMessage().split(";");
                p = createProduct(t[1]);
                if(!products.contains(p)) {
                    products.add(p);
                }

            }
        }
        return products;
    }

    private Product createProduct(String stringProduct) {
        Product p = new Product();
        String t[] = stringProduct.split(",");
        String t2[];
        for (int i = 0; i < t.length; i++) {
            t2 = t[i].split("=");
            switch (i) {
                case 0: {
                    p.setID(t2[1]);
                    break;
                }
                case 1: {
                    p.setName(t2[1]);
                    break;
                }
                case 2: {
                    p.setPrice(t2[1]);
                    break;
                }
                case 3: {
                    p.setExpirationString(t2[1]);
                    break;
                }
            }
        }
        return p;

    }



    public UserProfile userWhoHasTheHighestReadingOperationsNumbre(List<UserProfile>userProfiles) {
        int max =0;
        UserProfile userProfile=null;
        for (UserProfile userProfile2 : userProfiles) {
            if(userProfile2.getOperationsReadByUser().size()>max) {
                max=userProfile2.getOperationsReadByUser().size();
                userProfile = userProfile2;
            }
        }
        return userProfile;
    }

    public void displayuserWhoHasTheHighestReadingOperationsNumbre(UserProfile userProfile) {
        System.out.println("Le profil utilisateur qui a le plus grand nombre des actions de lecture:");
        System.out.println(userProfile.getUser().toString());
        System.out.println("Le nombre de lecture: "+userProfile.getOperationsReadByUser().size());
        System.out.println("La liste des opérations faites:");
        for (String operation : userProfile.getOperationsReadByUser()) {
            System.out.println(operation);
        }
        System.out.println("\n");
    }


    public UserProfile userWhoHasTheHighestWritingOperationsNumbre(List<UserProfile>userProfiles) {
        int max =0;
        UserProfile userProfile=null;
        for (UserProfile userProfile2 : userProfiles) {
            if(userProfile2.getOperationsWritenByUsers().size() > max) {
                max=userProfile2.getOperationsWritenByUsers().size();
                userProfile = userProfile2;
            }
        }
        return userProfile;
    }

    public void displayuserWhoHasTheHighestWritingOperationsNumbre(UserProfile userProfile) {
        System.out.println("Le profil utilisateur qui a le plus grand nombre des actions d'écriture");
        System.out.println(userProfile.getUser().toString());
        System.out.println("Le nombre des opérations d'écriture: "+userProfile.getOperationsWritenByUsers().size());
        System.out.println("La liste des opérations faites: ");
        for (String operation : userProfile.getOperationsWritenByUsers()) {
            System.out.println(operation);
        }
        System.out.println("\n");
    }



}
