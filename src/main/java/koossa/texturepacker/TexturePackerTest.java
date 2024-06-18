package koossa.texturepacker;

import com.koossa.filesystem.CommonFolders;
import com.koossa.filesystem.Files;
import com.koossa.filesystem.RootFileLocation;
import com.koossa.logger.Log;
import com.koossa.savelib.SaveSystem;

/**
 * Used to test the texture packer library. Do not implement or use.
 */
@Deprecated
class TexturePackerTest implements Runnable {
	
	public static void main(String[] args) {
		new Thread(new TexturePackerTest()).start();
	}

	@Override
	public void run() {
		Files.init("Assets", RootFileLocation.LOCAL);
		Log.init(Files.getCommonFolder(CommonFolders.Logs), true);
		SaveSystem.init(Files.getFolder("Gui/packed"), Files.getCommonFolder(CommonFolders.Gui));
		
		TexturePacker.setTargetTextureSize(AtlasSizes._256);
		TexturePacker.packTextures(Files.getCommonFolder(CommonFolders.Saves), Files.getCommonFolder(CommonFolders.Gui), "gui");
		
		Log.dispose(); 
	}

}
