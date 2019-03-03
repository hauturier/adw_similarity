package sim;

import it.uniroma1.lcl.adw.ADW;
import it.uniroma1.lcl.adw.DisambiguationMethod;
import it.uniroma1.lcl.adw.LexicalItemType;
import it.uniroma1.lcl.adw.comparison.SignatureComparison;
import it.uniroma1.lcl.adw.comparison.WeightedOverlap;

public class ADWSimilarity {

    ADW pipeLine ;
    //measure for comparing semantic signatures
    SignatureComparison measure ;
    public ADWSimilarity(){
        pipeLine = new ADW();
        measure = new WeightedOverlap();
    }

    //calculate the similarity of text1 and text2
    public boolean InWordNet(String text, LexicalItemType textType ){
//    	if(pipeLine.evaluateInputType(text, textType).getFirst()==false){
//        	System.out.println(text+" is not defined in WordNet");
//        }
        return pipeLine.evaluateInputType(text, textType).getFirst();
    }

    public double Similarity(String text1,String text2, LexicalItemType text1Type, LexicalItemType text2Type){

        double similarity = pipeLine.getPairSimilarity(
                text1, text2,
                DisambiguationMethod.NONE,
                measure,
                text1Type, text2Type);
        //print out the similarity
        //System.out.println(similarity);
        return similarity;
    }

    public static void main(String[] args) {
        ADW pipeLine = new ADW();

        //the two lexical items
        String text1 = "a mill that is powered by the wind";
        String text2 = "windmill#n rotate#v wind#n";

        //types of the lexical items (set as auto-detect)
        LexicalItemType text1Type = LexicalItemType.SURFACE;
        LexicalItemType text2Type = LexicalItemType.SURFACE_TAGGED;

        //measure for comparing semantic signatures
        SignatureComparison measure = new WeightedOverlap();

        //calculate the similarity of text1 and text2
        double similarity = pipeLine.getPairSimilarity(
                text1, text2,
                DisambiguationMethod.ALIGNMENT_BASED,
                measure,
                text1Type, text2Type);

        //print out the similarity
        System.out.println(similarity);
    }

}
