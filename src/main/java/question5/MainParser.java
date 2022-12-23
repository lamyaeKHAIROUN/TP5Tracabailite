package question5;

import question5.cli_App.Product;
import question5.parser.Parser;

import java.io.IOException;
import java.util.List;

public class MainParser {

    private static String FileName = "Repository.log";

    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            List<OurLPSFormater> lpsList = parser.parse(FileName);
            GlobalProcessor globalProcessor = new GlobalProcessor();
            List<Product>products = globalProcessor.getCollectionSortedOfProducts(lpsList);
            List<UserProfile>userProfiles = globalProcessor.createProfilesForAllUsers(lpsList, products);

            UserProfile bestRdUserProfile= 	globalProcessor.userWhoHasTheHighestReadingOperationsNumbre(userProfiles);
            globalProcessor.displayuserWhoHasTheHighestReadingOperationsNumbre(bestRdUserProfile);

            UserProfile bestWtUserProfile= 	globalProcessor.userWhoHasTheHighestWritingOperationsNumbre(userProfiles);
            globalProcessor.displayuserWhoHasTheHighestWritingOperationsNumbre(bestWtUserProfile);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
