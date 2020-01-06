package com.bzhong7.labs.dswopapp.Main;


import android.app.Application;
import android.os.AsyncTask;

import com.bzhong7.labs.dswopapp.ethWrapper.ExampleToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.tx.gas.DefaultGasProvider;

public class EthNetwork extends AsyncTask<Void, Void, String> {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    private String nodeURL = "infura url goes here";
    private String privateKey = "private key from wallet";
    private String erc721Address = "address that generates NFT tokens";
    private String publicAccAddress = "0xF214f19Cbf969C6a5Fab6bB0762b94bb0d498f71";


    private Web3j web3;
    private Credentials creds;
    private ExampleToken exampleContract;
    private String contractAddress;
    private DefaultGasProvider gasProvider;
    private String accountAddress;

    private String txHash;

    private TransactionReceipt transactionReceipt;


    public EthNetwork() {
        web3 = Web3j.build(new HttpService(nodeURL));
        creds = Credentials.create(privateKey);
        contractAddress = erc721Address;
        gasProvider = new DefaultGasProvider();
        accountAddress = publicAccAddress;

        exampleContract = ExampleToken.load(contractAddress, web3, creds, gasProvider);
    }

    public void mintToken() throws Exception {
        transactionReceipt = exampleContract.mintUniqueToken(accountAddress, "EXT").send();
    }

    protected String doInBackground (Void... params) {
        try {
            mintToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTxHash() {
        txHash = transactionReceipt.getTransactionHash();
        return txHash;
    }
}