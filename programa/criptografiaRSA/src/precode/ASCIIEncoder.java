package precode;

public class ASCIIEncoder {
    private final String input;
    private final int blockSize;

    public ASCIIEncoder(String input, int blockSize) {
        this.input = input;
        this.blockSize = blockSize;
    }

    public String encodeToASCII() {
        StringBuilder encodedText = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            // Format ASCII value to three digits (e.g., '065' for 'A')
            String asciiString = String.format("%03d", (int) character);
            encodedText.append(asciiString);
        }

        return encodedText.toString();
    }

    public String[] splitIntoBlocks() {
        String encodedText = encodeToASCII();

        int length = encodedText.length();
        int blockCount = (length + blockSize - 1) / blockSize;
        String[] blocks = new String[blockCount];

        for (int i = 0; i < blockCount; i++) {
            int startIndex = i * blockSize;
            int endIndex = Math.min(startIndex + blockSize, length);
            blocks[i] = encodedText.substring(startIndex, endIndex);
        }

        return blocks;
    }

}

