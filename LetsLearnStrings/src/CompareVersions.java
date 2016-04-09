/**
 * Created by tgulati on 4/9/16.
 */

/**
 * Compare two version numbers version1 and version2. If version1 >version2 return 1,
 * if version1 <version2 return -1, otherwise return 0.
 */
public class CompareVersions {

    public static void main(String[] args) {
        System.out.println(compare("1.8.0.1", "1.8.0.1.0"));
        System.out.println(compare("1.8.0.1", "1.8.0.1"));
        System.out.println(compare("1.8.0.1", "1.8.0"));
        System.out.println(compare("1.8.0.1", "1.8.0.1.0.1"));
    }

    private static int compare(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        while(i < v1.length || i < v2.length) {
            if(i < v1.length && i < v2.length) {
                if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                } else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    return 1;
                }
            } else if(i < v1.length) {
                if(Integer.parseInt(v1[i]) != 0 )
                    return 1;
            } else if(i < v2.length) {
                if(Integer.parseInt(v2[i]) != 0 )
                    return -11;
            }
            i++;
        }
        return 0;
    }
}
