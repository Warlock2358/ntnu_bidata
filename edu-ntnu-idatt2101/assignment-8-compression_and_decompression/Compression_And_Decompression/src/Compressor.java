import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Math.abs;

public class Compressor {
    public static void main(String[] args) throws IOException {
        String filename = "src/opg8-kompr.lyx";

        FileOutputStream fileOutputStream = new FileOutputStream(filename + ".comp");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        String input = new String(Files.readAllBytes(Paths.get(filename)));
        compressLZ(input, dataOutputStream);

        fileOutputStream.close();
        dataOutputStream.close();

        System.out.println("File compressed to : " + filename+".comp");

    }

    public static void compressLZ(String input, DataOutputStream dataOutputStream) throws IOException {
        StringBuilder mismatchedSequence = new StringBuilder();
        StringBuilder matchedSequence = new StringBuilder();
        String current;
        char[] inputArray = input.toCharArray();
        int startMatchingIndex;
        int maxLookBack = 0;


        for (int i = 0; i < inputArray.length; i++){
            current = String.valueOf(inputArray[i]);
            String inputSub = input.substring(0, i);
            maxLookBack = i;
            if(containsSubstring(inputSub, current)){
                startMatchingIndex=i;
                StringBuilder testingSequence = new StringBuilder();
                testingSequence.append(current);
                matchedSequence.append(current);
                for (int j = i + 1; j <inputArray.length; j++){
                    testingSequence.append(inputArray[j]);
                    if(i > 255){
                        maxLookBack = 255;
                    }
                    if(containsSubstring(inputSub.substring(i - maxLookBack, i), testingSequence.toString())){
                        matchedSequence.append(inputArray[j]);
                    } else {
                        break;
                    }
                }

            if(matchedSequence.length() <= 3){
                mismatchedSequence.append(matchedSequence);
                i += matchedSequence.length() - 1;
                matchedSequence.delete(0, matchedSequence.length());

            } else {
                dataOutputStream.writeByte(String.valueOf(mismatchedSequence).getBytes().length);
                dataOutputStream.write(String.valueOf(mismatchedSequence).getBytes());
                mismatchedSequence.delete(0, mismatchedSequence.length());
                byte lookBack = (byte) ((byte) abs(input.substring(0,i).lastIndexOf(matchedSequence.toString()) - startMatchingIndex));
                byte nrChars = (byte) matchedSequence.length();
                byte[] bytePair = new byte[]{lookBack, nrChars};
                dataOutputStream.write(bytePair);
                i += matchedSequence.length() - 1;
                matchedSequence.delete(0, matchedSequence.length());
            }


            } else {
                mismatchedSequence.append(current);
            }
        }
        if (!mismatchedSequence.isEmpty()){
            dataOutputStream.writeByte(String.valueOf(mismatchedSequence).getBytes().length);
            dataOutputStream.write(String.valueOf(mismatchedSequence).getBytes());
        }
    }

    private static boolean containsSubstring(String input, String substring){
        return input.contains(substring);
    }
}
