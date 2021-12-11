package masterMind.models;

public enum Color {
	RED, 
	BLUE, 
	GREEN, 
	PURPLE, 
	BROWN, 
	YELLOW, 
	PINK, 
	WHITE, 
	GREY, 
	BLACK;

	public static Color getColor(String string) {
		for (Color color : Color.values()) {
			if (color.name().equals(string)) {
				return color;
			}
		}
		assert false;
		return null;
	}

	public static Color[] getFirstColors(int amount) {
		Color[] colors = new Color[amount];
		for (int i = 0; i < colors.length; i++) {
			colors[i] = Color.values()[i];
		}
		return colors;
	}

}
