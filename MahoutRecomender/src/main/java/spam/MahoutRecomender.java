package spam;

/**
 *
 * @author Gustavo
 */
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class MahoutRecomender {
    
    public static void main(String[] args) throws IOException, TasteException {
        
        File dataFile=new File("C:\\Users\\Gustavo\\Downloads\\MahoutSet\\input.csv");
        DataModel dataModel=new FileDataModel(dataFile);
        
        UserSimilarity similarity=new PearsonCorrelationSimilarity(dataModel);
        UserNeighborhood neighborhood=new NearestNUserNeighborhood(2, similarity, dataModel);
        
        Recommender recommender=new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
        
        List recommendations = recommender.recommend(1, 1);
        
        recommendations.forEach((recommendedItem) -> {
            System.out.println(" recommendation: " + recommendedItem);
        });
        
    }
}
