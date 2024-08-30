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


}
