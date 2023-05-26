package Code;

import java.io.File;

public class Utils {

	
	
	public static String getFileExtension(String filePath) {
        File file = new File(filePath);
        String extension = "";

        if (file.isFile()) {
            String fileName = file.getName();
            int lastDotIndex = fileName.lastIndexOf('.');

            if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {
                extension = fileName.substring(lastDotIndex + 1);
            }
        }

        return extension;
    }

	public static boolean checkInput() {
		if(GUI.inputFilePath != null && GUI.outputFolderPath != null) {
			return true;
		}
		return false;
	}
}
