package common;


public class ResourceHelper {

    public static String getResourcePath(String resource) {
        // Get the project path and then append the base path to the location of the resource
        String path = getBaseResourcePath() + resource;
        return path;
    }

    public static String getBaseResourcePath() {
        String basePath = System.getProperty("user.dir");
        return basePath;
    }
//
//    public static void main(String[] args) {
//        String path = ResourceHelper.getBaseResourcePath();
//        System.out.println(path);
//    }
}