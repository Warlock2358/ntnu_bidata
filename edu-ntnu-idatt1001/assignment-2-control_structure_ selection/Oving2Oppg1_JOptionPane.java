package Java.Oving2;

import static javax.swing.JOptionPane.*;

/**
 * Oving2Oppg1
 */
public class Oving2Oppg1_JOptionPane {
   public static void main(String[] aStrings) {
      String in = showInputDialog("Skriv et år her:");
      int årstall = Integer.parseInt(in);

      String skuddår = årstall + " er et skuddår";
      String ikkeskuddår = årstall + " er ikke et skuddår";
      if (årstall % 100 == 0) {
         if (årstall % 400 == 0)
            showMessageDialog(null, skuddår);
         else
            showMessageDialog(null, ikkeskuddår);
      } else if (årstall % 4 == 0)
         showMessageDialog(null, skuddår);
      else
         showMessageDialog(null, ikkeskuddår);
   }
}