package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.KoreDemoAccount;

public class JsonDataReader {
    private final String accountFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "KoreDemoAccount.json";
    private List<KoreDemoAccount> koreDemoAccountList;

    public JsonDataReader() {
        koreDemoAccountList = getAccountData();
    }

    private List<KoreDemoAccount> getAccountData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(accountFilePath));
            KoreDemoAccount[] koreDemoAccounts = gson.fromJson(bufferReader, KoreDemoAccount[].class);
            return Arrays.asList(koreDemoAccounts);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + accountFilePath);
        } finally {
            try {
                if (bufferReader != null) bufferReader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public final KoreDemoAccount getUsernameByUsername(String username) {
        return koreDemoAccountList.stream().filter(x -> x.username.equalsIgnoreCase(username)).findAny().get();
    }
}
