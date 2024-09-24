import java.io.*;

public class Decompressor_V2 {

    public static void main(String[] args) throws IOException {
        String filename = "src/opg8-kompr.lyx.comp";
        FileInputStream fileInputStream = new FileInputStream(filename);
        String decompressedText = decompress(fileInputStream);
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".de"));
        writer.write(decompressedText);
        writer.close();
    }

    public static String decompress(FileInputStream fileInputStream) throws IOException {
        StringBuilder textToBeWritten = new StringBuilder();
        int initialByte = fileInputStream.read();

        ByteArrayOutputStream charBuffer = new ByteArrayOutputStream();
        int byteRead = 0;

        while(charBuffer.size() < initialByte){
            byteRead = fileInputStream.read();
            charBuffer.write(byteRead);
        }
        textToBeWritten.append(charBuffer);
        charBuffer.reset();


        boolean endOfFile = false;

        while (!endOfFile){
            int lookBackByte = fileInputStream.read();
            int nrCharsByte = fileInputStream.read();
            int upcomingByte = fileInputStream.read();

            if (lookBackByte == -1){
                endOfFile = true;
                break;
            }

            textToBeWritten.append(textToBeWritten.substring
                    (textToBeWritten.length() - lookBackByte,
                            textToBeWritten.length() - lookBackByte + nrCharsByte));

            while(charBuffer.size() < upcomingByte){
                byteRead = fileInputStream.read();
                charBuffer.write(byteRead);
            }

            textToBeWritten.append(charBuffer);
            charBuffer.reset();

        }
        return String.valueOf(textToBeWritten);
    }

}
