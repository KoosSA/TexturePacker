package koossa.texturepacker;

import java.util.HashMap;
import java.util.Map;

import com.koossa.savelib.ISavable;

/*
 * Holds all the data of subtextures in an atlas.
 */
public class AtlasData implements ISavable {

	private Map<String, TextureInfo> textureInfoMap = new HashMap<String, TextureInfo>();

	/**
	 * Retrieves the texture info of a specific sub-texture.
	 * @param textureName - the name of the sub-texture
	 * @return - the {@link TextureInfo} of the sub-texture
	 */
	public TextureInfo getTextureInfo(String textureName) {
		if (!textureInfoMap.containsKey(textureName)) {
			TextureInfo info = new TextureInfo();
			textureInfoMap.put(textureName, info);
			return info;
		}
		return textureInfoMap.get(textureName);
	}

	/**
	 * Changes the data of a subtexture in the specified atlas. <br> <b> THIS DOES NOT CHANGE THE ATLAS IMAGE </b>
	 * @param textureName - name of texture
	 * @param atlasName - name of atlas
	 * @param texCoordX1 - upper left X coord
	 * @param texCoordY1 - upper left Y coord
	 * @param texCoordX2 - lower right X coord
	 * @param texCoordY2 - lower right Y coord
	 */
	public void setTextureInfo(String textureName, String atlasName, float texCoordX1, float texCoordY1,
			float texCoordX2, float texCoordY2) {
		getTextureInfo(textureName).setAtlasName(atlasName).setTexCoordX1(texCoordX1).setTexCoordY1(texCoordY1)
				.setTexCoordX2(texCoordX2).setTexCoordY2(texCoordY2);
	}
	
}
