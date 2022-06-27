package frame;

import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;

public class WorkWithFiles extends Browser{


    public File findDownloadedFile(String fileName) {
        File steamFileDir = new File(Paths.get("").toAbsolutePath().toString());

        boolean flag = false;
        File downloadedFile = null;
        for (int i = 0; i < Integer.parseInt(getTimeoutForDownloadFile()); i++) {
            File[] steamFileDirList = steamFileDir.listFiles();
            for (int j = 0; j < steamFileDirList.length; j++) {
                if (steamFileDirList[j].getName().equals(fileName)) {
                    flag = true;
                    downloadedFile = steamFileDirList[j];
                    break;
                }
            }
            if (!flag) {
                //waitForElement();
            } else break;
        }
        return downloadedFile;
    }

    public void checkFileNameAndKill(String fileName) {
        Assert.assertEquals(findDownloadedFile(fileName).getName(), fileName);
        if (findDownloadedFile(fileName).delete()) {
            System.out.println("Downloaded file deleted");
        } else System.out.println("Downloaded file is not deleted");
    }

}
