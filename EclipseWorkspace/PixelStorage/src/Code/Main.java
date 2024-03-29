package Code;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.io.File;
import java.io.*;

import javax.imageio.ImageIO;

public class Main {

	static String picturePath = System.getProperty("user.home") + File.separator + "Desktop"+ File.separator +"dotted_image.png";
	static String txtOutPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator +"outputTXT.txt";
	static String txtInputPath = System.getProperty("user.home") + File.separator + "Desktop"+ File.separator + "inputTXT.txt";

	public static void main(String[] args) {

		ArrayList<String> binary = readTXTFileToBin(txtInputPath);
		System.out.println("Finished Reading Input!");


		String binaryString = String.join("", binary);

		createImage(binaryString);
		System.out.println("Finished creating Image");

		//Take picture and interpret it 
		ArrayList<String> binaryInterpret = interpretDotmap(1, picturePath);

		String interpretBinary = String.join("", binaryInterpret);

		//Write the binary to file
		writeBinaryToText(interpretBinary, txtOutPath);

		

		System.out.println("Finished");

	}

	public static void writeBinaryToText(String binary, String filePath) {

		StringBuilder textBuilder = new StringBuilder();

		while (binary.length() > 0) {
			if (binary.charAt(0) == '0') {
				// Take the eight bits for encoding
				String bits = binary.substring(0, 8);
				// Slice the part off with the encoded binarys
				binary = binary.substring(8, binary.length());
				// Get the char for the binary
				char c = decodeEightBit(bits);
				textBuilder.append(c);

			} else {

				String bits = binary.substring(0, 8);
				binary = binary.substring(8, binary.length());
				char c = decodeSixteenBit(bits);

				textBuilder.append(c);
			}
		}

		writeDecodedStringToFile(textBuilder.toString(), filePath);
	}

	public static char decodeSixteenBit(String sixteenBitBinary) {
		int code = Integer.parseInt(sixteenBitBinary, 2);

		return (char) code;
	}

	public static char decodeEightBit(String bits) {
		return (char) Integer.parseInt(bits, 2);
	}

	public static void createImage(String binaryCode) {
		char[] code = binaryCode.toCharArray();

		int[] multipliers = findMultipliers(code.length);


		int width = multipliers[0];
		int height = multipliers[1];

		System.out.println(width + " " + height);

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

	public static int[] findMultipliers(int number) {

		int[] multipliers = new int[2];


		ArrayList<Integer> possibleNums = new ArrayList<>();
		ArrayList<Integer> differenz = new ArrayList<>();

		for(int i = 1; i <= Math.sqrt(number); i++){
			if(number % i == 0){
				possibleNums.add(i);
				differenz.add((number/i) - i);
			}
		}

		int minDifIndex = differenz.indexOf(Collections.min(differenz));
		

		multipliers[0] = possibleNums.get(minDifIndex);
		multipliers[1] = number / multipliers[0];

		return multipliers;

	}

	public static ArrayList<String> readTXTFileToBin(String path) {

		ArrayList<String> result = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {

			String line;

			while ((line = reader.readLine()) != null) {

				String lineResult = "";
				for (char c : line.toCharArray()) {
					// Get ASCII from every character in the line and add it
					int ascii = (int) c;

					String binary = Integer.toBinaryString(ascii);

					// Format binary to 8 bit length
					while (binary.length() < 8) {
						binary = "0" + binary;
					}
					// Remove the blank space for the image
					// lineResult += binary + " ";
					lineResult += binary;
				}

				lineResult += "0000" + Integer.toBinaryString(10);

				result.add(lineResult);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static ArrayList<String> interpretDotmap(int dotSize, String path) {

		ArrayList<String> result = new ArrayList<>();

		try {
			BufferedImage image = ImageIO.read(new File(path));

			int width = image.getWidth();
			int height = image.getHeight();

			for (int y = 0; y < height; y += dotSize) {

				StringBuilder lineBinary = new StringBuilder();

				// Curses through every line and collects the data
				for (int x = 0; x < width; x += dotSize) {
					int rgb = image.getRGB(x, y);
					if (rgb == Color.BLACK.getRGB()) {
						lineBinary.append("1");
					} else {
						lineBinary.append("0");
					}
				}
				// End of line
				result.add(lineBinary.toString());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	

	public static void writeDecodedStringToFile(String text, String filepath) {
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(filepath), StandardCharsets.UTF_8))) {
			writer.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
