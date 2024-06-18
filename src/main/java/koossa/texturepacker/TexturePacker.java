package koossa.texturepacker;

import java.io.File;
import java.io.IOException;

import com.koossa.filesystem.Files;
import com.koossa.logger.Log;
import com.koossa.savelib.SaveSystem;

/**
 * Useful library to pack small textures into an atlas.
 */
public class TexturePacker {
	
	protected static AtlasData atlasData;
	
	/**
	 * Packs textures in specified folder to texture atlas. <br>
	 * The atlas size is determined by the previously called
	 * {@link TexturePacker#setTargetTextureSize(AtlasSizes)} or 1024 if
	 * {@link TexturePacker#setTargetTextureSize(AtlasSizes)} have never been called
	 * before.
	 * 
	 * @param inputFolderPath  - folder path containing the source textures
	 * @param outputFolderPath - folder path to output the atlas to
	 * @param prefixId - unique identifier for the batch of images
	 */
	public static void packTextures(String inputFolderPath, String outputFolderPath, String prefixId) {
		File fileIn = new File(inputFolderPath);
		File fileOut = new File(outputFolderPath);
		TexturePacker.packTextures(fileIn, fileOut, prefixId);
	}

	/**
	 * Packs textures in specified folder to texture atlas. <br>
	 * The atlas size is determined by the previously called
	 * {@link TexturePacker#setTargetTextureSize(AtlasSizes)} or 1024 if
	 * {@link TexturePacker#setTargetTextureSize(AtlasSizes)} have never been called
	 * before.
	 * 
	 * @param fileIn  - folder containing the source textures
	 * @param fileOut - folder to output the atlas to
	 * @param prefixId - unique identifier for the batch of images
	 */
	public static void packTextures(File fileIn, File fileOut, String prefixId) {
		String atlasName = prefixId + "_atlas.json";
		Files.validateFolder(fileOut);
		Files.validateFolder(fileIn);
		try {
			if (atlasData == null) {
				atlasData = SaveSystem.loadFrom(AtlasData.class, fileOut, atlasName);
			}
			InternalPackerUtils.pack(fileIn, fileOut, prefixId);
			atlasData.saveTo(fileOut, atlasName);
		} catch (IOException e) {
			Log.error(TexturePacker.class, "Failed to pack image into atlas with error:");
			Log.error(TexturePacker.class, e.getMessage());
		}
	}

	/**
	 * The new texture atlas size. <br>
	 * Should preferably be a square with dimensions to the power of two.
	 * 
	 * @param size - new texture atlas size (power of 2)
	 */
	public static void setTargetTextureSize(AtlasSizes size) {
		InternalPackerUtils.setTargetSize(size);
	}

}
