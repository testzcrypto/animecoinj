package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;
import fr.cryptohash.BLAKE512;
import fr.cryptohash.BMW512;
import fr.cryptohash.Groestl512;
import fr.cryptohash.Skein512;
import fr.cryptohash.Keccak512;
import fr.cryptohash.JH512;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.management.resources.agent_ko;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {
    private static final Logger log = LoggerFactory.getLogger(CoinDefinition.class);

    public static final String coinName = "Anime";
    public static final String coinTicker = "ANI";
    public static final String coinURIScheme = "anime";
    public static final String coinURIScheme2 = "animecoin";
    public static final String coinInternalName = "animecoin";
    public static final String cryptsyMarketId = "71";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "[U6]";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://aniexplorer.cloudapp.net/";
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://aniexplorer.cloudapp.net/";
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";

    public static final String BLOCKEXPLORER_PATH_URL_TEST = "block/";


    public static final String DONATION_ADDRESS = "AdA5nLS5FtPws6A3BX8aXccbP7fReptdw7";  //HashEngineering donation ANI address

    enum CoinHash {
        SHA256,
        scrypt,
        anime
    };
    public static final CoinHash coinHash = CoinHash.anime;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;
    //Original Values
    public static final int TARGET_TIMESPAN = (int)(10 * 240); // 40 minutes
    public static final int TARGET_SPACING = (int)(1 * 30);  // 30 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  // 80 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL*100;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;
    }
    public static int getMaxTimeSpan(int value, int height, boolean testNet)
    {
            return value * 110 / 100;
    }
    public static int getMinTimeSpan(int value, int height, boolean testNet)
    {
            return value / 2;
    }
    public static int spendableCoinbaseDepth = 80; //main.h: static const int COINBASE_MATURITY
    public static BigInteger COIN = BigInteger.valueOf(100000);
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(2500000000L).multiply(COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "2500000000";     //main.h:  MAX_MONEY


    public static BigInteger CENT = BigInteger.valueOf(1000);
    public static BigInteger mCOIN = BigInteger.valueOf(100);

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(10);   // MIN_TX_FEE
    public static final BigInteger DEFAULT_MIN_RELAY_TX_FEE = BigInteger.valueOf(100);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = CoinDefinition.CENT; //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70001;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }

    public static final int Port     = 1212;    //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 2424;	//protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 23;         //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 9;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS

    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0x414e494d;      //unsigned char pchMessageStart[4] = { 0x41, 0x4e, 0x49, 0x4d };

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1390262400L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (13562315);                       //main.cpp: LoadBlockIndex
    static public String genesisHash = "0000099acc274b7b403a828238bad69414e03a1a51b297a250c0a0da8a337840"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 1;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer

    static public String genesisTxInBytes = "04ffff001d01043553687565697368612052657665616c732057696e6e657273206f662053686f6e656e204a756d70204d616e676120436f6e74657374";   //"Shueisha Reveals Winners of Shonen Jump Manga Contest"
    static public String genesisTxOutBytes = "04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "96.43.130.251",
            "91.121.8.23",
            "62.210.151.205",
            "222.78.67.174",
            "5.9.158.79",
            "186.237.174.48",
            "82.117.232.30",
            "151.236.22.84",
            "158.255.208.40",
            "151.236.15.106",
            "91.121.8.23",
            "213.183.56.176",
            "151.236.13.37",
            "115.29.49.156"
    };
    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - animecoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 119;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 199;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x4d494e41;      //0x4d, 0x49, 0x4e, 0x41
    public static final String testnetGenesisHash = "42d48638031294f0d84a027e895c1a321612dc326e6adc7a6c07deb352c";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 978307200L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (906848976);                         //main.cpp: LoadBlockIndex


    static final long _COIN = 100000;
    static final BigInteger nGenesisBlockRewardCoin = BigInteger.valueOf(1 * _COIN);
    static final BigInteger nBlockRewardStartCoin = BigInteger.valueOf(8192 * _COIN);
    static final BigInteger nBlockRewardMinimumCoin = BigInteger.valueOf(8 * _COIN);

    //main.cpp GetBlockValue(height, fee)
    static final BigInteger GetBlockValue(int nHeight)
    {
        if (nHeight == 0)
        {
            return nGenesisBlockRewardCoin;
        }

        BigInteger nSubsidy = BigInteger.valueOf(8192L * 100000L);

        // Subsidy is cut in half every 120960 blocks (42 days)
        //nSubsidy >>= (nHeight / 120960);
        nSubsidy = nSubsidy.shiftRight(nHeight / 120960);

        // Minimum subsidy
        if (nSubsidy.compareTo(nBlockRewardMinimumCoin) < 0)
        {
            nSubsidy = nBlockRewardMinimumCoin;
        }

        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 120960;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "0493e6dc310a0e444cfb20f3234a238f77699806d47909a42481010c5ce68ff04d3babc959cd037bd3aa6ded929f2b9b4aa2f626786cd7f8495e5bb61e9cfebbc4";
    public static final String TESTNET_SATOSHI_KEY = "04218bc3f08237baa077cb1b0e5a81695fcf3f5b4e220b4ad274d05a31d762dd4e191efa7b736a24a32d6fd9ac1b5ebb2787c70e9dfad0016a8b32f7bd2520dbd5";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.anime.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.anime.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.anime.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0, new Sha256Hash("0000099acc274b7b403a828238bad69414e03a1a51b297a250c0a0da8a337840"));
        checkpoints.put( 1, new Sha256Hash("00000c3849197334206d575b9ab34ff04786ab7776ac72424ffed8dfcd3e5a5b"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "AVMP4yDao1tevpAWJ2Rm5jnb8K9NsTtQdt";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "PUyxjvbjofZZQcLTETaqNdWQwstJvMTNc1UybrZFHbGbntZDW1kt";



}
