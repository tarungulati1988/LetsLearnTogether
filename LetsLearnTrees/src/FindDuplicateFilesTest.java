import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tgulati on 2/23/17.
 */

/**
 * basic tests for the duplicate file finder implementation
 * I am currently using paths on my machine.
 * We should be mocking the file class(EasyMock, PowerMock),
 * this is to show the tests that are needed currently for the implementation.
 *
 */
public class FindDuplicateFilesTest {

    private static MessageDigest shaDigest;
    private static final String SHA_512 = "SHA-512";

    static {
        try {
            shaDigest = MessageDigest.getInstance(SHA_512);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-512 hash function cannot be initialized", e);
        }
    }

    FindDuplicateFiles findDuplicateFiles = new FindDuplicateFiles();


    @Test(description = "provided a valid directory path return true")
    public void testValidDirectoryPath() {
        Assert.assertTrue(findDuplicateFiles.isADirectoryPath("/Users/tgulati/Documents/"));
    }

    @Test(description = "provided a valid file path return false")
    public void testNotValidDirectoryPathGivenFilePath() {
        Assert.assertFalse(findDuplicateFiles.isADirectoryPath("/Users/tgulati/Library/Caches/IntelliJIdea15/temp-testng-customsuite.xml"));
    }

    @Test(description = "provided a empty string return false")
    public void testNotValidDirectoryPathGivenEmptyString() {
        Assert.assertFalse(findDuplicateFiles.isADirectoryPath(""));
    }

    @Test(description = "provided a invalid string return false")
    public void testNotValidDirectoryPathGivenInvalidString() {
        Assert.assertFalse(findDuplicateFiles.isADirectoryPath(" lorem ipsum"));
    }

    @Test(description = "provided a root path return")
    public void testValidDirectoryPathGivenRoot() {
        Assert.assertTrue(findDuplicateFiles.isADirectoryPath("/"));
    }

    @Test(description = "provided a invalid directory path return false")
    public void testNotValidDirectoryPathGivenIncorrectDirectoryPath() {
        Assert.assertFalse(findDuplicateFiles.isADirectoryPath("/Users/tgulati/loremIpsum"));
    }

    @Test(description = "provided a file/path without a symlink, will return false")
    public void testIsSymLinkForNoCycle() throws IOException {
        File file = new File("/Users/tgulati/Documents");
        Assert.assertFalse(findDuplicateFiles.isSymlink(file));
    }

    @Test(description = "provided a file/path with a symlink, will return true")
    public void testIsSymLinkForCycle() throws IOException {
        File file = new File("/Users/tgulati/Documents/temp/temp2/temp3/temp4/temp3");
        Assert.assertTrue(findDuplicateFiles.isSymlink(file));
    }

    @Test(description = "provided a valid argument, validate it and return true")
    public void testIsArgumentValid() {
        String[] args = new String[]{"/"};
        Assert.assertTrue(findDuplicateFiles.isArgumentValid(args));
    }

    @Test(description = "provided a invalid argument, validate it and return false")
    public void testIsArgumentValidEmptyArgument() {
        Assert.assertFalse(findDuplicateFiles.isArgumentValid(new String[0]));
    }

    @Test(description = "provided a null argument, validate it and return false")
    public void testIsArgumentValidNullArgument() {
        Assert.assertFalse(findDuplicateFiles.isArgumentValid(null));
    }

    @Test(description = "provided a multiple arguments, validate it and return false")
    public void testIsArgumentValidMultipleArgument() {
        String[] args = new String[]{"/", "/"};
        Assert.assertFalse(findDuplicateFiles.isArgumentValid(args));
    }

    @Test(description = "provided a valid directory path and a hashing algorithm, return a unique hash")
    public void testGetFileChecksum() throws IOException {
        String hash = findDuplicateFiles.getFileChecksum(shaDigest, new File("/Users/tgulati/Library/Caches/IntelliJIdea15/temp-testng-customsuite.xml"));
        Assert.assertEquals("d7b7229bb3e62b9cd27b7b444e101f8b4854b0be0321db634f70f5f3d925476e1e431b55b4e858f75f1f451deef810d47501ec3fd025ce33ac4793b9d9f527d6", hash);
    }
}
