package picocli;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/**
 * Created by Grzegorz Chrzaszczyk on 07-12-2018  10:29 PM
 */
@CommandLine.Command(name = "checksum", description = "Prints the checksum (MD5 by default) of a file to STDOUT.")
class CheckSum implements Callable<Void> {

    @CommandLine.Parameters(index = "0", description = "The file whose checksum to calculate.")
    private File file;

    @CommandLine.Option(names = {"-a", "--algorithm"}, description = "MD5, SHA-1, SHA-256, ...")
    private String algorithm = "MD5";

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested;

    public static void main(String[] args) throws Exception {
        // CheckSum implements Callable, so parsing, error handling and handling user
        // requests for usage help or version help can be done with one line of code.
        CommandLine.call(new CheckSum(), System.err, args);
    }

    @Override
    public Void call() throws Exception {
        // your business logic goes here...
        byte[] fileContents = Files.readAllBytes(file.toPath());
        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
        System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(digest));
        return null;
    }
}