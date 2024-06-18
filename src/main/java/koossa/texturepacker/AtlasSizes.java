package koossa.texturepacker;

/**
 * Valid sizes of a texture atlas.
 */
public enum AtlasSizes {
	/** 16 x 16 pixels */
	_16(16),
	/** 32 x 32 pixels */
	_32(32),
	/** 64 x 64 pixels */
	_64(64),
	/** 128 x 128 pixels */
	_128(128),
	/** 256 x 256 pixels */
	_256(256),
	/** 512 x 512 pixels */
	_512(512),
	/** 1024 x 1024 pixels */
	_1024(1024),
	/**
	 * 2048 x 2048 pixels <br>
	 * <b> Not recommended for performance </b>
	 */
	_2048(2048),
	/**
	 * 4096 x 4096 pixels <br>
	 * <b> Not recommended for performance </b>
	 */
	_4096(4096);

	private final int value;

    private AtlasSizes(final int newValue) {
        value = newValue;
    }

    /**
     * Gets the associated size value of the enumeration.
     * @return
     */
    public int getValue() { return value; }
	

}
