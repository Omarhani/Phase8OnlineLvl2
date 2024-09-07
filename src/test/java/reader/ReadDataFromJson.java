package reader;

import com.google.gson.Gson;
import data.DataModal;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJson {

    public DataModal readJsonFile() throws FileNotFoundException {

        FileReader fileReader = new FileReader("data/testData.json");

        DataModal dataModal = new Gson().fromJson(fileReader, DataModal.class);

        return dataModal;
    }

    public static DataModal dataModal() throws FileNotFoundException {
        ReadDataFromJson readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile();
    }


}
