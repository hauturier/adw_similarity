package sim;

import it.uniroma1.lcl.adw.LexicalItemType;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class main {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        ADWSimilarity adwsimilarity = new ADWSimilarity();
        File file = new File("data/word/entity2id.txt");
        String InputFileName = args[0];
        String OutputFileName = args[1];
        //String InputFileName = "SingleWordFinal_3.txt";
        //String OutputFileName = "similaritysinglefinal26.txt";
        String OutputNotInWordnetName = "notInWordNet.txt";
        file.readFile(InputFileName);
        ArrayList<String> RList = new ArrayList<String>();
        for (int i = 0; i < file.word_list.size(); i++) {
            String lexicon_String = file.word_list.get(i);
            if (!adwsimilarity.InWordNet(lexicon_String, LexicalItemType.WORD_SENSE)) {
                System.out.println(lexicon_String + "is not in WordNet.");
                continue;
            }
            RList.add(lexicon_String);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(OutputFileName), "UTF-8"));
        int word_count = file.wordmap.size();
        double[][] sim_matrix = new double[word_count][word_count];

        for (int i = 0; i < RList.size(); i++) {
            String lexicon_iString = RList.get(i);
            int idx1 = file.wordmap.get(lexicon_iString);
            for (int j = i + 1; j < RList.size(); j++) {
                String lexicon_jString = RList.get(j);
                int idx2 = file.wordmap.get(lexicon_jString);
                double similarity = adwsimilarity.Similarity(lexicon_iString, lexicon_jString,
                        LexicalItemType.WORD_SENSE, LexicalItemType.WORD_SENSE);
                sim_matrix[idx1][idx2] = similarity;
            }
        }
    }
}