package koossa.texturepacker;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.koossa.logger.Log;

/**
 * Used internally to pack textures into an atlas.
 */
class InternalPackerUtils {

	private static int targetSize = 1024;
	private static List<BufferedImage> images = new ArrayList<BufferedImage>();
	private static List<String> names = new ArrayList<String>();
	private static FilenameFilter filter = new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
			name = name.toLowerCase();
			if (name.endsWith(".png") || name.endsWith(".jpg"))
				return true;
			return false;
		}
	};
	
	/**
	 * Pack the textures.
	 * @param fileIn
	 * @param fileOut
	 * @param targetNamePrefix
	 * @throws IOException
	 */
	public static void pack(File fileIn, File fileOut, String targetNamePrefix) throws IOException {
		File[] imgs = fileIn.listFiles(filter);
		for (int i = 0; i < imgs.length; i++) {
			File file = imgs[i];
			BufferedImage img = ImageIO.read(file);
			images.add(img);
			names.add(file.getName());
		}
		Log.info(InternalPackerUtils.class, "Creating texture atlas: " + targetNamePrefix + "_atlas_#.png containing "
				+ imgs.length + " textures.");
		int pageCounter = 0;
		int index = 0;
		pageCounter = createAtlas(fileOut, targetNamePrefix, pageCounter, index);
		Log.info(InternalPackerUtils.class,
				"Atlas created called " + targetNamePrefix + "_atlas_#.png on " + pageCounter + " pages.");
	}

	/**
	 * Creates the atlas
	 * @param fileOut
	 * @param targetNamePrefix
	 * @param pageCounter
	 * @param index
	 * @return
	 * @throws IOException
	 */
	private static int createAtlas(File fileOut, String targetNamePrefix, int pageCounter, int index)
			throws IOException {
		BufferedImage atlas = new BufferedImage(targetSize, targetSize, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = atlas.createGraphics();
		int cursorX = 0;
		int cursorY = 0;
		int maxHeight = 0;
		for (int i = index; i < images.size(); i++) {
			BufferedImage img = images.get(i);
			if (cursorX + img.getWidth() > targetSize) {
				cursorX = 0;
				cursorY += maxHeight;
			}
			if (cursorY + img.getHeight() > targetSize) {
				break;
			} else {
				g2.drawImage(img, null, cursorX, cursorY);
				
				TexturePacker.atlasData.setTextureInfo(names.get(i), targetNamePrefix + "_atlas_" + pageCounter + ".png",
						(float) cursorX / (float) targetSize, 1.0f - ((float) cursorY / (float) targetSize),
						(float) (cursorX + img.getWidth()) / (float) targetSize, 1 - ((float) (cursorY + img.getHeight()) / (float) targetSize));
				
				cursorX += img.getWidth();
				maxHeight = (img.getHeight() > maxHeight) ? img.getHeight() : maxHeight;
				index++;
			}
		}
		g2.dispose();
		ImageIO.write(atlas, "png", new File(fileOut, targetNamePrefix + "_atlas_" + pageCounter + ".png"));
		pageCounter++;
		if (index < images.size()) {
			pageCounter = createAtlas(fileOut, targetNamePrefix, pageCounter, index);
		}
		return pageCounter;
	}

	/**
	 * Sets the target atlas size.
	 * @param size
	 */
	public static void setTargetSize(AtlasSizes size) {
		targetSize = size.getValue();
	}

}
