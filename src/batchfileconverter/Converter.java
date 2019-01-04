package batchfileconverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;

public class Converter {

    public String convert(String input_file, String output_folder, String batch_size_str, String file_extension) throws IOException {

        String file_data = "";
        File file = new File(input_file);
        String input_file_name = FilenameUtils.removeExtension(file.getName());
        output_folder += "\\";
        int batch_size = Integer.parseInt(batch_size_str);
        int line_count = 0;
        int file_count = 1;
        FileWriter fw;
        try (BufferedReader br = new BufferedReader(new FileReader(input_file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line_count++;
                file_data += line + "\n";
                //System.out.println("" + (line_count % batch_size));
                if ((line_count % batch_size) == 0) {
                    //File batchFile = new File();
                    //batchFile.getParentFile().mkdirs();
                    fw = new FileWriter(output_folder + input_file_name + "_" + file_count + file_extension);
                    fw.write(file_data);
                    fw.flush();
                    fw.close();
                    file_count++;
                    file_data = "";
                }
            }
            fw = new FileWriter(output_folder + input_file_name + "_" + file_count + file_extension);
            fw.write(file_data);
            fw.flush();
            fw.close();
        } catch (FileNotFoundException fileException) {
            return "Source File Not present";
        }
        return "SUCCESS";
    }
}
