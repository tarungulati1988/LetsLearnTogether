/**
 * Created by tgulati on 2/23/17.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Assumptions:
 * ------------
 * 1. a file is duplicate only based on its content,
 * file names can be the same but the content can differ
 *
 * 2. Files aren't duplicate if they have the same name
 *
 * 3. Do a depth first search through the directory path provided and build a map.
 * The key will be the unique hash generated from the content of the file.
 * The value will be a list containing the file(s) if they have the same hash
 * Multiple files having the same hash means that they are duplicate.
 *
 *
 * 4. In the process of iterating through the list of directories we
 * need to check for symlinks as they will lead to infinite loops
 *
 * 5. We can further improve the duplicate checks by incorporating
 * the file creation dates into the hash generated.
 * For the scope fo the problem we only use the contents of the file.
 *
 * 6. The set will contain all the duplicate files(the path is stored as a string)
 */
public class FindDuplicateFiles {

    //Use SHA-512 algorithm
    private static MessageDigest shaDigest;
    private static final String SHA_512 = "SHA-512";

    static {
        try {
            shaDigest = MessageDigest.getInstance(SHA_512);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-512 hash function cannot be initialized", e);
        }
    }

    public static void main(String[] args) {

        FindDuplicateFiles findDuplicateFiles = new FindDuplicateFiles();

        // check for the validity of the incoming argument(s)

        // instead of reading args as such, we can integrate JCommader to do
        // the same for us and have validation checks in place
        if (!findDuplicateFiles.isArgumentValid(args)) {
            throw new IllegalArgumentException("Incorrect argument passed");
        }

        // map to contain the unique hash as the key and a list of file names if there are duplicates
        Map<String, List<String>> mapOfFiles = findDuplicateFiles.findDuplicateFiles(args[0]);
        Set<String> setOfDuplicateFiles = new HashSet<>();

        mapOfFiles.entrySet().stream().filter(entry -> entry.getValue().size() > 1).forEach(entry -> {
            entry.getValue().forEach((x) -> setOfDuplicateFiles.add(x));
        });

        setOfDuplicateFiles.forEach(System.out::println);
    }

    /**
     * This method initiates the depth first search for the duplicate files
     *
     * @param directory
     *          The directory path specified in the runtme argument
     * @return filesMap
     *          key - unique hash for each file based on its content and not the name
     *          value - list of file(s) that have the same hash
     *          multiple files having the same hash mean that they are duplicates
     */
    protected Map<String, List<String>> findDuplicateFiles(String directory) {
        Map<String, List<String>> filesMap = new HashMap<>();
        File directoryPath = new File(directory);
        findDuplicateFilesRecursively(filesMap, directoryPath);
        return filesMap;
    }

    /**
     * Recursively call itself again if the directory contains a sub directory
     * if not, then calculate the file hash and store it in the map
     * Need to check for symlinks of a directory as they can create an infinite loop
     * @param filesMap
     * @param directory
     */
    private void findDuplicateFilesRecursively(Map<String, List<String>> filesMap, File directory) {
        for (File childDirectory : directory.listFiles()) {
            // check if the child path is a directory
            if (childDirectory.isDirectory()) {
                try {
                    // check if a symlink exists
                    // need to check to avoid cycles/loops that can cause infinite loops
                    if (!isSymlink(directory)) {
                        findDuplicateFilesRecursively(filesMap, childDirectory);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Cannot read file: " + childDirectory.getAbsolutePath(), e);
                }
            } else {
                // calculate the hash using the message digest algorithm
                // update the map with the hash and the file path
                try {
                    String fileHash = getFileChecksum(shaDigest, childDirectory);
                    List<String> duplicateFileList = filesMap.get(fileHash);
                    if (duplicateFileList == null) {
                        duplicateFileList = new ArrayList<>();
                    }
                    duplicateFileList.add(childDirectory.getAbsolutePath());
                    filesMap.put(fileHash, duplicateFileList);
                } catch (IOException e) {
                    throw new RuntimeException("Cannot read file: " + childDirectory.getAbsolutePath(), e);
                }
            }
        }
    }

    /**
     * Given the incoming argument(s), validates and returns a boolean if correct or not
     * @param arguments
     * @return
     */
    protected boolean isArgumentValid(String[] arguments) {
        if (arguments == null || arguments.length != 1) {
            return false;
        }
        String directoryPath = arguments[0];
        if (isADirectoryPath(directoryPath)) {
            return true;
        }
        return false;
    }

    /**
     * Given a directory path returns true if the path is a directory path and valid
     *
     * @param directoryPath
     * @return
     */
    protected boolean isADirectoryPath(String directoryPath) {

        File file = new File(directoryPath);
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
        }
        return false;
    }


    /**
     * Given a message digest algorithm and a file path, calculate its
     * unique hash in byte and convert it to string to be used as key to the map
     * @param messageDigest
     * @param filePath
     * @return
     * @throws IOException
     */
    protected String getFileChecksum(MessageDigest messageDigest, File filePath) throws IOException {
        // get file input stream for reading the file content
        FileInputStream fileInputStream = new FileInputStream(filePath);

        // create byte array to read the file content in chunks
        byte[] byteArr = new byte[1024];
        int bytesCount = 0;

        // read  the file daya and update the messagedigest
        while ((bytesCount = fileInputStream.read(byteArr)) != -1) {
            messageDigest.update(byteArr, 0, bytesCount);
        }

        fileInputStream.close();

        // get the hash that has been generated for the file by the message digest algorithm
        byte[] bytes = messageDigest.digest();

        // the hash returned in bytes has bytes in decimal format,
        // convert it to hex format to convert to a string
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }


    /**
     * Given a file, isSymlink returns true if the directory/file is
     * a symlink to another folder
     * @param file
     * @return
     * @throws IOException
     */
    protected boolean isSymlink(File file) throws IOException {
        File canonicalPath;
        if (file.getParent() == null) {
            canonicalPath = file;
        } else {
            File canonDir = file.getParentFile().getCanonicalFile();
            canonicalPath = new File(canonDir, file.getName());
        }
        return !canonicalPath.getCanonicalFile().equals(canonicalPath.getAbsoluteFile());
    }
}
