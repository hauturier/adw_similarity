package sim;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class File {
    ArrayList<String> word_list;
    Map<String, Integer> wordmap;

    public File(String word2id_path) {
        // TODO Auto-generated constructor stub
        word_list = null;
        wordmap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(word2id_path), "UTF-8"));
            String line = "";
            while ((line=reader.readLine())!=null) {
                String[] arr = line.split("\t");
                if (arr.length != 2) {
                    System.out.println("Error in Line: " + line);
                    continue;
                }
                wordmap.put(arr[0], Integer.valueOf(arr[1]));
            }
        }
        catch (IOException e) {
        }
    }

    public void readFile(String InputFile) throws IOException {
        word_list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(InputFile);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String line = "";
        while ((line = br.readLine()) != null) {
            if (line.equals("")) {
                continue;
            }
            word_list.add(line);
        }
        br.close();
        isr.close();
        fis.close();
    }

    public void writeFile(String OutputFile, String content) throws IOException {
        if (null == word_list) {
            System.out.println("file not read");
            return;
        }
        FileWriter writer = new FileWriter(OutputFile, true);
        writer.write(content);
        writer.close();
    }

}
