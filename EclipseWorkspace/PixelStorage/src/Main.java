import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.*;

import javax.imageio.ImageIO;

public class Main {

	static String picturePath = System.getProperty("user.home") + "/Desktop/dotted_image.png";
	static String txtOutPath = System.getProperty("user.home") + "/Desktop/outputTXT.txt";

	public static void main(String[] args) {

		ArrayList<String> binary = readTXTFileT0Bin();
		
		for(String s : binary) {
			System.out.println(s);
		}
		
		System.out.println(binary.size());
		
		//int[] numbs = findMultipliers(binary.length());
		

		//createImage(binary);
		
		
		//String text = convertBinaryToText(binary);
	
		//writeTextToFile(text, txtOutPath);

		System.out.println("Finished");

	}
	
	public static void writeTextToFile(String text, String filePath) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        writer.write(text);
	        System.out.println("Text written to file successfully.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public static void createImage(String binaryCode) {
		char[] code = binaryCode.toCharArray();

		int[] multipliers = findMultipliers(code.length);

		int width = multipliers[0];
		int height = multipliers[1];
		
		

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D graphics = image.createGraphics();

		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);

		graphics.setColor(Color.BLACK);
		int dotSize = 1;

		int index = 0;

		for (int i = 0; i < height; i += dotSize) {
	        for (int j = 0; j < width; j += dotSize) {
	            if (code[index] == '1') {
	                graphics.fillRect(j, i, dotSize, dotSize);
	            }
	            index++;
	        }
	    }

		graphics.dispose();

		try {
			File output = new File(picturePath);
			ImageIO.write(image, "png", output);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int[] findMultipliers(int evenNumber) {
		if (evenNumber % 2 != 0) {
			// Check if the number is not even
			return null;
		}

		int highestMultiplier1 = 1;
		int highestMultiplier2 = evenNumber;

		for (int i = 2; i <= Math.sqrt(evenNumber); i++) {
			if (evenNumber % i == 0) {
				int quotient = evenNumber / i;
				if (i > highestMultiplier1) {
					highestMultiplier1 = i;
					highestMultiplier2 = quotient;
				} else if (i == highestMultiplier1 && quotient > highestMultiplier2) {
					highestMultiplier2 = quotient;
				}
			}
		}

		if (highestMultiplier1 == 1 && highestMultiplier2 == evenNumber) {
			// No proper multipliers found
			return null;
		}

		return new int[] { highestMultiplier1, highestMultiplier2 };

	}

	public static ArrayList<String> readTXTFileT0Bin() {
		

		String filePath = "C:/Users/brand/Desktop/test.txt";

		ArrayList<String> result = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(filePath), StandardCharsets.ISO_8859_1))) {
			
			
			String line;
			
			while ((line = reader.readLine()) != null) {
			
				String lineResult = "";
				for (char c : line.toCharArray()) {
					//Get ascii from every character in the line and add it
					int ascii = (int) c;
					
					lineResult += (Integer.toBinaryString(ascii) + " ");
				}
				
				lineResult += "00" + Integer.toBinaryString(10);
				
				result.add(lineResult);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String interpretDotmap(int dotSize) {
		StringBuilder result = new StringBuilder();

		try {
			BufferedImage image = ImageIO.read(new File(picturePath));

			int width = image.getWidth();
			int height = image.getHeight();

			for (int y = 0; y < height; y += dotSize) {
				for (int x = 0; x < width; x += dotSize) {
					int rgb = image.getRGB(x, y);
					if (rgb == Color.BLACK.getRGB()) {
						result.append("1");
					} else {
						result.append("0");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return convertBinaryToString(result.toString());
	}

	public static void writeTXTFile(String binaryCode) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtOutPath))) {
			int length = binaryCode.length();

			for (int i = 0; i < length; i += 8) {
				String byteString = binaryCode.substring(i, Math.min(i + 8, length));
				int byteValue;
				try {
					byteValue = Integer.parseInt(byteString, 2);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					continue; // Skip invalid characters
				}
				writer.write(convertIntToChar(byteValue));
			}

			System.out.println("Characters written to file successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String convertBinaryToString(String binary) {
		StringBuilder stringBuilder = new StringBuilder();
		int length = binary.length();
		for (int i = 0; i < length; i += 8) {
			String byteString = binary.substring(i, Math.min(i + 8, length));
			int byteValue;
			try {
				byteValue = Integer.parseInt(byteString, 2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				continue; // Skip invalid characters
			}
			stringBuilder.append(convertIntToChar(byteValue));
		}
		return stringBuilder.toString();
	}

	private static char convertIntToChar(int value) {
		if (value < 0 || value > 255) {
			throw new IllegalArgumentException("Invalid ASCII value: " + value);
		}
		return (char) value;
	}
	
	/*public static String convertBinaryToText(String binaryCode) {
	    StringBuilder result = new StringBuilder();

	    StringBuilder chunk = new StringBuilder();
	    for (int i = 0; i < binaryCode.length(); i++) {
	        char c = binaryCode.charAt(i);
	        chunk.append(c);
	        if (chunk.length() == 8) {
	            if (!chunk.toString().equals("00000000")) {
	                int charCode = Integer.parseInt(chunk.toString(), 2);
	                result.append((char) charCode);
	            }
	            chunk.setLength(0);
	        }
	    }

	    return result.toString();
	}*/


}
