package com.quintus.labs.datingapp.Main;

import io.github.cdimascio.dotenv.Dotenv;

import android.app.Application;
import android.os.AsyncTask;

import com.quintus.labs.datingapp.ethWrapper.ExampleToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.web3j.abi.datatypes.Address;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.tx.gas.DefaultGasProvider;

public class EthNetwork extends AsyncTask<Void, Void, String> {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    Dotenv dotenv = Dotenv.load();

    private String nodeURL = dotenv.get("ROPSTEN_NODE");
    private String privateKey = dotenv.get("ROPSTEN_PRIVATE_KEY");
    private String erc721Address = dotenv.get("ERC721_ADDRESS");
    private String publicAccAddress = "0xF214f19Cbf969C6a5Fab6bB0762b94bb0d498f71";


    private Web3j web3;
    private Credentials creds;
    private ExampleToken exampleContract;
    private String contractAddress;
    private DefaultGasProvider gasProvider;
    private String accountAddress;


    public EthNetwork() {
        web3 = Web3j.build(new HttpService(nodeURL));
        creds = Credentials.create(privateKey);
        contractAddress = erc721Address;
        gasProvider = new DefaultGasProvider();
        accountAddress = publicAccAddress;

        exampleContract = ExampleToken.load(contractAddress, web3, creds, gasProvider);
    }

    public String mintToken() throws Exception {
        TransactionReceipt transactionReceipt = exampleContract.mintUniqueToken(accountAddress, "EXT").send();
        String txHash = transactionReceipt.getTransactionHash();
        return txHash;
    }

    protected String doInBackground (Void... params) {
        try {
            return mintToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}