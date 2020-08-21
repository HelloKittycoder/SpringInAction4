import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shucheng on 2020/7/27 9:21
 * 使用方法：
 * java CopyDocTest "C:\InvestUploadDoc" "E:\InvestUploadDoc"
 * java CopyDocTest "C:/InvestUploadDoc" "E:/InvestUploadDoc"
 */
public class CopyDocTest {

    public static final String DIR_PATH = "C:\\InvestUploadDoc\\";
    private static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) {
        /*List<File> list = findFiles("/", DIR_PATH);
        copyFileList(list, "E:\\InvestUploadDoc");*/

        // copyFileListToDir("C:\\InvestUploadDoc", "E:\\InvestUploadDoc");

        if (args != null && args.length >= 2) {
            copyFileListToDir(args[0], args[1]);
        } else {
            System.out.println("参数个数要为2个");
        }
    }

    public static void copyFileListToDir(String sourceDir, String destinationDir) {
        List<File> list = findFiles("/", sourceDir);
        copyFileList(list, destinationDir);
    }

    // 查找所有子目录下的文件
    public static List<File> findFiles(String filename, String basePath) {
        File tempFile = new File(new File(basePath), filename);
        if (tempFile.isDirectory()) {
            for (File f : tempFile.listFiles()) {
                findFiles(f.getName(), f.getParent());
            }
        } else {
            fileList.add(tempFile);
        }
        return fileList;
    }

    // 将所有文件复制到指定目录下
    public static void copyFileList(List<File> fileList, String destination) {
        File dir = new File(destination);
        if (!dir.exists()) {
            dir.mkdirs();
        } else {
            if (!dir.isDirectory()) {
                throw new RuntimeException("无效目录");
            }
        }

        for (File f : fileList) {
            copyFile(f, new File(destination, f.getName()));
            // System.out.println("sourceFile===" + f + "---------" + "destinationFile===" + new File(destination, f.getName()));
        }
    }

    // 文件复制
    public static void copyFile(File sourceFile, File targetFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);
            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1) {
                fos.write(data, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
