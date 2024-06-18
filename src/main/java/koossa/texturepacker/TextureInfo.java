package koossa.texturepacker;

/**
 * Stores information regarding the specific sub-texture in an atlas
 */
public class TextureInfo {
	
	private String atlasName;
	private float texCoordX1;
	private float texCoordY1;
	private float texCoordX2;
	private float texCoordY2;
	
	/**
	 * Specifies the specific atlas of where to find the texture
	 * @return the name of the atlas
	 */
	public String getAtlasName() {
		return atlasName;
	}
	
	/**
	 * Sets the atlas name
	 * @param atlasName
	 * @return
	 */
	protected TextureInfo setAtlasName(String atlasName) {
		this.atlasName = atlasName;
		return this;
	}
	
	/**
	 * Gets the top left X coordinate of the texture
	 * @return TOP_LEFT_X_COORDINATE
	 */
	public float getTexCoordX1() {
		return texCoordX1;
	}
	
	/**
	 * Sets the top left X coordinate of the texture
	 * @param texCoordX1
	 * @return
	 */
	protected TextureInfo setTexCoordX1(float texCoordX1) {
		this.texCoordX1 = texCoordX1;
		return this;
	}
	
	/**
	 * Gets the top left Y coordinate of the texture
	 * @return TOP_LEFT_Y_COORDINATE
	 */
	public float getTexCoordY1() {
		return texCoordY1;
	}
	
	/**
	 * Sets the top left Y coordinate of the texture
	 * @param texCoordY1
	 * @return
	 */
	protected TextureInfo setTexCoordY1(float texCoordY1) {
		this.texCoordY1 = texCoordY1;
		return this;
	}
	
	/**
	 * Gets the bottom right X coordinate of the texture
	 * @return BOTTOM_RIGHT_X_COORDINATE
	 */
	public float getTexCoordX2() {
		return texCoordX2;
	}
	
	/**
	 * Sets the bottom right X coordinate of the texture
	 * @return
	 */
	protected TextureInfo setTexCoordX2(float texCoordX2) {
		this.texCoordX2 = texCoordX2;
		return this;
	}
	
	/**
	 * Gets the bottom right Y coordinate of the texture
	 * @return BOTTOM_RIGHT_Y_COORDINATE
	 */
	public float getTexCoordY2() {
		return texCoordY2;
	}
	
	/**
	 * Sets the bottom right Y coordinate of the texture
	 * @return
	 */
	protected TextureInfo setTexCoordY2(float texCoordY2) {
		this.texCoordY2 = texCoordY2;
		return this;
	}
	

}
